package com.vavacards.vava_cards.model.dto;

import lombok.Data;

@Data
public class LoginResponseDto {

    private String token;
    private long expiresIn;

}
