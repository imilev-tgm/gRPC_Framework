package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.proto.PersonOuterClass;



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// Beispiel, wie Sie die Person-Klasse verwenden könnten
		PersonOuterClass.Person person = PersonOuterClass.Person.newBuilder()
				.setName("John Doe")
				.setAge(1234)
				.build();

		System.out.println(person);
		// Verwenden Sie die 'person'-Variable gemäß Ihren Anforderungen
	}

}
