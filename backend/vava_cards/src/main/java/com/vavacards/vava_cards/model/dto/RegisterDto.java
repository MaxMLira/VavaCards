package com.vavacards.vava_cards.model.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String email;
    private String password;
    private String fullName;
}
