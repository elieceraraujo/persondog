package com.example.persondog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersondogApplicationTests {

	@Autowired
	DogRepository dogRepository;

	@Test
	void contextLoads() {
	}


	@Test
	void testJPA() {

		Person person = Person.builder().id("1")
				.name("Jose")
				.age(34)
				.build();

		Dog dog1 = Dog.builder().id("1").name("Rita").age(3).breed("Belga pastor").build();
		Dog dog2 = Dog.builder().id("2").name("Curro").age(2).breed("Vasco pastor").build();
		Dog dog3 = Dog.builder().id("3").name("Kira").age(5).breed("Border Colle").build();

		dog1.setPerson(person);
		dog2.setPerson(person);
		dog3.setPerson(person);

		dogRepository.save(dog1);
		dogRepository.save(dog2);
		dogRepository.save(dog3);

		System.out.println(dog1);
		System.out.println(dog2);
		System.out.println(dog3);
	}

}
