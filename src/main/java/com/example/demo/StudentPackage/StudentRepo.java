package com.example.demo.StudentPackage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<student , Integer> {
   // void delete(int id);
}
