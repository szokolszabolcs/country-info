package hu.bme.aut.szabolcs.szokol.countryinfo.ui;

public class Presenter<S> {

    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
    }

    public void detachScreen() {
        this.screen = null;
    }

}
