package hu.bme.aut.szabolcs.szokol.countryinfo.interactor.auth;

import hu.bme.aut.szabolcs.szokol.countryinfo.CountyInfoApplication;
import hu.bme.aut.szabolcs.szokol.countryinfo.model.Credential;

public class AuthInteractor {

    public AuthInteractor() {
        CountyInfoApplication.injector.inject(this);
    }

    public void register(Credential credential) {

    }

    public void logIn(Credential credential) {

    }

    public void logOut() {

    }

}
