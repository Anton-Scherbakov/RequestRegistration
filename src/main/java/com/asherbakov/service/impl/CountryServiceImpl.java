package com.asherbakov.service.impl;

import com.asherbakov.entity.Country;
import com.asherbakov.repository.CountryRepository;
import com.asherbakov.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country saveCountry(List<String> recipient) {
        return countryRepository.save(new Country(recipient.get(1)));
    }
}
