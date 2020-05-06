package com.example.ribbonclientmsaugusto.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

//senza ribbon
//@FeignClient(name="test", url="localhost:8091")
//con ribbon
@FeignClient(name="Roma")
//@RibbonClient(name="Roma-ms")
public interface TestClient {
    @GetMapping(value="/api/roma/imperatore")
    public String getImperatore();    
}