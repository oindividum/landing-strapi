package com.example.strapi_1.controller;

import com.example.strapi_1.model.*;
import com.example.strapi_1.model.Footer;
import com.example.strapi_1.service.EmailService;
import com.example.strapi_1.service.StrapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class LandingPageController {
    private final StrapiService strapiService;
    private final EmailService emailService;

    @Autowired
    public LandingPageController(StrapiService strapiService, EmailService emailService) {
        this.strapiService = strapiService;
        this.emailService = emailService;
    }

    @GetMapping()
    public String viewLandingPage(Model model) {
        Header header = strapiService.getHeaderContent();
        LandingPageContent content = strapiService.getLandingPageContent();
        AboutSection aboutSection = strapiService.getAboutSection();
        List<Product> productList = strapiService.getProducts();
        LineLogo lineLogo = strapiService.getLineLogo();
        ContactSection contactSection = strapiService.getContactSection();
        Footer footer = strapiService.getFooter();
        //        System.out.println("Проблема: " + productList.size());

        model.addAttribute("header", header);
        model.addAttribute("landingPageContent", content);
        model.addAttribute("aboutSection", aboutSection);
        model.addAttribute("products", productList);
        model.addAttribute("lineLogo", lineLogo);
        model.addAttribute("contactSection", contactSection);
        model.addAttribute("footer", footer);
        model.addAttribute("contactForm", new ContactFormDto());

        return "landingPage";
    }

    @PostMapping("/submit-contact-form")
    public String submitContactForm(@ModelAttribute ContactFormDto contactForm) {

        emailService.sendContactFormEmail(contactForm);
        return "redirect:/";
    }
}