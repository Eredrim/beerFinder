/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gmjgav.controller;

import fr.gmjgav.model.Bar;
import fr.gmjgav.model.Beer;
import fr.gmjgav.model.Coordinates;
import fr.gmjgav.repository.BarRepository;
import fr.gmjgav.repository.BeerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Param;
import se.walkercrou.places.Place;

/**
 *
 * @author Gilles
 */
@RestController
@RequestMapping("/bar")
public class BarController {
    @Autowired
    private BarRepository barRepository;
    @Autowired
    private BeerRepository beerRepository;
    
    private final GooglePlaces googleClient = new GooglePlaces("AIzaSyDfA3smjbhDYeXYPe6anqbH4yIKSF1VkAA");
    
    @RequestMapping(method = GET)
    public List<Bar> list() {
        return (List<Bar>) barRepository.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = GET)
    public Bar get(@PathVariable long id) {
        return barRepository.findOne(id);
    }
    
    @RequestMapping(value = "/any/{location:.+}", method = GET)
    public List<Bar> getAllBarsWithLocation(@PathVariable String location) {
        Coordinates coord = new Coordinates(location);
        List<Place> places = googleClient.getNearbyPlaces(coord.getLat(), coord.getLng(), 500, 10, Param.name("types").value("bar"));
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
        return createdBars;
    }
    
    @RequestMapping(value = "/beerName/{location:.+}/{name}", method = GET)
    public List<Bar> getByBeerName(@PathVariable String location, @PathVariable String name) {
        Coordinates coord = new Coordinates(location);
        List<Place> places = googleClient.getNearbyPlaces(coord.getLat(), coord.getLng(), 500, 10, Param.name("types").value("bar"));
        Beer beer = beerRepository.findByName(name).get(0);
        List<Bar> barsForBeer = beer.getBars();
        List<Bar> returnedBars = new ArrayList<>();
        for(Bar tmpBar : barsForBeer){
            for(Place tmpPlace : places){
                if(tmpPlace.getPlaceId().equals(tmpBar.getReference())){
                    returnedBars.add(tmpBar);
                }
            }
        }
        return returnedBars;
    }
    
    @RequestMapping(value = "/beerType/{location:.+}/{type}", method = GET)
    public List<Bar> getByBeerType(@PathVariable String location, @PathVariable String type) {
        List<Beer> beers = beerRepository.findByType(type);
        List<Bar> bars = new ArrayList<>();
        for(Beer beer : beers){
            List<Bar> tmpBarLst = beer.getBars();
            for(Bar tmpBar : tmpBarLst){
                if(!bars.contains(tmpBar)){
                    bars.add(tmpBar);
                }
            }
        }
        
        return bars;
    }
    
    @RequestMapping(value = "/beerCountry/{location:.+}/{country}", method = GET)
    public List<Bar> getByBeerCountry(@PathVariable String location, @PathVariable String country) {
        List<Beer> beers = beerRepository.findByCountry(country);
        List<Bar> bars = new ArrayList<>();
        for(Beer beer : beers){
            List<Bar> tmpBarLst = beer.getBars();
            for(Bar tmpBar : tmpBarLst){
                if(!bars.contains(tmpBar)){
                    bars.add(tmpBar);
                }
            }
        }
        
        return bars;
    }
    
    @RequestMapping(value = "/{barId}/{beerId}", method = POST)
    public ResponseEntity<?> postBeerInBar(@PathVariable long barId, @PathVariable long beerId) {
        Bar bar = barRepository.findOne(barId);
        List<Beer> beersOfTheBar = bar.getBeers();
        Beer searchedBeer = beerRepository.findOne(beerId);
        beersOfTheBar.add(searchedBeer);
        bar.setBeers(beersOfTheBar);
        barRepository.save(bar);
        return null;
    }
    
    @RequestMapping(value = "/{barId}/{beerId}", method = DELETE)
    public ResponseEntity<Object> deleteBeerInBar(@PathVariable long barId, @PathVariable long beerId) {
        Bar bar = barRepository.findOne(barId);
        List<Beer> beersOfTheBar = bar.getBeers();
        Beer searchedBeer = beerRepository.findOne(beerId);
        beersOfTheBar.remove(searchedBeer);
        bar.setBeers(beersOfTheBar);
        barRepository.save(bar);
        return null;
    }
    
}
