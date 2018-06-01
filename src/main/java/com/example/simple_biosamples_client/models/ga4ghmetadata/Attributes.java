package com.example.simple_biosamples_client.models.ga4ghmetadata;

import com.example.simple_biosamples_client.services.AttributeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

@Component
@JsonSerialize(using = AttributeSerializer.class)
public class Attributes {
    private SortedMap<String, List<AttributeValue>> attributes;

    public Attributes() {
        this.attributes = new TreeMap<>();
    }


    public SortedMap<String, List<AttributeValue>> getAttributes() {
        return attributes;
    }

    public void setAttributes(SortedMap<String, List<AttributeValue>> attributes) {
        this.attributes = attributes;
    }

    void addAttribute(String label, List<AttributeValue> values) {
        attributes.put(label, values);
    }

    public void addSingleAttribute(String label, AttributeValue value) {
        ArrayList<AttributeValue> values = new ArrayList<>();
        values.add(value);
        attributes.put(label, values);
    }
}
