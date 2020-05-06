package com.example.Tiberioms.controller;

import com.example.Tiberioms.response.Imperatore;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Augusto-Imperatore-ms-eureka", url = "localhost:8015")
public interface TiberioAugustoController {
    @GetMapping(value="augusto/get/augusto")
    public ResponseEntity<Imperatore> getAugusto();
}