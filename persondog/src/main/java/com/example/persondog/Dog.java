package com.example.persondog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne; // Asegúrate de importar esto
import jakarta.persistence.FetchType; // Asegúrate de importar esto
import jakarta.persistence.JoinColumn; // Opcional, para renombrar la columna
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Dog {

    @Id
    private String id;
    private String name;
    private String breed;
    private int age;
    @JsonIgnore
    @ManyToOne(fetch  = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
}
