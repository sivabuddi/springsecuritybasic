package com.eazybytes.controller;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder  passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){

        Customer   savedCustomer=null;
        ResponseEntity response= null;

        try{
                String hashPwd = passwordEncoder.encode(customer.getPwd());
                customer.setPwd(hashPwd);
                savedCustomer = customerRepository.save(customer);
                if(savedCustomer.getId()>0){
                    response = ResponseEntity.status(HttpStatus.CREATED).body("Used details are successfully registered");
                }
        }catch (Exception exception){
                    response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occured while registering"+exception);
        }

        return response;


    }



}
