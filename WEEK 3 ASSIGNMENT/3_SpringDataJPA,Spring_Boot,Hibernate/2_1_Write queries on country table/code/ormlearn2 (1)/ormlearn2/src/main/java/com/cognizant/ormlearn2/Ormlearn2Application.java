package com.cognizant.ormlearn2;




import com.cognizant.ormlearn2.model.Country;
import com.cognizant.ormlearn2.repository.CountryRepository;
import com.cognizant.ormlearn2.service.CountryService;
import com.cognizant.ormlearn2.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Ormlearn2Application implements CommandLineRunner {
		@Autowired
		private CountryRepository countryRepository;

		public static void main(String[] args) {
			SpringApplication.run(Ormlearn2Application.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			testFindByNameContaining();
			testFindByNameContainingOrderByNameAsc();
			testFindByNameStartingWith();
		}

		// 1. Countries whose name contains 'ou'
		public void testFindByNameContaining() {
			System.out.println("---- Countries containing 'ou' ----");
			List<Country> countries = countryRepository.findByNameContainingIgnoreCase("ou");
			countries.forEach(country -> System.out.println(country.getCode() + " - " + country.getName()));
		}

		// 2. Countries whose name contains 'ou', ordered by name
		public void testFindByNameContainingOrderByNameAsc() {
			System.out.println("---- Countries containing 'ou' ordered by name ----");
			List<Country> countries = countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc("ou");
			countries.forEach(country -> System.out.println(country.getCode() + " - " + country.getName()));
		}

		// 3. Countries whose name starts with 'Z'
		public void testFindByNameStartingWith() {
			System.out.println("---- Countries starting with 'Z' ----");
			List<Country> countries = countryRepository.findByNameStartingWithIgnoreCase("Z");
			countries.forEach(country -> System.out.println(country.getCode() + " - " + country.getName()));
		}
	}
