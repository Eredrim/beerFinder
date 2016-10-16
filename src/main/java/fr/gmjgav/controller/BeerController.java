/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gmjgav.controller;

import fr.gmjgav.model.Beer;
import fr.gmjgav.repository.BarRepository;
import fr.gmjgav.repository.BeerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 *
 * @author Gilles
 */
@CrossOrigin
@RestController
@RequestMapping("/beer")
public class BeerController {
    @Autowired
    private BarRepository barRepository;
    @Autowired
    private BeerRepository beerRepository;
    
    @RequestMapping(method = GET)
    public List<Beer> list() {
        return (List<Beer>) beerRepository.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = GET)
    public Beer get(@PathVariable long id) {
        return beerRepository.findOne(id);
    }
    
    @RequestMapping(value = "/barId/{id}", method = GET)
    public List<Beer> getByBarId(@PathVariable long id) {
        return barRepository.findOne(id).getBeers();
    }
    
    @RequestMapping(value = "/beerName/{beerName}", method = GET)
    public Beer getByBarId(@PathVariable String name) {
        return beerRepository.findByName(name).get(0);
    }
}
