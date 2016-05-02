package hu.bme.aut.szabolcs.szokol.countryinfo.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.szabolcs.szokol.countryinfo.interactor.auth.AuthInteractor;
import hu.bme.aut.szabolcs.szokol.countryinfo.interactor.countries.CountriesInteractor;
import hu.bme.aut.szabolcs.szokol.countryinfo.interactor.favourites.FavouritesInteractor;

@Module
public class InteractorModule {

    @Provides
    public AuthInteractor provideAuthInteractor() {
        return new AuthInteractor();
    }

    @Provides
    public CountriesInteractor provideCountriesInteractor() {
        return new CountriesInteractor();
    }

    @Provides
    public FavouritesInteractor provideFavouritesInteractor() {
        return new FavouritesInteractor();
    }

}
