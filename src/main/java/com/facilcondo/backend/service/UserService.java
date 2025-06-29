package com.facilcondo.backend.service;

import com.facilcondo.backend.model.User;
import com.facilcondo.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public User create(User user) {
        return repository.save(user);
    }

    public User update(Long id, User updated) {
        User existing = getById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setPassword(updated.getPassword());
        existing.setRole(updated.getRole());
        existing.setPhoneNumber(updated.getPhoneNumber());
        existing.setLanguage(updated.getLanguage());
        existing.setIsActive(updated.getIsActive());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
