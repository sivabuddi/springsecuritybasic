package com.eazybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping("/mybalance")
    public String getBalanceDetails(){
        return "Here Balance details from DB Available";
    }

}
