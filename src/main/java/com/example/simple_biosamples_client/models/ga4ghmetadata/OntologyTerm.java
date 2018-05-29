package com.example.simple_biosamples_client.models.ga4ghmetadata;

public class OntologyTerm implements Comparable {
    private String term_id;
    private String term_label;

    public String getTerm_id() {
        return term_id;
    }

    public void setTerm_id(String term_id) {
        this.term_id = term_id;
    }

    public String getTerm_label() {
        return term_label;
    }

    public void setTerm_label(String term_label) {
        this.term_label = term_label;
    }

    @Override
    public int compareTo(Object o) {
        return this.getTerm_label().compareTo(((OntologyTerm) o).getTerm_label());
    }
}
