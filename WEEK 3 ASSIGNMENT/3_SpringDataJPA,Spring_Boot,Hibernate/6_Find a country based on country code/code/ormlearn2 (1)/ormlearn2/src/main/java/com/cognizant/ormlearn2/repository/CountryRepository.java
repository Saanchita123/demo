package com.cognizant.ormlearn2.repository;


import com.cognizant.ormlearn2.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}
