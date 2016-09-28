/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gmjgav.repository;

import org.springframework.data.repository.CrudRepository;

import fr.gmjgav.model.Report;

/**
 *
 * @author Gilles
 */
public interface ReportRepository extends CrudRepository<Report, Long> {
    
}
