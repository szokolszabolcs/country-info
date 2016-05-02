package hu.bme.aut.szabolcs.szokol.countryinfo.repository;

import java.util.List;

import hu.bme.aut.szabolcs.szokol.countryinfo.model.Country;

public interface Repository {

    List<Country> getAllFavourites();

    void addNewFavourite(Country country);

    void deleteFavourite(Country country);

}
