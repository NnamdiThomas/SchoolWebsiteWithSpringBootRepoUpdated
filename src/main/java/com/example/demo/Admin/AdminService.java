package com.example.demo.Admin;

import com.example.demo.Management.M_Repo;
import com.example.demo.Management.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AdminService implements UserDetailsService {
private final M_Repo m_repo;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AdminService(M_Repo m_repo) {
        this.m_repo = m_repo;
    }



    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Manager> user = this.m_repo.findManagerByName(username);

        return user.map(Admin::new)
                .orElseThrow(() -> new IllegalStateException("user not found " + username));
    }

    public Manager AddStaff (Manager add){
        String encoded = bCryptPasswordEncoder.encode(add.getPassword());
        add.setPassword(encoded);
        return m_repo.save(add);
    }


}
