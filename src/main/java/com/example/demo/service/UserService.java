package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dtos.users.CreateUserDto;
import com.example.demo.model.dtos.users.UpdateUserDto;
import com.example.demo.model.entities.User;
import com.example.demo.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User create(CreateUserDto createUserDto) {
        User newUser = new User();
        newUser.setName(createUserDto.name());
        newUser.setEmail(createUserDto.email());
        newUser.setAge(createUserDto.age());
        return userRepository.save(newUser);
    }

    public ResponseEntity<User> update(Long id, UpdateUserDto updateUserDto) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setName(updateUserDto.name());
            user.setEmail(updateUserDto.email());
            user.setAge(updateUserDto.age());
            userRepository.save(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<Void> delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
