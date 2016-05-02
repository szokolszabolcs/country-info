package hu.bme.aut.szabolcs.szokol.countryinfo.repository;

import android.content.Context;

import java.util.List;

import hu.bme.aut.szabolcs.szokol.countryinfo.model.Country;

public interface Repository {

    void initialize(Context context);

    void terminate();

    List<Country> getAllFavourites();

    void addNewFavourite(Country country);

    void deleteFavourite(Country country);

}
