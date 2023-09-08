package com.example.demo.Management;

import com.example.demo.StudentPackage.StudentRepo;
import com.example.demo.StudentPackage.student;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceClass {

    private final M_Repo m_repo;

    private final StudentRepo studentRepo;

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public List<Manager> FindAll(){
        return m_repo.findAll();
    }

    public Manager FindById(int manager){
        return m_repo.findById(manager).orElseThrow(()-> new IllegalStateException("Employee Not Found"));
    }

    public student AddStudent (student add){
        String encoded = bCryptPasswordEncoder.encode(add.getPassword());
        add.setPassword(encoded);
        return studentRepo.save(add);
    }


}
