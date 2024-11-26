package com.example.demo.model.dtos.accounts;

import java.math.BigDecimal;

public record CreateAccountDto(
        String name,
        BigDecimal balance,
        Long userId
) {
}
