package com.example.hexagonal.application.service.usecases;

import com.example.hexagonal.application.service.ports.input.PersonaInputPort;
import com.example.hexagonal.application.service.ports.output.PersonaOutputPort;
import com.example.hexagonal.domain.model.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaUseCase implements PersonaInputPort {

    private final PersonaOutputPort personaOutputPort;

    @Override
    public List<Persona> getAllClients() {
        return personaOutputPort.findAll();
    }


    @Override
    public Persona getPersonaById(Integer id) {
        return personaOutputPort.findById(id).orElse(null);
    }

    @Override
    public Persona createPersona(Persona persona) {
        return personaOutputPort.save(persona);
    }

    @Override
    public Persona updatePersona(Integer id, Persona persona) {

        return personaOutputPort.findById(id).
                map( savedStudent -> {
                    savedStudent.setApellido(persona.getApellido());
                    savedStudent.setEdad(persona.getEdad());
                    savedStudent.setNombre(persona.getNombre());
                    return personaOutputPort.save(savedStudent);
                })
                .orElse(null);
    }

    @Override
    public void deletePersona(Integer id) {

        if (personaOutputPort.findById(id).isEmpty()) {
            return;
        }

        personaOutputPort.deleteById(id);

    }
}
