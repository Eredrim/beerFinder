/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gmjgav.repository;

import fr.gmjgav.model.Bar;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Gilles
 */
public interface BarRepository extends CrudRepository<Bar, Long> {
    List<Bar> findByReference(String reference);
}
