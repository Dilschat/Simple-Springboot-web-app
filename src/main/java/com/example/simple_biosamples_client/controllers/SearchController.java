package com.example.simple_biosamples_client.controllers;

import com.example.simple_biosamples_client.DAOs.BiosamplesAccessPoint;
import com.example.simple_biosamples_client.models.SearchingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.ac.ebi.biosamples.model.Sample;

import javax.validation.Valid;


@Controller
@EnableAutoConfiguration
public class SearchController {

    @Autowired
    protected SearchingForm form;
    @Autowired
    protected BiosamplesAccessPoint accessPoint;


    @GetMapping("/SearchingForm")
    public String getSearchForm(Model model) {
        model.addAttribute("SearchingForm", form);
        return "SearchingForm";
    }

    @RequestMapping(value = "/SearchingForm/result", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Resource<Sample>> submitForm(@Valid @ModelAttribute("SearchingForm") SearchingForm form) {
        return accessPoint.getFilteredSamplesBySearchForm(form);
    }
}
