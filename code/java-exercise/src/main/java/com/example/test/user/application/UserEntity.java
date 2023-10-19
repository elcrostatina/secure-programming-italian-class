package com.example.test.user.application;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Column(columnDefinition = "integer default 0")
    private int credits;
}
