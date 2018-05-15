package com.example.simple_biosamples_client.DAOs;

import uk.ac.ebi.biosamples.model.Sample;

import java.io.IOException;

public interface AccessPoint {

    Sample getSample(String id) throws IOException;
}
