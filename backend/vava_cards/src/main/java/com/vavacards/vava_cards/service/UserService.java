package com.vavacards.vava_cards.service;



import com.vavacards.vava_cards.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }


}
