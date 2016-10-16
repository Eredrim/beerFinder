/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gmjgav;

import fr.gmjgav.model.Bar;
import fr.gmjgav.model.Coordinates;
import fr.gmjgav.repository.BarRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Param;
import se.walkercrou.places.Place;
/**
 *
 * @author Gilles
 */
public class GooglePlacesManager {
    private static final GooglePlaces GOOGLE_CLIENT = new GooglePlaces("AIzaSyDfA3smjbhDYeXYPe6anqbH4yIKSF1VkAA");
    private static final int RADIUS = 300;
    private static final int LIMIT = 20;
    
    public static ListAndStatus getPlaces(BarRepository barRepository, Coordinates coord){
        HttpStatus responseCode = HttpStatus.OK;
        List<Place> places = GOOGLE_CLIENT.getNearbyPlaces(coord.getLat(), coord.getLng(), RADIUS, LIMIT, Param.name("types").value("bar"));
        List<Bar> createdBars = new ArrayList<>();
        for(Place tmpPlace : places){
            if(barRepository.findByReference(tmpPlace.getPlaceId()).isEmpty()){
                Bar generatedBar = new Bar(tmpPlace.getName(), tmpPlace.getPlaceId());
                createdBars.add(generatedBar);
            }
        }
        if(!createdBars.isEmpty()){
            responseCode = HttpStatus.CREATED;
            barRepository.save(createdBars);
        }

        return new ListAndStatus(places, responseCode);
    }
    
    public static List<Place> getPlaces(Coordinates coord){
        return GOOGLE_CLIENT.getNearbyPlaces(coord.getLat(), coord.getLng(), RADIUS, LIMIT, Param.name("types").value("bar"));
    }
    
    public static ListAndStatus intersectBarsAndPlaces(List<Bar> lstBars, BarRepository barRepository, Coordinates coord){
        ListAndStatus placesAndStatus = getPlaces(barRepository, coord);
        List<Place> lstPlaces = (List<Place>) placesAndStatus.getList();
        List<Bar> returnedBars = new ArrayList<>();
        for(Bar tmpBar : lstBars){
            for(Place tmpPlace : lstPlaces){
                if(tmpPlace.getPlaceId().equals(tmpBar.getReference())){
                    returnedBars.add(tmpBar);
                }
            }
        }
        return new ListAndStatus(returnedBars, placesAndStatus.getResponseCode());
    }
}
