package hu.bme.aut.szabolcs.szokol.countryinfo.ui.favourites;

import java.util.List;

import hu.bme.aut.szabolcs.szokol.countryinfo.model.Country;

public interface FavouritesScreen {

    void refresh();

    void showFavourites(List<Country> favourites);

}
