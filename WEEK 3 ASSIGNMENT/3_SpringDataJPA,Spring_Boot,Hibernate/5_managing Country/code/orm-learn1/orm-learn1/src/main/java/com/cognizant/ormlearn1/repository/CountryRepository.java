package com.cognizant.ormlearn1.repository;


import com.cognizant.ormlearn1.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findByCoNameContainingIgnoreCase(String coName);
}
