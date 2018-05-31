package com.example.simple_biosamples_client.models.ga4ghmetadata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class Age {
    private String age;
    private OntologyTerm age_class;

    @JsonProperty("age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @JsonProperty("age_class")
    public OntologyTerm getAge_class() {
        return age_class;
    }

    public void setAge_class(OntologyTerm age_class) {
        this.age_class = age_class;
    }


}
