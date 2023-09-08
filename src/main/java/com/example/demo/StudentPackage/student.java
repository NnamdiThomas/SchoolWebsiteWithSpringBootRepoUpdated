package com.example.demo.StudentPackage;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class student {
@Id
@GeneratedValue

    private  int id;
    private  String FirstName;
    private  String LastName;
    private   Sex   sex;
    private  String ImageURL;
    private  Date DOB;
    private  int Position;
    private  String Subject;
    private String Password;

}
