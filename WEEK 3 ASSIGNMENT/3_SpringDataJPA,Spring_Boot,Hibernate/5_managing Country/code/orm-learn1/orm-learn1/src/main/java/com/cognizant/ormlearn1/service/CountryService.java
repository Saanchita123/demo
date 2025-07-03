package com.cognizant.ormlearn1.service;



import com.cognizant.ormlearn1.model.Country;
import com.cognizant.ormlearn1.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country getCountryByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(String code, Country updatedCountry) {
        Country existing = getCountryByCode(code);
        if (existing != null) {
            existing.setCoName(updatedCountry.getCoName());
            return countryRepository.save(existing);
        }
        return null;
    }

    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }


    public List<Country> searchCountries(String partialName) {
        return countryRepository.findByCoNameContainingIgnoreCase(partialName);
    }
}
