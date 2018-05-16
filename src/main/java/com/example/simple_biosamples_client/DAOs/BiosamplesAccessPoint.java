package com.example.simple_biosamples_client.DAOs;

import com.example.simple_biosamples_client.models.SearchingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;
import uk.ac.ebi.biosamples.client.BioSamplesClient;
import uk.ac.ebi.biosamples.model.Sample;
import uk.ac.ebi.biosamples.model.filter.Filter;
import uk.ac.ebi.biosamples.service.FilterBuilder;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Scope("prototype")
public class BiosamplesAccessPoint {
    private BioSamplesClient client;

    @Autowired
    BiosamplesAccessPoint(BioSamplesClient bioSamplesClient) {
        this.client = bioSamplesClient;
    }

    public Sample getSample(String sampleID) throws NoSuchElementException {
        Optional<Resource<Sample>> optionalResource = client.fetchSampleResource(sampleID);
        Resource<Sample> sampleResource = optionalResource.get();
        return sampleResource.getContent();
    }


    public Iterable<Resource<Sample>> getFilteredSamplesByString(String text, List<String> rawFilters) {
        Collection<Filter> filters = new LinkedList<>();
        if (rawFilters != null) {
            for (String filter : rawFilters) {
                filters.add(FilterBuilder.create().buildFromString(filter));
            }
        }

        return client.fetchSampleResourceAll(text, filters);
    }

    public Iterable<Resource<Sample>> getFilteredSamplesBySearchForm(SearchingForm form) {
        Filter releaseDateFromFilter = FilterBuilder.create()
                .onReleaseDate()
                .from(formatDate(form.getReleaseDateFrom())).build();
        Filter releaseDateUntilFilter = FilterBuilder.create()
                .onReleaseDate().until(formatDate(form.getReleaseDateUntil())).build();
        Collection<Filter> filters = new LinkedList<>();
        filters.add(releaseDateFromFilter);
        filters.add(releaseDateUntilFilter);
        return client.fetchSampleResourceAll(form.getText(), filters);
    }

    private String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        return formatter.format(date);
    }
}

