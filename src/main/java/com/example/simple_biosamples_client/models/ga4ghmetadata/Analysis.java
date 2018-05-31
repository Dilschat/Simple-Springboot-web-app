package com.example.simple_biosamples_client.models.ga4ghmetadata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude
public class Analysis {
    private String id;
    private String name;
    private String description;
    private String created;
    private String updated;
    private String type;
    private String[] software;
    private Attributes attributes;

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

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("updated")
    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("software")
    public String[] getSoftware() {
        return software;
    }

    public void setSoftware(String[] software) {
        this.software = software;
    }

    @JsonProperty("attributes")
    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
}
