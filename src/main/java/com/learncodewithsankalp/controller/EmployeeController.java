package com.learncodewithsankalp.controller;

import com.learncodewithsankalp.entity.AuthRequest;
import com.learncodewithsankalp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import com.learncodewithsankalp.config.*;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome(){
        return "Welcome to Learn Code with Sankalp";
    }



    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(),
                            authRequest.getPassword()));
        }catch (Exception e){
            throw new Exception("Invalid username or password");
        }


        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
