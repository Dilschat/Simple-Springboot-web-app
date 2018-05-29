package com.example.simple_biosamples_client.models.ga4ghmetadata;

import java.util.SortedSet;

public class Biocharacteristics implements Comparable {

    private String description;
    private SortedSet<OntologyTerm> ontology_terms;
    private SortedSet<OntologyTerm> negated_ontology_terms;
    private String scope;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SortedSet<OntologyTerm> getOntology_terms() {
        return ontology_terms;
    }

    public void setOntology_terms(SortedSet<OntologyTerm> ontology_terms) {
        this.ontology_terms = ontology_terms;
    }

    public SortedSet<OntologyTerm> getNegated_ontology_terms() {
        return negated_ontology_terms;
    }

    public void setNegated_ontology_terms(SortedSet<OntologyTerm> negated_ontology_terms) {
        this.negated_ontology_terms = negated_ontology_terms;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }


    @Override
    public int compareTo(Object o) {
        return this.getDescription().compareTo(((Biocharacteristics) o).getDescription());
    }
}
