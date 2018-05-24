package com.example.simple_biosamples_client.models.ga4ghmetadata;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

@Component
public class Attributes {
    private SortedMap<String, List<AttributeValue>> attributes;

    Attributes() {
        this.attributes = new TreeMap<>();
    }

    public SortedMap<String, List<AttributeValue>> getAttributes() {
        return attributes;
    }

    public void setAttributes(SortedMap<String, List<AttributeValue>> attributes) {
        this.attributes = attributes;
    }

    public void addAttribute(String label, List<AttributeValue> values) {
        attributes.put(label, values);
    }
}
