package com.example.demo.model.dtos.accounts;

import java.math.BigDecimal;

public record UpdateAccountDto(
        String name,
        BigDecimal balance
) {
}
