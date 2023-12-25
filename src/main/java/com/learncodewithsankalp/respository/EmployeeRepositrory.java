package com.learncodewithsankalp.respository;


import com.learncodewithsankalp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositrory extends JpaRepository<Employee,Integer> {
    Employee findByUserName(String username);
}
