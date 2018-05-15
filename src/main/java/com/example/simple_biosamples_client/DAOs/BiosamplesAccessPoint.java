package com.example.simple_biosamples_client.DAOs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;
import uk.ac.ebi.biosamples.client.BioSamplesClient;
import uk.ac.ebi.biosamples.model.Sample;

import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@Scope("prototype")
public class BiosamplesAccessPoint implements AccessPoint {
    private BioSamplesClient client;

    @Autowired
    BiosamplesAccessPoint(BioSamplesClient bioSamplesClient) {
        this.client = bioSamplesClient;
    }

    public Sample getSample(String sampleID) throws NoSuchElementException {
        Optional<Resource<Sample>> optionalResource = client.fetchSampleResource(sampleID);
        Resource<Sample> sampleResource = optionalResource.get();
        return sampleResource.getContent();
    }
}

