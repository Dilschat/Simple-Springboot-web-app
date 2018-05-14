package com.example.simple_biosamples_client.DAOs;
import com.example.simple_biosamples_client.models.Biosample;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

@Component
@EnableAutoConfiguration
@Scope("prototype")
public class BiosamplesAccessPoint {
    private final  String url = "https://www.ebi.ac.uk/biosamples/samples/";

//    @Autowired
 //   private Biosample biosample;

    public Biosample getSample(String sampleID) throws IOException, JSONException {
        JSONObject sampleJSON = readJsonFromUrl(url + sampleID+".json");
        Biosample biosample = new Biosample();
        biosample.setAccession(sampleJSON.getString("accession"));
        biosample.setDomain(sampleJSON.getString("domain"));
        biosample.setName(sampleJSON.getString("name"));
        return biosample;
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }


    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
