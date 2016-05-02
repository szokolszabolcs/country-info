package hu.bme.aut.szabolcs.szokol.countryinfo.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.szabolcs.szokol.countryinfo.di.Database;
import hu.bme.aut.szabolcs.szokol.countryinfo.di.Network;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.login.LoginPresenter;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.main.MainPresenter;

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
