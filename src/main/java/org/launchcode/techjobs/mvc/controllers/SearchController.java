package org.launchcode.techjobs.mvc.controllers;

import org.launchcode.techjobs.mvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Name;
import java.lang.reflect.Type;

import static org.launchcode.techjobs.mvc.controllers.ListController.columnChoices;
import static org.launchcode.techjobs.mvc.models.JobData.findAll;
import static org.launchcode.techjobs.mvc.models.JobData.findByColumnAndValue;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    private String radio;
    private String searchType;
    private String searchTerm;

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.

    @PostMapping(value = "results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        model.addAttribute("columns", columnChoices);
        if (searchTerm.equalsIgnoreCase("all")) {
            model.addAttribute("jobs", JobData.findAll());
        } else {
            model.addAttribute("jobs", JobData.findByColumnAndValue(searchType, searchTerm));
        }
        return "search";
    }

//    private Object findByColumnAndValue() {
//        return
//    }

}
//    @PostMapping("formTemplateName")
//    public String processFormMethodName(@RequestParam Type parameter1, Type parameter2, ...) {
//
//        // Method code...
//
//        return "redirect:templateName";
//    }

