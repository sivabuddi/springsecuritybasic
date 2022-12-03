package com.eazybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/mycontacts")
    public String getContactDetails(){
        return "Here contact details from DB Available";
    }

}
