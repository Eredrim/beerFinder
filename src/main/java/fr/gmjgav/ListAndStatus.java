/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gmjgav;

import java.util.List;
import org.springframework.http.HttpStatus;
import se.walkercrou.places.Place;

/**
 *
 * @author Gilles
 */
public class ListAndStatus {
    private List<?> list;
    private HttpStatus responseCode;

    public ListAndStatus() {
    }

    public ListAndStatus(List<?> placesList, HttpStatus responseCode) {
        this.list = placesList;
        this.responseCode = responseCode;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public HttpStatus getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(HttpStatus responseCode) {
        this.responseCode = responseCode;
    }
    
}
