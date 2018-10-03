package com.sortir.sortir.service;

import com.sortir.sortir.entity.MyUserPrincipal;
import com.sortir.sortir.entity.Participant;
import com.sortir.sortir.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        Participant user = userRepository.findByPseudo(username);

        System.out.println(user.getPseudo());
        System.out.println(user.getPassword());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        System.out.println(bCryptPasswordEncoder.encode("1234"));

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new MyUserPrincipal(user);
    }
}