package com.vavacards.vava_cards.controller;

import com.vavacards.vava_cards.model.User;
import com.vavacards.vava_cards.model.dto.LoginDto;
import com.vavacards.vava_cards.model.dto.LoginResponseDto;
import com.vavacards.vava_cards.model.dto.RegisterDto;
import com.vavacards.vava_cards.service.AuthenticationService;
import com.vavacards.vava_cards.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        authenticationService.signup(registerDto);
        return ResponseEntity.ok("User created");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginDto loginDto) {
        User authenticateUser = authenticationService.authenticate(loginDto);
        String token = jwtService.generateToken(authenticateUser);
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setToken(token);
        loginResponseDto.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponseDto);
    }




}
