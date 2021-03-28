package uk.test.crime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("uk.test.crime")
public class CrimeServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrimeServiceApplication.class, args);
	}
}
