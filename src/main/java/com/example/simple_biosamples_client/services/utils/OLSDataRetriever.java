package com.example.simple_biosamples_client.services.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class OLSDataRetriever {
    private JsonNode node;

    public void readJsonFromUrl(String iri) {
        String linkToTerm = null;
        try {
            linkToTerm = "https://www.ebi.ac.uk/ols/api/terms?iri=" + URLEncoder.encode(iri, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        URL urlToTerm = null;
        try {
            urlToTerm = new URL(linkToTerm);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        String jsonOntology = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(urlToTerm);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.node = node;
    }

    public String StringGetOntologyTermId() {
        JsonNode terms = node.get("terms");
        JsonNode term = node.get(0);
        return term.get("obo_id").asText();
    }

    public String StringGetOntologyTermLabel() {
        JsonNode terms = node.get("terms");
        JsonNode term = node.get(0);
        return term.get("label").asText();
    }

}
