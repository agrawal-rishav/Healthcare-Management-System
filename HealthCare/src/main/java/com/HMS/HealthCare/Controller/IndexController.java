package com.HMS.HealthCare.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.HMS.HealthCare.Entity.Contact;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/contact")
    public String getContactPage(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact";
    }

    @PostMapping("/contactUs")
    public String contactForm(@ModelAttribute("contact") Contact contact) {
        System.out.println(contact.getFullname());
        return "index";
    }

    
}
