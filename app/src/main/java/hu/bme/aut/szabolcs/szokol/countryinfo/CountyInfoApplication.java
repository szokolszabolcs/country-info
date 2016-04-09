package hu.bme.aut.szabolcs.szokol.countryinfo;

import android.app.Application;

import hu.bme.aut.szabolcs.szokol.countryinfo.ui.UiModule;

public class CountyInfoApplication extends Application {

    public static CountryInfoApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerCountryInfoApplicationComponent.builder().uiModule(new UiModule(this)).build();
    }
}
