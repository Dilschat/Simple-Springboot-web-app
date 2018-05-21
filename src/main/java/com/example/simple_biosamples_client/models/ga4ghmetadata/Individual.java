package com.example.simple_biosamples_client.models.ga4ghmetadata;

public class Individual {
    private String id;
    private String dataset_id;
    private String name;
    private String description;
    private Biocharacteristics[] bio_characteristics;
    private String created;
    private String updated;
    private OntologyTerm species;
    private OntologyTerm sex;
    private GeoLocation location;
    private Attributes attributes;
    private ExternalIdentifier[] external_identifiers;

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

    public Biocharacteristics[] getBio_characteristics() {
        return bio_characteristics;
    }

    public void setBio_characteristics(Biocharacteristics[] bio_characteristics) {
        this.bio_characteristics = bio_characteristics;
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

    public OntologyTerm getSpecies() {
        return species;
    }

    public void setSpecies(OntologyTerm species) {
        this.species = species;
    }

    public OntologyTerm getSex() {
        return sex;
    }

    public void setSex(OntologyTerm sex) {
        this.sex = sex;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public ExternalIdentifier[] getExternal_identifiers() {
        return external_identifiers;
    }

    public void setExternal_identifiers(ExternalIdentifier[] external_identifiers) {
        this.external_identifiers = external_identifiers;
    }
}
