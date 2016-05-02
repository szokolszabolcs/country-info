package hu.bme.aut.szabolcs.szokol.countryinfo;

import android.app.Application;

import javax.inject.Inject;

import hu.bme.aut.szabolcs.szokol.countryinfo.repository.Repository;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.UiModule;

public class CountyInfoApplication extends Application {

    @Inject
    Repository repository;

    public static CountryInfoApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.MOCK) {
            injector = DaggerMockCountryInfoApplicationComponent.builder().uiModule(new UiModule(this)).build();
        } else {
            injector = DaggerCountryInfoApplicationComponent.builder().uiModule(new UiModule(this)).build();
        }

        injector.inject(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        repository.terminate();
    }

}
