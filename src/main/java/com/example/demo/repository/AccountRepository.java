package com.example.demo.repository;

import com.example.demo.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // Encontra todas as contas associadas a um usuário específico
    List<Account> findByUserId(Long userId);  // Este método já está correto
}
