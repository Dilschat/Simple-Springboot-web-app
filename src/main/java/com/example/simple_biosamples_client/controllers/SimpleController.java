package com.example.simple_biosamples_client.controllers;

import com.example.simple_biosamples_client.DAOs.AccessPoint;
import com.example.simple_biosamples_client.models.Biosample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@EnableAutoConfiguration
public class SimpleController {

    @Autowired
    protected AccessPoint accessPoint;


    @RequestMapping("/helloworld")
    String helloWorld(){
        return "Hello world!";
    }

    @RequestMapping(value="/getSample/{sampleID}", method=RequestMethod.GET)
    String getSample(@PathVariable String sampleID) throws IOException {
        Biosample biosample = (Biosample) accessPoint.getSample(sampleID);
        return biosample.toString();
    }

}
