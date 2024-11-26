package com.example.demo.model.dtos.users;

import java.math.BigDecimal;

public record UpdateUserDto(
        String name,
        String email,
        int age
) {
}
