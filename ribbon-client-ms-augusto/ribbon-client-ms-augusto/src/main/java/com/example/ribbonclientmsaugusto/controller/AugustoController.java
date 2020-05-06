package com.example.ribbonclientmsaugusto.controller;

import com.example.ribbonclientmsaugusto.service.AugustoService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;

@RestController  
@RequestMapping(value="augusto")
public class AugustoController {

    @Autowired
    private AugustoService augustoService;


    @GetMapping(value="get/info")
    public ResponseEntity<?> getInfo(){
        String nomeImperatore = augustoService.getImperatore();
        ObjectMapper om = new ObjectMapper();
        ObjectNode on = om.createObjectNode();
        on.put("code", HttpStatus.OK.toString());
        on.put("message", nomeImperatore);
        HttpHeaders hh = new HttpHeaders();
        hh.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(on,hh,HttpStatus.CREATED);
    }
}