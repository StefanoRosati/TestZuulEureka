package com.example.routingandfilteringbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="book/ms")
public class RoutingAndFilteringBookController {

    @GetMapping(value = "/available")
    public String available() {
      return "Spring in Action";
    }
  
    @GetMapping(value = "/checked-out")
    public String checkedOut() {
      return "Spring Boot in Action";
    }
  
}