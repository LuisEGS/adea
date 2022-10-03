package com.adea.examen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "app/login";
    }
    
    @RequestMapping("/tablero")
    public String tablero(){
        return "app/tablero";
    }

    @RequestMapping("/gestion")
    public String gestion(){
        return "app/gestion";
    }
    
}
