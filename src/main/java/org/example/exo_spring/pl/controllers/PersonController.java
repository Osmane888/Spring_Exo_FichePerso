package org.example.exo_spring.pl.controllers;

import org.example.exo_spring.dl.entities.Contacts;
import org.example.exo_spring.dl.entities.Person;
import org.example.exo_spring.dl.entities.Skills;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/person")
public class PersonController {

    private Person person;

    public PersonController(){
        person = new Person("Guesmia","Osmane");
        person.getSkills().add(new Skills("Java","Développement d'applications Java"));
        person.getSkills().add(new Skills("Front-End", "Manipulation de HTML et CSS pour habiller le front d'un site"));
        person.getSkills().add(new Skills("Gestionnaire en DB SQL et PostgreSQL", "Connaissances théoriques et pratiques en gestion de bases de données sous MS SQL et PostgreSQL"));
    }

    @GetMapping
    public String getInfo(Model model){
        model.addAttribute("person", person);
        return "person";
    }

    @GetMapping("/skill/{title}")
    public String getSkill(@PathVariable String title, Model model){
        try{
            Skills skill = person.getSkills().stream().filter(s -> s.getTitle().equals(title)).findFirst().orElseThrow();
            model.addAttribute("skill", skill);
            return "skill";
        }catch (NoSuchElementException e){
            return "error";
        }
    }

    @GetMapping("/addContact")
    public String addContact(Model model){
        model.addAttribute("contact", new Contacts());
        return "add";
    }

    @PostMapping("/addContact")
    public String addContact(@ModelAttribute Contacts contacts){
        person.getContacts().add(new Contacts(contacts.getName(), contacts.getFirstname(), contacts.getEmail(), contacts.getPhoneNumber()));
        return "redirect:/person";
    }

}