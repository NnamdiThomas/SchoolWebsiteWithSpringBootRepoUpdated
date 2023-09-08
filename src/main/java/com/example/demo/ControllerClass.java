package com.example.demo;

import com.example.demo.Admin.AdminService;
import com.example.demo.Admin.AuthRequest;
import com.example.demo.Management.Manager;
import com.example.demo.Management.ServiceClass;
import com.example.demo.SECURITY.JwtService;
import com.example.demo.StudentPackage.StudentService;
import com.example.demo.StudentPackage.student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ControllerClass {

    private final AdminService adminService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final StudentService service;

    private final ServiceClass serviceClass;

    @GetMapping("/id/{id}")
    public ResponseEntity<student> find_users(@PathVariable("id") int id) {
        student user = service.findStudent(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<student> findAllUsers() {
        student user = (student) service.findall();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<Manager> find_teacher(@PathVariable("id") int id) {
        Manager user = serviceClass.FindById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("/find/all")
    public ResponseEntity<Manager> find_users() {
        Manager user = (Manager) serviceClass.FindAll();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    
    @PostMapping("/student/add")
    public ResponseEntity<student> Add_users(@RequestBody student users) {
        student New_Users = serviceClass.AddStudent(users);
        return new ResponseEntity<>(New_Users, HttpStatus.CREATED);
    }
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }

    }
    @PostMapping("/staff/add")
    public ResponseEntity<Manager> Add_Staff(@RequestBody Manager users) {
        Manager New_Users = adminService.AddStaff(users);
        return new ResponseEntity<>(New_Users, HttpStatus.CREATED);
    }
}