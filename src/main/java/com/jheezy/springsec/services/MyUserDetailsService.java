package com.jheezy.springsec.services;

import com.jheezy.springsec.model.UserPrincipal;
import com.jheezy.springsec.model.Users;
import com.jheezy.springsec.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return Optional.ofNullable(repo.findByUsername(username))
                .map(UserPrincipal::new)
                .orElseThrow();

    }
}
