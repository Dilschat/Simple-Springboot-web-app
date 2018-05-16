package com.example.simple_biosamples_client.controllers;

import com.example.simple_biosamples_client.DAOs.BiosamplesAccessPoint;
import com.example.simple_biosamples_client.models.SearchingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uk.ac.ebi.biosamples.model.Sample;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
@EnableAutoConfiguration
public class SearchController {

    private SearchingForm form;
    private BiosamplesAccessPoint accessPoint;

    @Autowired
    SearchController(SearchingForm searchingForm, BiosamplesAccessPoint biosamplesAccessPoint) {
        this.form = searchingForm;
        this.accessPoint = biosamplesAccessPoint;
    }

    @GetMapping("/SearchingForm")
    public String getSearchForm(Model model) {
        model.addAttribute("SearchingForm", form);
        return "SearchingForm";
    }

    @RequestMapping(value = "/SearchingForm", method = GET)
    @ResponseBody
    public Iterable<Resource<Sample>> submitForm(@Valid @ModelAttribute("SearchingForm") SearchingForm form) {
        return accessPoint.getFilteredSamplesBySearchForm(form);
    }
}
