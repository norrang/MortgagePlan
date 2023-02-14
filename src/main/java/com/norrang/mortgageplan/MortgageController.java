package com.norrang.mortgageplan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MortgageController {

    private final MortgageCalculator mortgageCalculator;

    public MortgageController(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
    }

    @GetMapping("/")
    public String getEstimates(Model model) {
        var estimates = mortgageCalculator.getEstimates();
        model.addAttribute("estimates", estimates);
        return "estimates";
    }

    @GetMapping("/add")
    public String addEstimates(Model model) {
        var estimate = new Estimate();
        model.addAttribute("estimate", estimate);
        return "add";
    }

    @PostMapping("/add")
    public String estimateSubmit(@ModelAttribute Estimate estimate) {
        estimate.setYearlyInterest(estimate.getYearlyInterest() / 100);
        mortgageCalculator.addEstimate(estimate);
        return "redirect:/";
    }

}
