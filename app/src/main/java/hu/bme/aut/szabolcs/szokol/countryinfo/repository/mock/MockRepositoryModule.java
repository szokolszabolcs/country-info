package hu.bme.aut.szabolcs.szokol.countryinfo.repository.mock;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.szabolcs.szokol.countryinfo.repository.Repository;

@Module
public class MockRepositoryModule {

    @Provides
    @Singleton
    public Repository providesMockRepository() {
        return new MockRepository();
    }

}
