package com.example.persondog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersondogApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private DogRepository dogRepository;

	@Test
	void debeGuardarPersonaYPerrosCorrectamente() {
		personRepository.deleteAll();
		dogRepository.deleteAll();
		// 1. Crear la Persona
		Person persona = Person.builder()
				.id("P100")
				.name("Carlos")
				.age(30)
				.build();

		// 2. Crear el Perro y asociarlo a la persona
		Dog perro = Dog.builder()
				.id("D200")
				.name("Firulais")
				.breed("Labrador")
				.age(3)
				.person(persona) // Relación ManyToOne
				.build();

		// Asignar la lista de perros a la persona (Relación OneToMany)
		persona.setDogs(List.of(perro));

		// 3. Guardar en la base de datos (cascade = CascadeType.ALL guardará al perro también)
		Person personaGuardada = personRepository.save(persona);

		// 4. Verificaciones (Assertions)
		assertThat(personaGuardada).isNotNull();
		assertThat(personaGuardada.getDogs()).hasSize(1);
		assertThat(personaGuardada.getDogs().getFirst().getName()).isEqualTo("Firulais");
	}
}
