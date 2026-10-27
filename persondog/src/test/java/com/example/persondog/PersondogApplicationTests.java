package com.example.persondog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class PersondogApplicationTests {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	DogRepository  dogRepository;

	@Autowired
	CustodyRepository  custodyRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testJPA(){

		List<Custody> custodies = new ArrayList<>();
		Person jack = Person.builder().id("1").name("Jack").age(23).custodies(custodies).build();
		Person yeny = Person.builder().id("2").name("Yeny").age(54).custodies(custodies).build();
		Person yake = Person.builder().id("3").name("Yaque").age(48).custodies(custodies).build();

		Dog rita = Dog.builder().id("1").name("Rita").age(3).custodies(custodies).build();
		Dog curro = Dog.builder().id("2").name("Curro").age(2).custodies(custodies).build();
		Dog kira = Dog.builder().id("3").name("Kira").age(1).custodies(custodies).build();

		personRepository.save(jack);
		personRepository.save(yeny);
		personRepository.save(yake);

		dogRepository.save(rita);
		dogRepository.save(curro);
		dogRepository.save(kira);

		Custody custodyJackRita = Custody.builder().fecha(new Date()).person(jack).dog(rita).build();
		Custody custodyJackCurro = Custody.builder().fecha(new Date()).person(jack).dog(curro).build();
		List<Custody> custodiesJack = new ArrayList<>();
		custodiesJack.add(custodyJackRita);
		custodiesJack.add(custodyJackCurro);

		jack.setCustodies(custodiesJack);

		Custody custodyYenyRita = Custody.builder().fecha(new Date()).person(yeny).dog(rita).build();
		Custody custodyYenyKira = Custody.builder().fecha(new Date()).person(yeny).dog(kira).build();
		List<Custody> custodiesYeny = new ArrayList<>();
		custodiesYeny.add(custodyYenyRita);
		custodiesYeny.add(custodyYenyKira);

		yeny.setCustodies(custodiesYeny);

		Custody custodyYakeCurro = Custody.builder().fecha(new Date()).person(yake).dog(curro).build();
		Custody custodyYakeKira = Custody.builder().fecha(new Date()).person(yake).dog(kira).build();
		List<Custody> custodiesYake = new ArrayList<>();
		custodiesYake.add(custodyYakeCurro);
		custodiesYake.add(custodyYakeKira);

		yake.setCustodies(custodiesYake);

		custodyRepository.save(custodyJackRita);
		custodyRepository.save(custodyJackCurro);

		custodyRepository.save(custodyYenyRita);
		custodyRepository.save(custodyYenyKira);

		custodyRepository.save(custodyYakeCurro);
		custodyRepository.save(custodyYakeKira);


		System.out.println(personRepository.findAll());
	}

}
