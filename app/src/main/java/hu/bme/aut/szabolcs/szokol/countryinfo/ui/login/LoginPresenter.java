package hu.bme.aut.szabolcs.szokol.countryinfo.ui.login;

import hu.bme.aut.szabolcs.szokol.countryinfo.ui.Presenter;

public class LoginPresenter extends Presenter<LoginScreen> {

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void login(String username, String password) {
        screen.navigateToMain(); //TODO
    }

}
