package com.example.demo.Management;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Manager {

    @Id
    @SequenceGenerator(
            name = "manger_sequence",
            sequenceName = "manage_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "manage_sequence")


    private Integer id;
    private String name;
    private String Password;
    private String Imageurl;
    private LocalDate DOB;
    @Transient
    private int Age;
    private Sex sex;
    @Enumerated(EnumType.STRING)
    private Roles roles;

    public int getAge() {
        return Period.between(this.DOB,
                LocalDate.now()).getYears();
    }


}
