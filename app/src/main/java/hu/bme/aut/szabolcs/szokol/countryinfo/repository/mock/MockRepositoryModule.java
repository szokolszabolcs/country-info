package hu.bme.aut.szabolcs.szokol.countryinfo.repository.mock;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.szabolcs.szokol.countryinfo.repository.Repository;

@Module
public class MockRepositoryModule {

    @Provides
    @Singleton
    public Repository providesMockRepository(Context context) {
        MockRepository mockRepository = new MockRepository();
        mockRepository.initialize(context);
        return mockRepository;
    }

}
