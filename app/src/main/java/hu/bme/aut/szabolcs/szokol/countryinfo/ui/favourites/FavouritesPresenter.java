package hu.bme.aut.szabolcs.szokol.countryinfo.ui.favourites;

import javax.inject.Inject;

import hu.bme.aut.szabolcs.szokol.countryinfo.CountyInfoApplication;
import hu.bme.aut.szabolcs.szokol.countryinfo.interactor.favourites.FavouritesInteractor;
import hu.bme.aut.szabolcs.szokol.countryinfo.model.Country;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.Presenter;

public class FavouritesPresenter extends Presenter<FavouritesScreen> {

    @Inject
    FavouritesInteractor interactor;

    @Override
    public void attachScreen(FavouritesScreen screen) {
        super.attachScreen(screen);
        CountyInfoApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void addToDB(Country country) {
        interactor.addFavourite(country);
        screen.refresh();
    }

    public void getFavourites() {
        screen.showFavourites(interactor.getAllFavourites());
    }

}
