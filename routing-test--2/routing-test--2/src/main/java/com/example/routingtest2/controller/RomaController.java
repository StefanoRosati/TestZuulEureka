package com.example.routingtest2.controller;

import com.example.routingtest2.request.TestRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/api/roma")
public class RomaController {

    private static Logger log = LoggerFactory.getLogger(String.class);

    @GetMapping(value="/call/{id}")
    public ResponseEntity<?> testCalling(@PathVariable("id")int id){
        log.info("Chiamata del metodo testCalling");
        ObjectMapper om = new ObjectMapper();
        ObjectNode on = om.createObjectNode();
        HttpHeaders hh = new HttpHeaders();
        on.put("messages", "Chiamata con id: "+id);
        on.put("code",HttpStatus.OK.toString());
        hh.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(on,hh,HttpStatus.CREATED);
    }

    @GetMapping(value="/imperatore")
    public String testImperatore(){
        return "Imperatore";
    }

    @GetMapping(value="/call/with/params")
    public ResponseEntity<?> testCalling2(TestRequest request){
        log.info("Chiamata del metodo testCalling");
        ObjectMapper om = new ObjectMapper();
        ObjectNode on = om.createObjectNode();
        HttpHeaders hh = new HttpHeaders();
        on.put("messages", "Chiamata con id: "+request.getId() + " " + request.getName());
        on.put("code",HttpStatus.OK.toString());
        hh.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(on,hh,HttpStatus.CREATED);     
    }
}