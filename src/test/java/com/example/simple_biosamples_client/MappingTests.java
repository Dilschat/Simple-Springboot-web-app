package com.example.simple_biosamples_client;

import com.example.simple_biosamples_client.models.ga4ghmetadata.Biosample;
import com.example.simple_biosamples_client.services.BiosampleToGA4GHMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.ac.ebi.biosamples.client.BioSamplesClient;
import uk.ac.ebi.biosamples.model.Sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class MappingTests {
    @Autowired
    BiosampleToGA4GHMapper mapper;
    @Autowired
    BioSamplesClient client;

    @Test
    public void attributes_and_biocharacteristics_mapping_test1() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMEA1367515";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/1/GA4GHSAMEA1367515.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        String mappedBiosampleJson = jsonMapper.writeValueAsString(biosample);//jsonMapper.writeValueAsString(biosample)
        PrintWriter printWriter = new PrintWriter("file1.json");
        printWriter.write(mappedBiosampleJson);
        printWriter.flush();
        printWriter.close();
        try {
            JSONAssert.assertEquals(biosampleJson, mappedBiosampleJson, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void attributes_and_biocharacteristics_deserialization_test1() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMEA1367515";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/1/GA4GHSAMEA1367515.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        Biosample deserialized_biosample = jsonMapper.readValue(biosampleJson, Biosample.class);
        Assert.assertTrue(biosample.equals(deserialized_biosample));
    }

    @Test
    public void attributes_and_biocharacteristics_mapping_test2() throws IOException {
        JsonParser parser = new JsonParser();
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMN07666496";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/2/GA4GHSAMN07666496.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        String mappedBiosampleJson = jsonMapper.writeValueAsString(biosample);//jsonMapper.writeValueAsString(biosample);
        PrintWriter printWriter = new PrintWriter("file2.json");
        printWriter.write(mappedBiosampleJson);
        printWriter.flush();
        printWriter.close();
        try {
            JSONAssert.assertEquals(biosampleJson, mappedBiosampleJson, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void attributes_and_biocharacteristics_deserialization_test2() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMN07666496";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/3/GA4GHSAMEA2657604.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        Biosample deserialized_biosample = jsonMapper.readValue(biosampleJson, Biosample.class);
        Assert.assertTrue(biosample.equals(deserialized_biosample));
    }

    @Test
    public void geolocation_mapping_test1() throws IOException {
        JsonParser parser = new JsonParser();
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMEA2672955";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/1/GA4GHSAMEA1367515.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        String mappedBiosampleJson = jsonMapper.writeValueAsString(biosample);//jsonMapper.writeValueAsString(biosample);
        PrintWriter printWriter = new PrintWriter("file3.json");
        printWriter.write(mappedBiosampleJson);
        printWriter.flush();
        printWriter.close();
        try {
            JSONAssert.assertEquals(biosampleJson, mappedBiosampleJson, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void geolocation_deserialization_test1() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMEA2672955";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/1/GA4GHSAMEA1367515.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        Biosample deserialized_biosample = jsonMapper.readValue(biosampleJson, Biosample.class);
        Assert.assertTrue(biosample.equals(deserialized_biosample));
    }

    static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
