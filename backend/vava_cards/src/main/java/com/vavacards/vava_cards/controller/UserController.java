package com.vavacards.vava_cards.controller;

import com.vavacards.vava_cards.model.User;
import com.vavacards.vava_cards.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }


    @GetMapping(value = "/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User current = (User) authentication.getPrincipal();
        return ResponseEntity.ok(current);
    }


}
