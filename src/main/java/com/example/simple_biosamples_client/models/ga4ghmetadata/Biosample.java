package com.example.simple_biosamples_client.models.ga4ghmetadata;

import com.example.simple_biosamples_client.ga4gh_services.AttributeDeserializer;
import com.example.simple_biosamples_client.ga4gh_services.AttributeSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@JsonInclude
@JsonPropertyOrder({"id", "dataset_id", "individual_id", "name", "description", "bio_characteristic", "attributes", "external_identifiers",
        "individual_age_at_collection", "location"})
public class Biosample {

    private String id;
    private String dataset_id;
    private String individual_id;
    private String name;
    private String description;
    private SortedSet<Biocharacteristics> bio_characteristic;
    private Attributes attributes;
    private SortedSet<ExternalIdentifier> external_identifiers;
    private Age individual_age_at_collection;
    private GeoLocation location;

    @Autowired
    public Biosample(Attributes attributes) {
        this.attributes = attributes;
        bio_characteristic = new TreeSet<>();
        external_identifiers = new TreeSet<>();
    }

    @JsonCreator
    public static Biosample build(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("dataset_id") String dataset_id,
            @JsonProperty("individual_id") String individual_id,
            @JsonProperty("description") String description,
            @JsonProperty("biocharacteristic") Collection<Biocharacteristics> biocharacteristics,
            @JsonProperty("attributes") @JsonDeserialize(using = AttributeDeserializer.class) Attributes attributes,
            @JsonProperty("external_identifiers") Collection<ExternalIdentifier> externalIdentifiers,
            @JsonProperty("individual_age_at_collection") Age age,
            @JsonProperty("location") GeoLocation location) {
        Biosample biosample = new Biosample(new Attributes());

        if (id == null) throw new IllegalArgumentException("Sample id must be provided");
        biosample.id = id.trim();

        if (name == null) throw new IllegalArgumentException("Sample id must be provided");
        biosample.name = name.trim();

        if (dataset_id != null) {
            biosample.dataset_id = dataset_id;
        }

        if (individual_id != null) {
            biosample.individual_id = individual_id;
        }

        if (description != null) {
            biosample.description = description;
        }

        if (biocharacteristics != null) {

            biosample.bio_characteristic.addAll(biocharacteristics);
        }

        if (attributes != null) {
            biosample.attributes = attributes;
        }

        if (externalIdentifiers != null) {
            biosample.external_identifiers.addAll(externalIdentifiers);
        }

        if (age != null) {
            biosample.individual_age_at_collection = age;
        }

        if (location != null) {
            biosample.location = location;
        }

        return biosample;


    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("dataset_id")
    public String getDataset_id() {
        return dataset_id;
    }

    public void setDataset_id(String dataset_id) {
        this.dataset_id = dataset_id;
    }

    @JsonProperty("individual_id")
    public String getIndividual_id() {
        return individual_id;
    }

    public void setIndividual_id(String individual_id) {
        this.individual_id = individual_id;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("bio_characteristics")
    public SortedSet<Biocharacteristics> getBio_characteristic() {
        return bio_characteristic;
    }

    public void setBio_characteristic(SortedSet<Biocharacteristics> bio_characteristic) {
        this.bio_characteristic = bio_characteristic;
    }

    @JsonSerialize(using = AttributeSerializer.class)
    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("external_identifiers")
    public SortedSet<ExternalIdentifier> getExternal_identifiers() {
        return external_identifiers;
    }

    public void setExternal_identifiers(SortedSet<ExternalIdentifier> external_identifiers) {
        this.external_identifiers = external_identifiers;
    }

    @JsonProperty("individual_age_at_collection")
    public Age getIndividual_age_at_collection() {
        return individual_age_at_collection;
    }

    public void setIndividual_age_at_collection(Age individual_age_at_collection) {
        this.individual_age_at_collection = individual_age_at_collection;
    }

    @JsonProperty("location")
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

    public void clear() {
        this.setAttributes(new Attributes()); // need to be cleared before map next sample using the same mapper
        this.setBio_characteristic(new TreeSet<Biocharacteristics>());
        this.setExternal_identifiers(new TreeSet<>());
        this.setDescription(null);
        this.setDataset_id(null);
        this.setIndividual_id(null);
        this.setLocation(null);
        this.setIndividual_age_at_collection(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Biosample biosample = (Biosample) o;
        boolean charac = Objects.equals(bio_characteristic, biosample.bio_characteristic);
        boolean a = Objects.equals(attributes, biosample.attributes);
        return Objects.equals(id, biosample.id) &&
                Objects.equals(dataset_id, biosample.dataset_id) &&
                Objects.equals(individual_id, biosample.individual_id) &&
                Objects.equals(name, biosample.name) &&
                Objects.equals(description, biosample.description) &&
                charac &&
                a &&
                Objects.equals(external_identifiers, biosample.external_identifiers) &&
                Objects.equals(individual_age_at_collection, biosample.individual_age_at_collection) &&
                Objects.equals(location, biosample.location);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dataset_id, individual_id, name, description, bio_characteristic, attributes, external_identifiers, individual_age_at_collection, location);
    }
}
