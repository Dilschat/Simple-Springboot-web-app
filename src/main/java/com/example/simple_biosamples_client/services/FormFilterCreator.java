package com.example.simple_biosamples_client.services;

import com.example.simple_biosamples_client.models.SearchingForm;
import org.springframework.stereotype.Service;
import uk.ac.ebi.biosamples.model.filter.Filter;
import uk.ac.ebi.biosamples.service.FilterBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Service
public class FormFilterCreator {
    private FilterBuilder builder;
    private Collection<Filter> filters;

    FormFilterCreator() {
        builder = FilterBuilder.create();
        filters = new ArrayList<>();
    }

    public Collection<Filter> getFilters(SearchingForm form) {
        filters.add(createReleaseDateFilters(form.getReleaseDateFrom(), form.getReleaseDateUntil()));
        return filters;
    }

    private Filter createReleaseDateFilters(Date from, Date until) {
        Filter filter = builder
                .onReleaseDate()
                .from(dateFormatter(from))
                .until(dateFormatter(until))
                .build();
        return filter;
    }

    private String dateFormatter(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        return formatter.format(date);
    }
}
