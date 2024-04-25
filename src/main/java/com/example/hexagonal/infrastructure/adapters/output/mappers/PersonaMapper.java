package com.example.hexagonal.infrastructure.adapters.output.mappers;


import com.example.hexagonal.domain.model.Persona;
import com.example.hexagonal.infrastructure.adapters.output.entities.PersonaEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class PersonaMapper {

    private final ModelMapper modelMapper;

    public Persona entityToDomain(PersonaEntity entity) {
        return modelMapper.map(entity, Persona.class);
    }

    public PersonaEntity domainToEntity(Persona persona) {
        return modelMapper.map(persona, PersonaEntity.class);
    }

}
