package com.example.simple_biosamples_client.models.ga4ghmetadata;

import org.springframework.stereotype.Component;

@Component
public class Biosample {

    private String id;
    private String dataset_id;
    private String name;
    private String description;
    private Biocharacteristics[] bio_characteristic;
    private String created;
    private String updated;
    private String individual_id;
    private Attributes attributes;
    private ExternalIdentifier external_identifier;
    private Age individual_age_at_collection;
    private GeoLocation location;

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

    public Biocharacteristics[] getBio_characteristic() {
        return bio_characteristic;
    }

    public void setBio_characteristic(Biocharacteristics[] bio_characteristic) {
        this.bio_characteristic = bio_characteristic;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
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

    public ExternalIdentifier getExternal_identifier() {
        return external_identifier;
    }

    public void setExternal_identifier(ExternalIdentifier external_identifier) {
        this.external_identifier = external_identifier;
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


}
