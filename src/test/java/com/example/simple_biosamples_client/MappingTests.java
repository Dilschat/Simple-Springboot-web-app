package com.example.simple_biosamples_client;

import com.example.simple_biosamples_client.ga4gh_services.BiosampleToGA4GHMapper;
import com.example.simple_biosamples_client.models.ga4ghmetadata.Biosample;
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
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This test class uses for testing mapping and serialization and deserialization ga4gh objects
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class MappingTests {
    @Autowired
    BiosampleToGA4GHMapper mapper;
    @Autowired
    BioSamplesClient client;

    //covers biocharacteristics, attributes, externalidentifiers
    @Test
    public void real_sample_test1() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMEA1367515";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/1/GA4GHSAMEA1367515.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        String mappedBiosampleJson = jsonMapper.writeValueAsString(biosample);
        try {
            JSONAssert.assertEquals(biosampleJson, mappedBiosampleJson, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void real_sample_deserialization_test1() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMEA1367515";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/1/GA4GHSAMEA1367515.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        String mappedBiosampleJson = jsonMapper.writeValueAsString(biosample);//jsonMapper.writeValueAsString(biosample)
        Biosample deserialized_biosample = jsonMapper.readValue(biosampleJson, Biosample.class);
        Assert.assertTrue(biosample.equals(deserialized_biosample));
    }

    //covers biocharacteristics, attributes
    @Test
    public void real_sample_mapping_test2() throws IOException {
        JsonParser parser = new JsonParser();
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMN07666496";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/2/GA4GHSAMN07666496.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        String mappedBiosampleJson = jsonMapper.writeValueAsString(biosample);
        try {
            JSONAssert.assertEquals(biosampleJson, mappedBiosampleJson, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void real_sample_deserialization_test2() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMN07666496";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/2/GA4GHSAMN07666496.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        Biosample deserialized_biosample = jsonMapper.readValue(biosampleJson, Biosample.class);
        Assert.assertTrue(biosample.equals(deserialized_biosample));
    }

    //age, location, biochracteristics, attributes
    @Test
    public void real_sample_mapping_test3() throws IOException {
        JsonParser parser = new JsonParser();
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMEA2672955";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/3/GA4GHSAMEA2657604.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        String mappedBiosampleJson = jsonMapper.writeValueAsString(biosample);
        try {
            JSONAssert.assertEquals(biosampleJson, mappedBiosampleJson, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void real_sample_deserialization_test3() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMEA2672955";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/3/GA4GHSAMEA2657604.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        Biosample deserialized_biosample = jsonMapper.readValue(biosampleJson, Biosample.class);
        Assert.assertTrue(biosample.equals(deserialized_biosample));
    }

    //covers age, attributes, biocharacteristics
    @Test
    public void real_sample_test4() throws IOException {
        JsonParser parser = new JsonParser();
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMN07566236";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/4/GA4GHSAMN07566236.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        String mappedBiosampleJson = jsonMapper.writeValueAsString(biosample);
        try {
            JSONAssert.assertEquals(biosampleJson, mappedBiosampleJson, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void real_sample_deserialization_test4() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMN07566236";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/4/GA4GHSAMN07566236.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        Biosample deserialized_biosample = jsonMapper.readValue(biosampleJson, Biosample.class);
        Assert.assertTrue(biosample.equals(deserialized_biosample));
    }

    //covers external identifiers, biocharcteristics, attributes
    @Test
    public void real_sample_test5() throws IOException {
        JsonParser parser = new JsonParser();
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMEA281881";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/6/GA4GHdecimal_geolocation_SAMEA3121488.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        String mappedBiosampleJson = jsonMapper.writeValueAsString(biosample);
        try {
            JSONAssert.assertEquals(biosampleJson, mappedBiosampleJson, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void real_sample_deserialization_test5() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMEA281881";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/6/GA4GHdecimal_geolocation_SAMEA3121488.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        Biosample deserialized_biosample = jsonMapper.readValue(biosampleJson, Biosample.class);
        Assert.assertTrue(biosample.equals(deserialized_biosample));
    }

    //covers age, attributes, biocharacteristics
    @Test
    public void real_sample_test6() throws IOException {
        JsonParser parser = new JsonParser();
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMN07566236";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/5/GA4GHSAMN03876393.json", StandardCharsets.UTF_8);
        Sample sample = client.fetchSampleResource(sampleJson).get().getContent();
        Biosample biosample = mapper.mapSampleToGA4GH(sample);
        String mappedBiosampleJson = jsonMapper.writeValueAsString(biosample);
        try {
            JSONAssert.assertEquals(biosampleJson, mappedBiosampleJson, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void real_sample_deserialization_test6() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        String sampleJson = "SAMN07566236";
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/5/GA4GHSAMN03876393.json", StandardCharsets.UTF_8);
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
