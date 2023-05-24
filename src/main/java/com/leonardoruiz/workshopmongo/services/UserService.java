package com.leonardoruiz.workshopmongo.services;

import com.leonardoruiz.workshopmongo.domain.User;
import com.leonardoruiz.workshopmongo.repository.UserRepository;
import com.leonardoruiz.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //Para instanciar automaticamente
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
