package com.example.hexagonal.infrastructure.adapters.output;

import com.example.hexagonal.application.service.ports.output.PersonaOutputPort;
import com.example.hexagonal.domain.model.Persona;
import com.example.hexagonal.infrastructure.adapters.output.entities.PersonaEntity;
import com.example.hexagonal.infrastructure.adapters.output.mappers.PersonaMapper;
import com.example.hexagonal.infrastructure.adapters.output.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PersonaOutputAdapter implements PersonaOutputPort {

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;

    @Override
    public List<Persona> findAll() {
        List<PersonaEntity> personas = personaRepository.findAll();
        return personas.stream().map(personaMapper::entityToDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Persona> findById(Integer id) {
        return personaRepository.findById(id).map(personaMapper::entityToDomain);
    }

    @Override
    public Persona save(Persona persona) {
        return personaMapper.entityToDomain(personaRepository.save(personaMapper.domainToEntity(persona)));
    }

    @Override
    public void deleteById(Integer id) {
        personaRepository.deleteById(id);
    }
}
