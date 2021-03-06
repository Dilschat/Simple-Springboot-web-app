package com.example.simple_biosamples_client.ga4gh_services;

import com.example.simple_biosamples_client.models.ga4ghmetadata.AttributeValue;
import com.example.simple_biosamples_client.models.ga4ghmetadata.Attributes;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;

//TODO javadoc
public class AttributeSerializer extends StdSerializer<Attributes> {
    public AttributeSerializer() {
        super(Attributes.class);
    }

    public AttributeSerializer(JavaType type) {
        super(type);
    }

    @Override
    public void serialize(Attributes rawAttributes, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        SortedMap<String, List<AttributeValue>> attributes = rawAttributes.getAttributes();
        jsonGenerator.writeStartObject();
        for (String key : attributes.keySet()) {
            jsonGenerator.writeObjectFieldStart(key);
            jsonGenerator.writeArrayFieldStart("values");
            for (AttributeValue value : attributes.get(key)) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeObjectField(value.getType(), value.getValue());
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndObject();
    }
}
