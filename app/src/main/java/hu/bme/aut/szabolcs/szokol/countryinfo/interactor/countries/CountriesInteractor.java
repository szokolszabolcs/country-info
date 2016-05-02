package hu.bme.aut.szabolcs.szokol.countryinfo.interactor.countries;

import hu.bme.aut.szabolcs.szokol.countryinfo.CountyInfoApplication;

public class CountriesInteractor {

    public CountriesInteractor() {
        CountyInfoApplication.injector.inject(this);
    }

    public void getAll() {

    }

    public void findByName(String nameSubstring) {

    }

}
