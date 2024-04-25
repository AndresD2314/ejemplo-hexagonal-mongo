package com.example.hexagonal.application.service.ports.output;

import com.example.hexagonal.domain.model.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaOutputPort {
    List<Persona> findAll();
    Optional<Persona> findById(Integer id);
    Persona save(Persona persona);
    void deleteById(Integer id);
}
