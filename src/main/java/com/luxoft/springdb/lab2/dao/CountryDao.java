package com.luxoft.springdb.lab2.dao;

import com.luxoft.springdb.lab2.model.Country;

import java.util.List;

public interface CountryDao {
	void save(Country country);
	List<Country> getAllCountries();
	Country getCountryByName(String name);
}