package com.example.simple_biosamples_client.models.ga4ghmetadata;

public class ExternalIdentifier implements Comparable {
    private String identifier;
    private String relation;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

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
