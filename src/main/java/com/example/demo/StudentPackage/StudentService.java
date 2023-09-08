package com.example.demo.StudentPackage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;

    public student findStudent(int id){
        return studentRepo.findById(id).orElseThrow(()-> new IllegalStateException("Student Not Found"));
    }

    public List<student> findall(){
        return studentRepo.findAll();
    }
}
