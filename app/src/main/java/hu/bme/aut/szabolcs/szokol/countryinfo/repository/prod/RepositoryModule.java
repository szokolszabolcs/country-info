package hu.bme.aut.szabolcs.szokol.countryinfo.repository.prod;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public ProdRepository providesProdRepository() {
        return new ProdRepository();
    }

}
