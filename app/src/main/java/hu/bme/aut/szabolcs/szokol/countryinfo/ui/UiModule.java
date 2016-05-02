package hu.bme.aut.szabolcs.szokol.countryinfo.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.szabolcs.szokol.countryinfo.di.Database;
import hu.bme.aut.szabolcs.szokol.countryinfo.di.Network;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.allcountries.AllCountriesPresenter;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.login.LoginPresenter;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.main.MainPresenter;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.search.SearchPresenter;

@Module
public class UiModule {

    Context context;

    public UiModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    @Singleton
    public MainPresenter providesMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public AllCountriesPresenter providesAllCountriesPresenter() {
        return new AllCountriesPresenter();
    }

    @Provides
    @Singleton
    public SearchPresenter providesSearchPresenter() {
        return new SearchPresenter();
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return Executors.newFixedThreadPool(1);
    }

    @Provides
    @Singleton
    @Database
    public Executor provideDatabasExecutor() {
        return Executors.newFixedThreadPool(1);
    }

}
