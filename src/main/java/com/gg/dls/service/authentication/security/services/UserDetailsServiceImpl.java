package com.gg.dls.service.authentication.security.services;


import com.gg.dls.service.authentication.model.User;
import com.gg.dls.service.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
                );
        return (UserDetails) UserPrinciple.build(user);
    }


    @Transactional
    public UserDetails loadUserByUserId(Long userId) throws Exception{

        User user = userRepository.findUserById(userId)
                .orElseThrow(() -> new Exception("User Not Found - UserDetailsServiceImpl.class"));
        return (UserDetails) UserPrinciple.build(user);
    }
}