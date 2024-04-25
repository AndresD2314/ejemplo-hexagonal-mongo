package com.example.hexagonal.infrastructure.adapters.output.repository;

import com.example.hexagonal.infrastructure.adapters.output.entities.PersonaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<PersonaEntity, Integer> {
}
