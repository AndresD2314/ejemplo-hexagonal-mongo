package com.example.hexagonal.application.service.ports.input;

import com.example.hexagonal.domain.model.Persona;

import java.util.List;

public interface PersonaInputPort {

    List<Persona> getAllClients();
    Persona getPersonaById(Integer id);
    Persona createPersona(Persona persona);
    Persona updatePersona(Integer id, Persona persona);
    void deletePersona(Integer id);
}
