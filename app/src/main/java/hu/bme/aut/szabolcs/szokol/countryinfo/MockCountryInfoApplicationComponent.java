package hu.bme.aut.szabolcs.szokol.countryinfo;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.szabolcs.szokol.countryinfo.interactor.InteractorModule;
import hu.bme.aut.szabolcs.szokol.countryinfo.network.NetworkModule;
import hu.bme.aut.szabolcs.szokol.countryinfo.repository.mock.MockRepositoryModule;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.UiModule;

@Singleton
@Component(modules = {UiModule.class, NetworkModule.class, MockRepositoryModule.class, InteractorModule.class})
public interface MockCountryInfoApplicationComponent extends CountryInfoApplicationComponent {

}
