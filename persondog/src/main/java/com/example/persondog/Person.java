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
public class Person {

    @Id
    private String id;
    private String name;
    private int age;

    @OneToMany(mappedBy = "person" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Custody> custodies;

}
