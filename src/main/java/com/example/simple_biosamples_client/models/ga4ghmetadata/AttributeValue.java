package com.example.simple_biosamples_client.models.ga4ghmetadata;

import uk.ac.ebi.biosamples.model.Contact;
import uk.ac.ebi.biosamples.model.Organization;
import uk.ac.ebi.biosamples.model.Publication;

import java.util.List;
import java.util.Objects;

public class AttributeValue {


    private String type;
    private Object value;

    public AttributeValue(Object value) {
        if (value instanceof String || value instanceof Contact || value instanceof Organization || value instanceof Publication) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeValue that = (AttributeValue) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(value, that.value);
    }



}
