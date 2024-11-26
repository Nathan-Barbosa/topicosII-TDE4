package com.example.demo.model.dtos.users;

import java.math.BigDecimal;

public record CreateUserDto(
        String name,
        String email,
        int age,
        Long userId
) {
}
