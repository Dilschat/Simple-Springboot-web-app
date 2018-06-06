package com.example.simple_biosamples_client;

import com.example.simple_biosamples_client.ga4gh_services.OLSDataRetriever;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OLSDataRetreiverTest {

    @Test
    public void id_retrieving_test() {
        OLSDataRetriever retriever = new OLSDataRetriever();
        retriever.readJsonFromUrl("http://purl.obolibrary.org/obo/NCBITaxon_9606");
        String expected_id = "NCBITaxon:9606";
        String actual_id = retriever.StringGetOntologyTermId();
        assertEquals(actual_id, expected_id);
    }

    @Test
    public void label_retreiving_test() {
        OLSDataRetriever retriever = new OLSDataRetriever();
        retriever.readJsonFromUrl("http://purl.obolibrary.org/obo/NCBITaxon_9606");
        String expected_label = "Homo sapiens";
        String actual_label = retriever.StringGetOntologyTermLabel();
        assertEquals(actual_label, expected_label);
    }
}
