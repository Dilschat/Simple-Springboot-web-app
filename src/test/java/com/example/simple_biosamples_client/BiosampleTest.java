package com.example.simple_biosamples_client;

import com.example.simple_biosamples_client.models.ga4ghmetadata.AttributeValue;
import com.example.simple_biosamples_client.models.ga4ghmetadata.Attributes;
import com.example.simple_biosamples_client.models.ga4ghmetadata.Biosample;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class BiosampleTest {
    @Test
    public void test_adding_single_attribute_value() {
        Biosample sample = new Biosample(new Attributes());
        sample.addSingleAttributeValue("label", "value");
        Attributes attributes = new Attributes();
        SortedMap<String, List<AttributeValue>> map = new TreeMap<>();
        List<AttributeValue> list = new ArrayList<>();
        list.add(new AttributeValue("value"));
        map.put("label", list);
        System.out.println(sample.getAttributes().getAttributes().equals(map));
        assertEquals(sample.getAttributes().getAttributes(), map);
    }

    @Test
    public void test_adding_attribute_value_list() {
        Biosample sample = new Biosample(new Attributes());
        Attributes attributes = new Attributes();
        SortedMap<String, List<AttributeValue>> map = new TreeMap<>();
        List<AttributeValue> list = new ArrayList<>();
        list.add(new AttributeValue("value"));
        map.put("label", list);
        sample.addAttributeList("label", list);
        System.out.println(sample.getAttributes().getAttributes().equals(map));
        assertEquals(sample.getAttributes().getAttributes(), map);
    }
}
