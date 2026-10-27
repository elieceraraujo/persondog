package com.example.persondog;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Dog {

    @Id
    private String id;
    private String name;
    private String breed;
    private int age;

    @OneToMany(mappedBy = "dog", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Custody> custodies;

}
