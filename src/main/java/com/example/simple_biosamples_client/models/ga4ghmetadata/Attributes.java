package com.example.simple_biosamples_client.models.ga4ghmetadata;

import com.example.simple_biosamples_client.services.AttributeSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

@Component
@JsonInclude
public class Attributes {
    private SortedMap<String, List<AttributeValue>> attributes;

    public Attributes() {
        this.attributes = new TreeMap<>();
    }

    @JsonSerialize(using = AttributeSerializer.class)
    public SortedMap<String, List<AttributeValue>> getAttributes() {
        return attributes;
    }

    public void setAttributes(SortedMap<String, List<AttributeValue>> attributes) {
        this.attributes = attributes;
    }

    void addAttribute(String label, List<AttributeValue> values) {
        attributes.put(label, values);
    }
}
