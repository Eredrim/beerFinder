/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gmjgav.controller;

import fr.gmjgav.model.Bar;
import fr.gmjgav.model.Beer;
import fr.gmjgav.model.Report;
import fr.gmjgav.repository.BarRepository;
import fr.gmjgav.repository.BeerRepository;
import fr.gmjgav.repository.ReportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 *
 * @author Gilles
 */
@CrossOrigin
@RestController
@RequestMapping("/report")
public class ReportController {
    
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private BarRepository barRepository;
    @Autowired
    private BeerRepository beerRepository;
    
    @RequestMapping(method = GET)
    public List<Report> list() {
        return (List<Report>) reportRepository.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = GET)
    public Object get(@PathVariable long id) {
        return reportRepository.findOne(id);
    }
    
    @RequestMapping(value = "/{barId}/{beerId}", method = POST)
    public ResponseEntity<?> post(@PathVariable long barId, @PathVariable long beerId) {
        Bar bar = barRepository.findOne(barId);
        Beer beer = beerRepository.findOne(beerId);
        
        if(reportRepository.findByIds(barId, beerId).isEmpty()){
            Report report = new Report(bar, beer);
            reportRepository.save(report);
        }
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
