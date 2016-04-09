package hu.bme.aut.szabolcs.szokol.countryinfo.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.szabolcs.szokol.countryinfo.interactor.countries.CountriesInteractor;

@Module
public class InteractorModule {

    @Provides
    public CountriesInteractor provideCountriesInteractor() {
        return new CountriesInteractor();
    }

}
