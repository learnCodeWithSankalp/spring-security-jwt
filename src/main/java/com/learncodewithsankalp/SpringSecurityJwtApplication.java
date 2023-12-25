package com.learncodewithsankalp;


import com.learncodewithsankalp.entity.Employee;
import com.learncodewithsankalp.respository.EmployeeRepositrory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	@Autowired
	EmployeeRepositrory employeeRepositrory;

	@PostConstruct
	public void initUsers(){
		List<Employee> employeeList = Arrays.asList(
				new Employee(1, "Rahul", "rahul@123", "rahul@lcwsankalp.com"),
		new Employee(2, "Parvin", "Pravin@123", "pravin@lcwsankalp.com"),
		new Employee(3, "Mohan", "mohan@123", "mohan@lcwsankalp.com")
		).stream().collect(Collectors.toList());

		employeeRepositrory.saveAll(employeeList);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}
