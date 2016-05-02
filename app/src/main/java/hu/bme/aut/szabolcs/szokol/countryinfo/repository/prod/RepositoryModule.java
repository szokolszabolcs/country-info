package hu.bme.aut.szabolcs.szokol.countryinfo.repository.prod;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.szabolcs.szokol.countryinfo.repository.Repository;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public Repository providesProdRepository() {
        return new ProdRepository();
    }

}
