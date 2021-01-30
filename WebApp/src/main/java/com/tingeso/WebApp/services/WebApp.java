package com.tingeso.WebApp.services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class WebApp {


    @GetMapping(value = "/hola")
    public String holaMundo(){
        return "Hola Mundo";
    }
}