package com.example.springapp.controllers;

import com.example.springapp.models.SalesJPA;
import com.example.springapp.repositories.SalesJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AppController {

    @Autowired
    SalesJPARepository repository;

    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/workspace")
    public String getWorspace(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model){
        model.addAttribute("name", name);
        model.addAttribute("sales", repository.findAll());
        model.addAttribute("sale", new SalesJPA());
        return "workspace";
    }

    @PostMapping("/workspace")
    public String setNewSale(@Valid SalesJPA sale, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "redirect:/workspace";
        }
        repository.save(sale);
        return "redirect:/workspace";
    }
}