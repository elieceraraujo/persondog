package com.example.persondog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "PERSON_DOGS",
            joinColumns = @JoinColumn(name = "PERSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "DOG_ID"))
    private List<Dog> dogs;

}
