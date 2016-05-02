package hu.bme.aut.szabolcs.szokol.countryinfo.interactor.favourites;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.szabolcs.szokol.countryinfo.model.Country;
import hu.bme.aut.szabolcs.szokol.countryinfo.repository.Repository;

public class FavouritesInteractor {

    @Inject
    Repository repository;

    public void addFavourite(Country country) {
        repository.addNewFavourite(country);
    }

    public void deleteFavourite(Country country) {
        repository.deleteFavourite(country);
    }

    public List<Country> getAllFavourites() {
        return repository.getAllFavourites();
    }

}
