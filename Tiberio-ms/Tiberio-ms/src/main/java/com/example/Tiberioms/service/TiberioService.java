package com.example.Tiberioms.service;

import java.util.concurrent.ThreadLocalRandom;

import com.example.Tiberioms.controller.TiberioAugustoController;
import com.example.Tiberioms.response.Imperatore;
import com.example.Tiberioms.response.Princeps;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TiberioService {

    @Autowired
    private TiberioAugustoController tac;

    //Hystrix constany settings
    public static final String failureTimeoutInMs = "4000";

    private static final Logger logger = LoggerFactory.getLogger(TiberioService.class);

    //imposto il metodo alternativo e l'intervallo del timeout prima della chiamata del metodo alternativo
    @HystrixCommand(fallbackMethod = "AliasGetAugusto",
                commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                value = failureTimeoutInMs)})
    public Princeps getAugusto() {
        //rallentamento randomico artificiale
        int randomNum = ThreadLocalRandom.current().nextInt(2000,8000);
        try{   
            logger.warn(String.format("Applicato rallentamento di %s", randomNum));  
            Thread.sleep(randomNum);   
            ResponseEntity<Imperatore> augustoResponse = tac.getAugusto();
            Imperatore imperatore = augustoResponse.getBody();    
            Princeps princeps = new Princeps();;
            ModelMapper mm = new ModelMapper();
            mm.map(imperatore,princeps);
            return princeps;
        }
        catch(InterruptedException e){
            //e.printStackTrace();
            return null;
        }
    }

    public Princeps AliasGetAugusto(){
        logger.warn("Alias attivato");
        ResponseEntity<Imperatore> augustoResponse = tac.getAugusto();
        Imperatore imperatore = augustoResponse.getBody();    
        Princeps princeps = new Princeps();;
        ModelMapper mm = new ModelMapper();
        mm.map(imperatore,princeps);
        return princeps;
    }
}