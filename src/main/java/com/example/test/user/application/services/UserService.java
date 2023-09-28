package com.example.test.user.application.services;

import com.example.test.user.application.UserEntity;
import com.example.test.user.application.dto.WithdrawDto;
import com.example.test.user.infrastructure.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @SneakyThrows
    public int withdrawCredits(WithdrawDto params) {
        UserEntity user = userRepository.findOneById(params.getUserId());

        if (user.getCredits() < params.getCredits()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Insufficient credits");
        }

        Thread.sleep(5000);

        user.setCredits(user.getCredits() - params.getCredits());
        userRepository.save(user);

        return params.getCredits();
    }
}
