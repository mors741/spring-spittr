package com.mors741.spittr.web;

import com.mors741.spittr.Spitter;
import com.mors741.spittr.data.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/spitter")
public class SpitterController {

    private final SpitterRepository repository;

    @Autowired
    public SpitterController(SpitterRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registrationForm";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String processRegistration(Spitter spitter, Model model) {
        repository.save(spitter);
        model.addAttribute("username", spitter.getUsername());
        return "redirect:/spitter/{username}";
    }

    @RequestMapping("/{username}")
    public String showSpitterProfile(@PathVariable("username") String username, Model model) {
        model.addAttribute(repository.getByUsername(username));
        return "profile";
    }
}