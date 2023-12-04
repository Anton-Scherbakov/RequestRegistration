package com.asherbakov.service;

import com.asherbakov.entity.Country;

import java.util.List;

public interface CountryService {
    Country saveCountry(List<String> recipient);
}
