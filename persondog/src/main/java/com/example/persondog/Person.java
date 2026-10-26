package com.example.persondog;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;   // Importación necesaria
import jakarta.persistence.CascadeType; // Importación necesaria
import lombok.*;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Person {

    @Id
    private String id;
    private String name;
    private int age;
    @OneToMany(mappedBy="person", cascade = CascadeType.ALL)
    @ToString.Exclude // Evita bucles infinitos en el toString() de Lombok
    @EqualsAndHashCode.Exclude // Evita bucles infinitos en el equals/hashcode
    private List<Dog> dogs;

}
