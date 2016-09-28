package fr.gmjgav.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Gilles
 */
@RestController
public class TestController {
    
    @RequestMapping("/")
    public String index() {
        return "De l'humour, de la finesse, tout ce qu'on aime...";
    }
    
    @RequestMapping("/toto")
    public String toto() {
        return "De l'humour, de la finesse, tout ce qu'on aime... Le retour";
    }
}
