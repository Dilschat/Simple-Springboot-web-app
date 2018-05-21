package com.example.simple_biosamples_client.services;

import com.example.simple_biosamples_client.models.ga4ghmetadata.Biosample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ebi.biosamples.model.Sample;

@Service
public class BiosampleToGA4GHMapper {

    private Biosample ga4ghSample;

    @Autowired
    BiosampleToGA4GHMapper(Biosample ga4ghSample) {
        this.ga4ghSample = ga4ghSample;
    }

    Biosample mapSampleToGA4GH(Sample rawSample) {
        ga4ghSample.setId(rawSample.getAccession());
        ga4ghSample.setDataset_id(rawSample.getDomain());
        ga4ghSample.setName(rawSample.getName());
        ga4ghSample.setCreated(rawSample.getReleaseDate());
        ga4ghSample.setUpdated(rawSample.getUpdateDate());
        return null;
    }

    private void mapAttributesToGA4GH(Sample rawSample) {


    }


}
