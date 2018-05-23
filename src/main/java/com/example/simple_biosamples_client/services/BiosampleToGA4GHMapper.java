package com.example.simple_biosamples_client.services;

import com.example.simple_biosamples_client.models.ga4ghmetadata.*;
import com.example.simple_biosamples_client.services.utils.GeoLocationDataHelper;
import com.example.simple_biosamples_client.services.utils.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ebi.biosamples.model.Attribute;
import uk.ac.ebi.biosamples.model.Relationship;
import uk.ac.ebi.biosamples.model.Sample;

import java.util.SortedSet;
import java.util.TreeSet;

@Service
public class BiosampleToGA4GHMapper {

    private Biosample ga4ghSample;
    private GeoLocationDataHelper locationHelper;
    @Autowired
    public BiosampleToGA4GHMapper(Biosample ga4ghSample, GeoLocationDataHelper helper) {
        this.ga4ghSample = ga4ghSample;
        this.locationHelper = helper;
    }

    public Biosample mapSampleToGA4GH(Sample rawSample) {
        ga4ghSample.setId(rawSample.getAccession());
        ga4ghSample.setDataset_id(rawSample.getDomain());
        ga4ghSample.setName(rawSample.getName());
        mapCharacteristics(rawSample);
        mapRelationsihps(rawSample);
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
            } else if (locationHelper.isGeoLocationData(type)) {
                locationInfo.add(attribute);
            } else if (type.equals("individual")) {
                ga4ghSample.setIndividual_id(attribute.getValue());
            } else if (type.equals("dataset")) {
                ga4ghSample.setDataset_id(attribute.getValue());
            } else if (type.equals("description")) {
                ga4ghSample.setDescription(attribute.getValue());
            }
        }
        mapLocation(locationInfo);
    }

    private void mapLocation(SortedSet<Attribute> attributes) {
        GeoLocation geoLocation = new GeoLocation();
        for (Attribute attribute : attributes) {
            switch (attribute.getType()) {
                case "geographic location":
                    geoLocation.setLabel(attribute.getValue());
                    break;
                case "latitude and longitude":
                    Location location = locationHelper.convertToDecimalDegree(attribute.getValue());
                    geoLocation.setLatitude(location.getLatitude());
                    geoLocation.setLongtitude(location.getLongtitude());
                    break;
                case "latitude":
                    geoLocation.setLatitude(Double.parseDouble(attribute.getValue()));
                    break;
                case "longtitude":
                    geoLocation.setLongtitude((Double.parseDouble(attribute.getValue())));
                    break;
                case "altitude":
                    geoLocation.setAltitude(Double.parseDouble(attribute.getValue()));
                    break;
                case "precision":
                    geoLocation.setPrecision(attribute.getValue());
            }
        }

        ga4ghSample.setLocation(geoLocation);

    }

    private void mapRelationsihps(Sample rawSample) {
        SortedSet<ExternalIdentifier> externalIdentifiers = new TreeSet<>();
        for (Relationship relationship : rawSample.getRelationships()) {
            ExternalIdentifier identifier = new ExternalIdentifier();
            identifier.setRelation(relationship.getType());
            if (relationship.getSource().equals(rawSample.getAccession())) {
                identifier.setIdentifier(relationship.getSource());
            } else {
                identifier.setIdentifier(relationship.getTarget());
            }
            externalIdentifiers.add(identifier);

        }
        ga4ghSample.setExternal_identifiers(externalIdentifiers);
    }
    private void mapAge(Attribute attribute) {
        Age age = new Age();
        age.setAge(attribute.getValue());
        age.setAge_class(getOntologyTerm(attribute));
        ga4ghSample.setIndividual_age_at_collection(age);
    }

    private OntologyTerm getOntologyTerm(Attribute attribute) {
        OntologyTerm term = new OntologyTerm();
        term.setTerm_label(attribute.getValue());
        term.setTerm_id(attribute.getIriOls());
        //TODO term id
        return term;
    }


}
