package com.example.test.user.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class WithdrawDto {
    private UUID userId;
    private int credits;

    public WithdrawDto(UUID userId, int credits) {
        this.userId = userId;
        this.credits = credits;
    }
}
