package com.example.simple_biosamples_client.models.ga4ghmetadata;

public class Age {
    private String age;
    private OntologyTerm age_class;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public OntologyTerm getAge_class() {
        return age_class;
    }

    public void setAge_class(OntologyTerm age_class) {
        this.age_class = age_class;
    }


}
