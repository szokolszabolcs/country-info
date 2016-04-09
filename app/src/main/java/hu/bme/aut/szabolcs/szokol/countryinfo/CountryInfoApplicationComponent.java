package hu.bme.aut.szabolcs.szokol.countryinfo;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.szabolcs.szokol.countryinfo.interactor.InteractorModule;
import hu.bme.aut.szabolcs.szokol.countryinfo.network.NetworkModule;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.UiModule;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.login.LoginActivity;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.main.MainActivity;

@Singleton
@Component(modules = {UiModule.class, NetworkModule.class, InteractorModule.class})
public interface CountryInfoApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

}
