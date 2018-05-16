package com.example.simple_biosamples_client.controllers;

import com.example.simple_biosamples_client.DAOs.BiosamplesAccessPoint;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;
import uk.ac.ebi.biosamples.model.Sample;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class SimpleController {

    @Autowired
    protected BiosamplesAccessPoint accessPoint;

    @RequestMapping(value="/getSample/{sampleID}", method=RequestMethod.GET)
    Sample getSample(@PathVariable String sampleID) {
        Sample biosample = accessPoint.getSample(sampleID);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return biosample;
    }

    @RequestMapping("/search")
    Iterable<Resource<Sample>> searchAndFilter(@RequestParam("text") String text, @RequestParam(value = "filter", required = false) List<String> filters) {
        return accessPoint.getFilteredSamplesByString(text, filters);
    }

}
