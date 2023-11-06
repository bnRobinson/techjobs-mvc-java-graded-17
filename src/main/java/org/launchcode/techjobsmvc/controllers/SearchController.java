package org.launchcode.techjobsmvc.controllers;

import org.launchcode.techjobsmvc.models.Job;
import org.launchcode.techjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Objects;

import static org.launchcode.techjobsmvc.controllers.ListController.columnChoices;



/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {


    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping
    public ArrayList<Job> displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        // TODO #3 - Create a handler to process a search request and render the updated search view.
        ArrayList<Job> jobs = new ArrayList<Job>();
        if (Objects.equals(searchTerm, "") || Objects.equals(searchTerm, "all")) {
            jobs =JobData.findAll();
        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        }
        return jobs;
    }
}



