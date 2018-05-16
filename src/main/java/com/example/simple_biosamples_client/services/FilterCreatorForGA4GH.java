package com.example.simple_biosamples_client.services;

import org.springframework.stereotype.Service;
import uk.ac.ebi.biosamples.model.filter.Filter;
import uk.ac.ebi.biosamples.service.FilterBuilder;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
public class FilterCreatorForGA4GH {

    private FilterBuilder builder;
    private Collection<Collection<Filter>> filters;
    private final String externalReference = "ENA";
    private final List<String> attributeLabels = Arrays.asList("Organism", "organism");
    private final List<String> values = Arrays.asList("Homo sapiens", "homo sapiens");

    public FilterCreatorForGA4GH() {
        builder = FilterBuilder.create();
        filters = new LinkedList<>();
        createFilters();
    }

    public Collection<Collection<Filter>> getFilters() {
        return filters;
    }

    private void createFilters() {
        for (String attribute : attributeLabels) {
            for (String value : values) {
                List<Filter> tempFilters = new LinkedList<>();
                Filter attrbuteFilter = builder
                        .onAttribute(attribute)
                        .withValue(value)
                        .build();
                Filter externalReferenceFilter = builder
                        .onDataFromExternalReference(externalReference)
                        .build();
                tempFilters.add(attrbuteFilter);
                tempFilters.add(externalReferenceFilter);
                filters.add(tempFilters);
            }

        }

    }

}

