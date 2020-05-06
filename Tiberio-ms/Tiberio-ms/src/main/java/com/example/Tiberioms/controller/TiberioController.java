package com.example.Tiberioms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Tiberioms.response.Princeps;
import com.example.Tiberioms.service.TiberioService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RequestMapping(value = "/tiberio/ms")
@RestController
public class TiberioController {
    
    @Autowired
    private TiberioService ts;

    @GetMapping(value="/get/augusto")
    public ResponseEntity<Princeps> getAugusto(){
        Princeps princeps = ts.getAugusto();
        HttpHeaders hh = new HttpHeaders();
        hh.setContentType(MediaType.APPLICATION_JSON);                
        return new ResponseEntity<Princeps>(princeps,hh,HttpStatus.CREATED);
    }
}