package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
  // Busca usuários pelo nome
  List<User> findByName(String name);

  // Adicionando uma busca por email, caso seja necessário
  List<User> findByEmail(String email);
}
