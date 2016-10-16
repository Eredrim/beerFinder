/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gmjgav.controller;

import fr.gmjgav.GooglePlacesManager;
import fr.gmjgav.ListAndStatus;
import fr.gmjgav.model.Bar;
import fr.gmjgav.model.Beer;
import fr.gmjgav.model.Coordinates;
import fr.gmjgav.repository.BarRepository;
import fr.gmjgav.repository.BeerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import se.walkercrou.places.Place;

/**
 *
 * @author Gilles
 */
@CrossOrigin
@RestController
@RequestMapping("/bar")
public class BarController {
    @Autowired
    private BarRepository barRepository;
    @Autowired
    private BeerRepository beerRepository;
    
    @RequestMapping(method = GET)
    public List<Bar> list() {
        return (List<Bar>) barRepository.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = GET)
    public Bar get(@PathVariable long id) {
        return barRepository.findOne(id);
    }
    
    @RequestMapping(value = "/any/{location:.+}", method = GET)
    public List<Place> getAllBarsWithLocation(@PathVariable String location) {
        return GooglePlacesManager.getPlaces(new Coordinates(location));
    }
    
    @RequestMapping(value = "/beerName/{location:.+}/{name}", method = GET)
    public ResponseEntity<?> getByBeerName(@PathVariable String location, @PathVariable String name) {
        Beer beer = beerRepository.findByName(name).get(0);
        List<Bar> barsForBeer = beer.getBars();
        ListAndStatus returnedBars = GooglePlacesManager.intersectBarsAndPlaces(barsForBeer, barRepository, new Coordinates(location));
        return new ResponseEntity<>(returnedBars.getList(), returnedBars.getResponseCode());
    }
    
    @RequestMapping(value = "/beerType/{location:.+}/{type}", method = GET)
    public ResponseEntity<?> getByBeerType(@PathVariable String location, @PathVariable String type) {
        List<Beer> beers = beerRepository.findByType(type);
        List<Bar> barsForBeers = new ArrayList<>();
        for(Beer beer : beers){
            List<Bar> tmpBarLst = beer.getBars();
            for(Bar tmpBar : tmpBarLst){
                if(!barsForBeers.contains(tmpBar)){
                    barsForBeers.add(tmpBar);
                }
            }
        }
        ListAndStatus returnedBars = GooglePlacesManager.intersectBarsAndPlaces(barsForBeers, barRepository, new Coordinates(location));
        return new ResponseEntity<>(returnedBars.getList(), returnedBars.getResponseCode());
    }
    
    @RequestMapping(value = "/beerCountry/{location:.+}/{country}", method = GET)
    public ResponseEntity<?> getByBeerCountry(@PathVariable String location, @PathVariable String country) {
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
        ListAndStatus returnedBars = GooglePlacesManager.intersectBarsAndPlaces(bars, barRepository, new Coordinates(location));
        return new ResponseEntity<>(returnedBars.getList(), returnedBars.getResponseCode());
    }
    
    @RequestMapping(value = "/{barId}/{beerId}", method = POST)
    public ResponseEntity<?> postBeerInBar(@PathVariable long barId, @PathVariable long beerId) {
        Bar bar = barRepository.findOne(barId);
        List<Beer> beersOfTheBar = bar.getBeers();
        Beer searchedBeer = beerRepository.findOne(beerId);
        beersOfTheBar.add(searchedBeer);
        bar.setBeers(beersOfTheBar);
        barRepository.save(bar);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @RequestMapping(value = "/{barId}/{beerId}", method = DELETE)
    public ResponseEntity<?> deleteBeerInBar(@PathVariable long barId, @PathVariable long beerId) {
        Bar bar = barRepository.findOne(barId);
        List<Beer> beersOfTheBar = bar.getBeers();
        Beer searchedBeer = beerRepository.findOne(beerId);
        beersOfTheBar.remove(searchedBeer);
        bar.setBeers(beersOfTheBar);
        barRepository.save(bar);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
