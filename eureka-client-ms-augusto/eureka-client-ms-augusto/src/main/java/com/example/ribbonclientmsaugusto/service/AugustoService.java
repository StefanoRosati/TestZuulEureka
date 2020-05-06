package com.example.ribbonclientmsaugusto.service;

import com.example.ribbonclientmsaugusto.controller.TestClient;

import org.aspectj.lang.annotation.AdviceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Service;

@Service
//@RibbonClient(name="test")
public class AugustoService {

    @Autowired
    private TestClient tc;

    public String getImperatore(){
        return tc.getImperatore();
    }

}