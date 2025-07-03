package com.cognizant.ormlearn2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.cognizant.ormlearn2.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findByNameContainingIgnoreCase(String namePart);
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String namePart);
    List<Country> findByNameStartingWithIgnoreCase(String prefix);
}
