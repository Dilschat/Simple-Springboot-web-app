package com.example.simple_biosamples_client.services;

import com.example.simple_biosamples_client.models.ga4ghmetadata.AttributeValue;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;

public class AttributeSerializer extends StdSerializer<SortedMap> {
    public AttributeSerializer() {
        super(SortedMap.class);
    }

    public AttributeSerializer(JavaType type) {
        super(type);
    }

    public AttributeSerializer(Class<?> t, boolean dummy) {
        super(t, dummy);
    }

    public AttributeSerializer(StdSerializer<?> src) {
        super(src);
    }

    @Override
    public void serialize(SortedMap rawAttributes, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        SortedMap<String, List<AttributeValue>> attributes = (SortedMap<String, List<AttributeValue>>) rawAttributes;
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
