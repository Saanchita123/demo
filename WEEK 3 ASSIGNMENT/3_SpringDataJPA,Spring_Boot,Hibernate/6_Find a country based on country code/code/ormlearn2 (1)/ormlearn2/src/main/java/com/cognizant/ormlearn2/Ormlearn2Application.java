package com.cognizant.ormlearn2;




import com.cognizant.ormlearn2.model.Country;
import com.cognizant.ormlearn2.service.CountryService;
import com.cognizant.ormlearn2.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ormlearn2Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ormlearn2Application.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ormlearn2Application.class, args);
		CountryService countryService = context.getBean(CountryService.class);
		getCountryByCodeTest(countryService);
	}

	private static void getCountryByCodeTest(CountryService countryService) {
		LOGGER.info("Start");

		try {
			Country country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country: {}", country);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Exception: {}", e.getMessage());
		}

		LOGGER.info("End");
	}
}
