/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gmjgav.model;

/**
 *
 * @author Gilles
 */
public class Coordinates {
    private double lat;
    private double lng;
    
    public Coordinates(String googleCoord){
        this.lat = Double.parseDouble(googleCoord.split(",")[0]);
        this.lng = Double.parseDouble(googleCoord.split(",")[1]);
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
