package com.example.simple_biosamples_client.models.ga4ghmetadata;

import com.example.simple_biosamples_client.ga4gh_services.AttributeValueSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;
import java.util.Objects;

@JsonSerialize(using = AttributeValueSerializer.class)
public class AttributeValue implements Comparable {


    private String type;
    private Object value;

    public AttributeValue() {

    }
    public AttributeValue(Object value) {
        if (value instanceof String) {
            type = "string_value";
            this.value = value;
        } else if (value instanceof Long) {
            type = "int64_value";
            this.value = value;
        } else if (value instanceof Boolean) {
            type = "bool_value";
            this.value = value;
        } else if (value instanceof Double) {
            type = "double_value";
            this.value = value;
        } else if (value instanceof ExternalIdentifier) {
            type = "external_identifier";
            this.value = value;
        } else if (value instanceof OntologyTerm) {
            type = "ontology_term";
            this.value = value;
        } else if (value instanceof Experiment) {
            type = "experiment";
            this.value = value;
        } else if (value instanceof Analysis) {
            type = "analysis";
            this.value = value;
        } else if (value == null) {
            type = "null_value";
        } else if (value instanceof Attributes) {
            type = "attributes";
            this.value = value;
        } else if (isListOfAttributes(value)) {
            type = "attribute_list";
            this.value = value;
        } else {
            throw new TypeNotPresentException("Type is not supported", new Exception());
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    private boolean isListOfAttributes(Object value) {
        try {
            List<AttributeValue> attributeValues = (List<AttributeValue>) value;
            return true;
        } catch (ClassCastException e) {
            return false;
        }

    }

    @JsonCreator
    public static AttributeValue build() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeValue that = (AttributeValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public String toString() {
        return "AttributeValue{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.compareTo(o);
    }
}
