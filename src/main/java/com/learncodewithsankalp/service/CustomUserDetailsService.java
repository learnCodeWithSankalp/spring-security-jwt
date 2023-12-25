package com.learncodewithsankalp.service;

import com.learncodewithsankalp.entity.Employee;
import com.learncodewithsankalp.respository.EmployeeRepositrory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepositrory employeeRepositrory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee=employeeRepositrory.findByUserName(username);

        return new User(employee.getUserName(),employee.getPassword(),new ArrayList<>());
    }
}
