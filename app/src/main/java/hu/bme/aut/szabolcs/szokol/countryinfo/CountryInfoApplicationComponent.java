package hu.bme.aut.szabolcs.szokol.countryinfo;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.szabolcs.szokol.countryinfo.interactor.InteractorModule;
import hu.bme.aut.szabolcs.szokol.countryinfo.interactor.auth.AuthInteractor;
import hu.bme.aut.szabolcs.szokol.countryinfo.interactor.countries.CountriesInteractor;
import hu.bme.aut.szabolcs.szokol.countryinfo.interactor.favourites.FavouritesInteractor;
import hu.bme.aut.szabolcs.szokol.countryinfo.network.NetworkModule;
import hu.bme.aut.szabolcs.szokol.countryinfo.repository.prod.RepositoryModule;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.UiModule;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.login.LoginActivity;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.main.MainActivity;

@Singleton
@Component(modules = {UiModule.class, NetworkModule.class, RepositoryModule.class, InteractorModule.class})
public interface CountryInfoApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

    void inject(AuthInteractor authInteractor);

    void inject(CountriesInteractor countriesInteractor);

    void inject(FavouritesInteractor favouritesInteractor);

}
