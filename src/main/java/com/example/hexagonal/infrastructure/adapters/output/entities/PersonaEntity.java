package com.example.hexagonal.infrastructure.adapters.output.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Entity
@Document("PERSONA")
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEntity {

    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
}
