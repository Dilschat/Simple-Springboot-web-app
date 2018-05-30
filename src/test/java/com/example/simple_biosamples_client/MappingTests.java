package com.example.simple_biosamples_client;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.junit.Test;
import uk.ac.ebi.biosamples.model.Sample;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MappingTests {
    @Test
    public void geolocation_mapping_test() throws IOException {
        JsonParser parser = new JsonParser();
        String sampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/9/decimal_geolocation_SAMEA3121488.json", StandardCharsets.UTF_8);
        String biosampleJson = readFile("/home/dilshat/Desktop/simple_biosamples_client/test_biosample_to_ga4gh/9/GA4GHdecimal_geolocation_SAMEA3121488.json", StandardCharsets.UTF_8);
        Gson gson = new Gson();
        Sample sample = gson.fromJson(sampleJson, Sample.class);
        //BiosampleToGA4GHMapper mapper = new BiosampleToGA4GHMapper(new Biosample(), new GeoLocationDataHelper());

    }

    //    public String SampleFromFile(String path) throws FileNotFoundException {
//        BufferedReader reader = new BufferedReader(new FileReader(path));
//        Gson gson = new Gson();
//        T json = gson.fromJson(reader, T.class);
//        return json.toString();
//    }
    static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
