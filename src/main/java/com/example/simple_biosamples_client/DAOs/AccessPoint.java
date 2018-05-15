package com.example.simple_biosamples_client.DAOs;

import java.io.IOException;

public interface AccessPoint {

    Object getSample(String id) throws IOException;
}
