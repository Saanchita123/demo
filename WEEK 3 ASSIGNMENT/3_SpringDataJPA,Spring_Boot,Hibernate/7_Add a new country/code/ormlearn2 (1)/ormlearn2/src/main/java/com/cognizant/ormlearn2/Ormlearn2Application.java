package com.cognizant.ormlearn2;




import com.cognizant.ormlearn2.model.Country;
import com.cognizant.ormlearn2.service.CountryService;
import com.cognizant.ormlearn2.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Ormlearn2Application implements CommandLineRunner {

	@Autowired
	private CountryService countryService;

	public static void main(String[] args) {
		SpringApplication.run(Ormlearn2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		testAddCountry();
	}

	private void testAddCountry() {
		Country country = new Country();
		country.setCode("JP");
		country.setName("Japan");

		// Add country
		countryService.addCountry(country);
		System.out.println("Country added successfully!");

		try {
			// Retrieve and check if added
			Country savedCountry = countryService.findCountryByCode("JP");
			System.out.println("Retrieved Country: " + savedCountry);
		} catch (CountryNotFoundException e) {
			System.out.println("Country not found after adding!");
		}
	}
}

