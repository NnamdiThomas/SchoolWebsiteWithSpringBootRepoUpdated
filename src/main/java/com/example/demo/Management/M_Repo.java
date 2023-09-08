package com.example.demo.Management;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface M_Repo extends JpaRepository<Manager, Integer> {

    Optional<Manager> findManagerByName(String Name);


}
