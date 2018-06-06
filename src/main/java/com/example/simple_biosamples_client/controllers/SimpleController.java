package com.example.simple_biosamples_client.controllers;

import com.example.simple_biosamples_client.ga4gh_services.BiosampleToGA4GHMapper;
import com.example.simple_biosamples_client.ga4gh_services.BiosamplesRetriever;
import com.example.simple_biosamples_client.models.ga4ghmetadata.Biosample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;
import uk.ac.ebi.biosamples.model.Sample;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class SimpleController {

    private BiosamplesRetriever accessPoint;
    private BiosampleToGA4GHMapper toGA4GHMapper;
    @Autowired
    SimpleController(BiosamplesRetriever biosamplesRepository, BiosampleToGA4GHMapper mapper) {
        this.toGA4GHMapper = mapper;
        this.accessPoint = biosamplesRepository;
    }

    @RequestMapping(value = "/getSampleById/{sampleID}", method = RequestMethod.GET)
    Biosample getSample(@PathVariable String sampleID) {
        Sample biosample = accessPoint.getSampleById(sampleID);
        String c = biosample.getCharacteristics().first().getIriOls();
        Biosample biosample1 = toGA4GHMapper.mapSampleToGA4GH(biosample);
        return biosample1;
    }

    @RequestMapping("/search")
    Iterable<Resource<Sample>> searchAndFilter(@RequestParam("text") String text, @RequestParam(value = "filter", required = false) List<String> filters) {
        return accessPoint.getFilteredSamplesByString(text, filters);
    }

}
