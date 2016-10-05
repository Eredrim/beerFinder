/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gmjgav.repository;

import org.springframework.data.repository.CrudRepository;
import fr.gmjgav.model.Beer;
import java.util.List;

/**
 *
 * @author Gilles
 */
public interface BeerRepository extends CrudRepository<Beer, Long> {
    List<Beer> findByName(String name);
    List<Beer> findByType(String type);
    List<Beer> findByCountry(String country);
}
