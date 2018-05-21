package com.example.simple_biosamples_client.models.ga4ghmetadata;


public enum AttributeValue {
    string_value, int64_value,
    bool_value,
    double_value,
    external_identifier,
    ontology_term,
    experiment,
    //Program program;
    analysis;

    Object value;

    public AttributeValue create(Object object) {
        this.value = object;
        return this;
    }

}
