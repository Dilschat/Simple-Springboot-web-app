package com.example.simple_biosamples_client.services;

import com.example.simple_biosamples_client.models.ga4ghmetadata.Age;
import com.example.simple_biosamples_client.models.ga4ghmetadata.Biosample;
import com.example.simple_biosamples_client.models.ga4ghmetadata.GeoLocation;
import com.example.simple_biosamples_client.models.ga4ghmetadata.OntologyTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ebi.biosamples.model.Attribute;
import uk.ac.ebi.biosamples.model.Sample;

import java.util.SortedSet;
import java.util.TreeSet;

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
        mapCharacteristics(rawSample);
        return ga4ghSample;
    }

    private void mapAttributesToGA4GH(Sample rawSample) {


    }

    private void mapCharacteristics(Sample rawSample) {
        SortedSet<Attribute> attributes = rawSample.getCharacteristics();
        SortedSet<Attribute> locationInfo = new TreeSet<>();
        for (Attribute attribute : attributes) {
            String type = attribute.getType();
            if (type.equals("age")) {
                mapAge(attribute);
                break;
            }
            if (isGeoLocationData(type)) {
                locationInfo.add(attribute);
            }


        }
    }

    private void mapLocation(Attribute attribute) {
        GeoLocation geoLocation = new GeoLocation();


    }

    private void mapAge(Attribute attribute) {
        Age age = new Age();
        age.setAge(attribute.getValue());
        age.setAge_class(getOntologyTerm(attribute));
        ga4ghSample.setIndividual_age_at_collection(age);
    }

    private OntologyTerm getOntologyTerm(Attribute attribute) {
        OntologyTerm term = new OntologyTerm();
        term.setTerm_label(attribute.getType());
        term.setTerm_id(attribute.getIriOls());
        return term;
    }

    private boolean isGeoLocationData(String type) {
        boolean isGeolocation = type.contains("geographic location");
        isGeolocation = isGeolocation || type.contains("latitiude");
        isGeolocation = isGeolocation || type.contains("longtitude");
        isGeolocation = isGeolocation || type.contains("altitude");
        return isGeolocation;
    }


}
