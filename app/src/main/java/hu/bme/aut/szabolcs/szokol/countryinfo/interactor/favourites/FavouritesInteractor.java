package hu.bme.aut.szabolcs.szokol.countryinfo.interactor.favourites;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.szabolcs.szokol.countryinfo.CountyInfoApplication;
import hu.bme.aut.szabolcs.szokol.countryinfo.model.Country;
import hu.bme.aut.szabolcs.szokol.countryinfo.network.api.CountriesApi;
import hu.bme.aut.szabolcs.szokol.countryinfo.repository.Repository;
import retrofit2.Call;

public class FavouritesInteractor {

    @Inject
    Repository repository;

    @Inject
    CountriesApi countriesApi;

    public FavouritesInteractor() {
        CountyInfoApplication.injector.inject(this);
    }

    public void addFavourite(Country country) {
        repository.addNewFavourite(country);
    }

    public void deleteFavourite(Country country) {
        repository.deleteFavourite(country);
    }

    public List<Country> getAllFavourites() {
        List<Country> favourites = null;

        try {
            Log.d("FAVOURITES GET", "Try from api");

            Call<List<Country>> countryCall = countriesApi.allGet(null);
            return countryCall.execute().body();
        } catch (Exception e) {
            Log.d("FAVOURITES GET", "Get from repo");

            return repository.getAllFavourites();
        }

    }

}
