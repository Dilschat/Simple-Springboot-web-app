package com.example.simple_biosamples_client.models.ga4ghmetadata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class ExternalIdentifier implements Comparable {
    private String identifier;
    private String relation;

    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @JsonProperty("relation")
    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public int compareTo(Object o) {
        return this.getIdentifier().compareTo(((ExternalIdentifier) o).getIdentifier());
    }
}
