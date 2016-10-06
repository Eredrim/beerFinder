/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gmjgav;

import fr.gmjgav.model.Bar;
import fr.gmjgav.model.Coordinates;
import fr.gmjgav.repository.BarRepository;
import fr.gmjgav.repository.BeerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Param;
import se.walkercrou.places.Place;

/**
 *
 * @author Gilles
 */
public class GooglePlacesManager {
    private static final GooglePlaces GOOGLE_CLIENT = new GooglePlaces("AIzaSyDfA3smjbhDYeXYPe6anqbH4yIKSF1VkAA");
    private static final int RADIUS = 500;
    private static final int LIMIT = 500;
    
    public static List<Place> getPlaces(BarRepository barRepository, Coordinates coord){
        List<Place> places = GOOGLE_CLIENT.getNearbyPlaces(coord.getLat(), coord.getLng(), RADIUS, LIMIT, Param.name("types").value("bar"));
        List<Bar> createdBars = new ArrayList<>();
        for(Place tmpPlace : places){
            if(barRepository.findByReference(tmpPlace.getPlaceId()).isEmpty()){
                Bar generatedBar = new Bar(tmpPlace.getName(), tmpPlace.getPlaceId());
                createdBars.add(generatedBar);
            }
        }
        if(!createdBars.isEmpty()){
            barRepository.save(createdBars);
        }
        return places;
    }
    
    public static List<Place> getPlaces(Coordinates coord){
        return GOOGLE_CLIENT.getNearbyPlaces(coord.getLat(), coord.getLng(), RADIUS, LIMIT, Param.name("types").value("bar"));
    }
    
    public static List<Bar> intersectBarsAndPlaces(List<Bar> lstBars, BarRepository barRepository, Coordinates coord){
        List<Place> lstPlaces = getPlaces(barRepository, coord);
        List<Bar> returnedBars = new ArrayList<>();
        for(Bar tmpBar : lstBars){
            for(Place tmpPlace : lstPlaces){
                if(tmpPlace.getPlaceId().equals(tmpBar.getReference())){
                    returnedBars.add(tmpBar);
                }
            }
        }
        return returnedBars;
    }
}
