package com.example.simple_biosamples_client.DAOs;

import com.example.simple_biosamples_client.models.SearchingForm;
import com.example.simple_biosamples_client.services.FilterCreatorForGA4GH;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;
import uk.ac.ebi.biosamples.client.BioSamplesClient;
import uk.ac.ebi.biosamples.model.Sample;
import uk.ac.ebi.biosamples.model.filter.Filter;
import uk.ac.ebi.biosamples.service.FilterBuilder;

import java.util.*;

@Component
@Scope("prototype")
public class BiosamplesAccessPoint {

    private BioSamplesClient client;
    private FilterCreatorForGA4GH filterCreator;

    @Autowired
    BiosamplesAccessPoint(BioSamplesClient bioSamplesClient, FilterCreatorForGA4GH filterCreator) {
        this.client = bioSamplesClient;
        this.filterCreator = filterCreator;
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
        Filter releaseDateFilter = FilterBuilder.create()
                .onReleaseDate()
                .from(form.getReleaseDateFrom().toString())
                .until(form.getReleaseDateUntil().toString())
                .build();

        Collection<Collection<Filter>> filters = filterCreator.getFilters();
        ArrayList<Resource<Sample>> results = new ArrayList<>();

        for (Collection<Filter> filter : filters) {
            filter.add(releaseDateFilter);
            Iterable<Resource<Sample>> result = client.fetchSampleResourceAll(form.getText(), filter);
            results.addAll(Lists.newArrayList(result));
        }

        return results;
    }

}

