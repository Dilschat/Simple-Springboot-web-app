package com.example.simple_biosamples_client.models;

import org.springframework.stereotype.Component;

@Component
public class Biosample {
    private String name;
    private String accession;
    private String domain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccession() {
        return accession;
    }

    public void setAccession(String accession) {
        this.accession = accession;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\n' +
                ", accession='" + accession + '\n' +
                ", domain='" + domain + '\n';
    }
}
