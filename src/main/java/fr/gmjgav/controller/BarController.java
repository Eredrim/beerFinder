/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gmjgav.controller;

import fr.gmjgav.model.Bar;
import fr.gmjgav.model.Beer;
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
    
    @RequestMapping(value = "/beerName/{name}", method = GET)
    public List<Bar> getByBeerName(@PathVariable String name) {
        Beer beer = beerRepository.findByName(name).get(0);
        return beer.getBars();
    }
    
    @RequestMapping(value = "/beerType/{type}", method = GET)
    public List<Bar> getByBeerType(@PathVariable String type) {
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
    
    @RequestMapping(value = "/beerCountry/{country}", method = GET)
    public List<Bar> getByBeerCountry(@PathVariable String country) {
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
    public ResponseEntity<?> postBeerInBar(@PathVariable long barId, @PathVariable long beerId, @RequestBody Object input) {
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
