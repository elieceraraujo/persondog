package com.example.persondog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PersondogApplicationTests {

	@Autowired
	PersonRepository personRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testJPA(){

		Person jack = Person.builder().id("1").name("Jack").age(23).build();
		Person yeny = Person.builder().id("2").name("Yeny").age(54).build();
		Person yake = Person.builder().id("3").name("Yaque").age(48).build();

		Dog rita = Dog.builder().id("1").name("Rita").age(3).build();
		Dog curro = Dog.builder().id("2").name("Curro").age(2).build();
		Dog kira = Dog.builder().id("3").name("Kira").age(1).build();

		List<Dog> dogs = new ArrayList<>();
		dogs.add(rita);
		dogs.add(curro);

		List<Dog> dogs2 = new ArrayList<>();
		dogs2.add(rita);

		List <Dog> dogs3 = new ArrayList<>();
		dogs3.add(curro);
		dogs3.add(rita);
		dogs3.add(kira);

		yeny.setDogs(dogs);
		jack.setDogs(dogs2);
		yake.setDogs(dogs3);

		personRepository.save(jack);
		personRepository.save(yeny);
		personRepository.save(yake);

		System.out.println(personRepository.findAll());
	}

}
