package com.learncodewithsankalp.entity;


import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USER_TBL")
public class Employee {

    @Id
    private int id;
    private String userName;
    private String password;
    private String email;

}
