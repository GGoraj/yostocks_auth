package com.gg.dls.service.authentication.controller;

import com.gg.dls.service.authentication.message.response.UserResponse;
import com.gg.dls.service.authentication.model.User;
import com.gg.dls.service.authentication.repository.UserRepository;
import com.gg.dls.service.authentication.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("/api/user/")
@RestController
public class UserRestAPI {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JwtProvider tokenProvider;


    @GetMapping("/details")
    public UserResponse getUserDetails(@RequestHeader("Authorization") String value){

        String token = value.substring(7,value.length());
        Long userId = Long.valueOf(tokenProvider.getUserNameFromJwtToken(token));

        User dbUser = userRepository.findUserById(Long.valueOf(userId))
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Id found."));

        UserResponse user = new UserResponse(dbUser.getId(), dbUser.getName(), dbUser.getEmail());
        return user;
    }


}
