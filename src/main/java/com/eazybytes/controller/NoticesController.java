package com.eazybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping("/mynotices")
    public String getNoticesDetails(){
        return "Here notices details from DB Available";
    }

}
