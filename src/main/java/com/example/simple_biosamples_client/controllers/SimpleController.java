package com.example.simple_biosamples_client.controllers;

import com.example.simple_biosamples_client.DAOs.BiosamplesAccessPoint;
import com.example.simple_biosamples_client.models.ga4ghmetadata.Biosample;
import com.example.simple_biosamples_client.services.BiosampleToGA4GHMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;
import uk.ac.ebi.biosamples.model.Sample;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class SimpleController {

    private BiosamplesAccessPoint accessPoint;
    private BiosampleToGA4GHMapper toGA4GHMapper;
    @Autowired
    SimpleController(BiosamplesAccessPoint biosamplesAccessPoint, BiosampleToGA4GHMapper mapper) {
        this.toGA4GHMapper = mapper;
        this.accessPoint = biosamplesAccessPoint;
    }

    @RequestMapping(value="/getSample/{sampleID}", method=RequestMethod.GET)
    Sample getSample(@PathVariable String sampleID) {
        Sample biosample = accessPoint.getSample(sampleID);
        String c = biosample.getCharacteristics().first().getIriOls();
        Biosample biosample1 = toGA4GHMapper.mapSampleToGA4GH(biosample);
        return biosample;
    }

    @RequestMapping("/search")
    Iterable<Resource<Sample>> searchAndFilter(@RequestParam("text") String text, @RequestParam(value = "filter", required = false) List<String> filters) {
        return accessPoint.getFilteredSamplesByString(text, filters);
    }

}
