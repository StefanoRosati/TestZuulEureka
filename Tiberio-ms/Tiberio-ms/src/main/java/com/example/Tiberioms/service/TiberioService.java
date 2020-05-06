package com.example.Tiberioms.service;

import com.example.Tiberioms.controller.TiberioAugustoController;
import com.example.Tiberioms.response.Imperatore;
import com.example.Tiberioms.response.Princeps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.*;

@Service
public class TiberioService {

    @Autowired
    private TiberioAugustoController tac;

    public Princeps getAugusto() {
        ResponseEntity<Imperatore> augustoResponse = tac.getAugusto();
        Imperatore imperatore = augustoResponse.getBody();    
        Princeps princeps = new Princeps();;
        ModelMapper mm = new ModelMapper();
        mm.map(imperatore,princeps);
        return princeps;
    }
}