package com.cognizant.ormlearn2.service;

import com.cognizant.ormlearn2.model.Country;
import com.cognizant.ormlearn2.repository.CountryRepository;
import com.cognizant.ormlearn2.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + countryCode);
        }
        return result.get();
    }
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }
}
