package hu.bme.aut.szabolcs.szokol.countryinfo.repository.mock;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MockRepositoryModule {

    @Provides
    @Singleton
    public MockRepository providesMockRepository() {
        return new MockRepository();
    }

}
