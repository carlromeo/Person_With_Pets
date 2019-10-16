package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PetRepository petRepository;

    @RequestMapping("/")
    public String home (Model model){
        model.addAttribute("persons", personRepository.findAll());
        model.addAttribute("pets", petRepository.findAll());
        return "index";
    }

    @GetMapping("/addperson")
    public String personForm(Model model){
        model.addAttribute("person", new Person());
        return "personform";
        }

    @PostMapping("/processperson")
    public String personForm(@Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "personform";
        }
        personRepository.save(person);
        return "redirect:/personlist";
    }

    @RequestMapping("/personlist")
    public String personList(Model model){
        model.addAttribute("persons", personRepository.findAll());
            return "personlist";
    }

    @RequestMapping("/petlist")
    public String pettList(Model model){
        model.addAttribute("pet", personRepository.findAll());
        return "petlist";
    }


    @GetMapping("/addpet")
    public String petForm(Model model){
        model.addAttribute("pets", petRepository.findAll());
        model.addAttribute("student", new Pet());
        return "petform";
        }

    @PostMapping("/processpet")
    public String processPetForm (@Valid Pet pet, BindingResult result){
        if (result.hasErrors()){
            return  "petform";
        }
        petRepository.save(pet);
        return "redirect:/petlist";
    }


    @RequestMapping("/detail/{id}")
        public String showPerson(@PathVariable("id") long id, Model model) {
        model.addAttribute("person", personRepository.findAll());
        return "showperson";
    }

    @RequestMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") long id, Model model) {
        model.addAttribute("person", personRepository.findById(id).get());
        return "personform";
    }

    @RequestMapping("/delete/{id}")
    public String delPerson(@PathVariable("id") long id) {
        personRepository.deleteById(id);
        return "index";
    }

    @RequestMapping("/detailpet/{id}")
    public String showpet(@PathVariable("id") long id, Model model) {
        model.addAttribute("pet", petRepository.findById(id).get());
        return "showpet";
    }

    @RequestMapping("/updatepet/{id}")
    public String updatepet(@PathVariable("id") long id, Model model) {
        model.addAttribute("pet", petRepository.findById(id).get());
        model.addAttribute("person", personRepository.findAll());
        return "petform";
    }

    @RequestMapping("/deletepet/{id}")
    public String delPet(@PathVariable("id") long id){
        petRepository.deleteById(id);
        return "index";
        }

    }





