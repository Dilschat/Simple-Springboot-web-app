package com.example.simple_biosamples_client.models.ga4ghmetadata;

public class Biocharacteristics {

    private String description;
    private OntologyTerm[] ontology_terms;
    private OntologyTerm[] negated_ontology_terms;
    private String scope;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OntologyTerm[] getOntology_terms() {
        return ontology_terms;
    }

    public void setOntology_terms(OntologyTerm[] ontology_terms) {
        this.ontology_terms = ontology_terms;
    }

    public OntologyTerm[] getNegated_ontology_terms() {
        return negated_ontology_terms;
    }

    public void setNegated_ontology_terms(OntologyTerm[] negated_ontology_terms) {
        this.negated_ontology_terms = negated_ontology_terms;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }


}
