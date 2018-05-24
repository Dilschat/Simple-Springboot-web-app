package com.example.simple_biosamples_client.models.ga4ghmetadata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@Component
public class Biosample {

    private String id;
    private String dataset_id;
    private String name;
    private String description;
    private SortedSet<Biocharacteristics> bio_characteristic;
    private String individual_id;
    private Attributes attributes;
    private SortedSet<ExternalIdentifier> external_identifiers;
    private Age individual_age_at_collection;
    private GeoLocation location;

    @Autowired
    Biosample(Attributes attributes) {
        this.attributes = attributes;
        bio_characteristic = new TreeSet<>();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataset_id() {
        return dataset_id;
    }

    public void setDataset_id(String dataset_id) {
        this.dataset_id = dataset_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SortedSet<Biocharacteristics> getBio_characteristic() {
        return bio_characteristic;
    }

    public void setBio_characteristic(SortedSet<Biocharacteristics> bio_characteristic) {
        this.bio_characteristic = bio_characteristic;
    }

    public String getIndividual_id() {
        return individual_id;
    }

    public void setIndividual_id(String individual_id) {
        this.individual_id = individual_id;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public SortedSet<ExternalIdentifier> getExternal_identifiers() {
        return external_identifiers;
    }

    public void setExternal_identifiers(SortedSet<ExternalIdentifier> external_identifiers) {
        this.external_identifiers = external_identifiers;
    }

    public Age getIndividual_age_at_collection() {
        return individual_age_at_collection;
    }

    public void setIndividual_age_at_collection(Age individual_age_at_collection) {
        this.individual_age_at_collection = individual_age_at_collection;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    public void addAttributeList(String label, List<AttributeValue> value) {
        attributes.addAttribute(label, value);
    }

    public void addSingleAttributeValue(String label, Object value) {
        List<AttributeValue> values = new ArrayList<>();
        values.add(new AttributeValue(value));
        addAttributeList(label, values);

    }

    public void addBioCharacteristic(Biocharacteristics biocharacteristics) {
        bio_characteristic.add(biocharacteristics);
    }


}
