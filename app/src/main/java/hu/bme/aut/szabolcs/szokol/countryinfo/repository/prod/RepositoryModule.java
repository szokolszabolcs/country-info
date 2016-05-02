package hu.bme.aut.szabolcs.szokol.countryinfo.repository.prod;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.szabolcs.szokol.countryinfo.repository.Repository;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public Repository providesProdRepository(Context context) {
        ProdRepository prodRepository = new ProdRepository();
        prodRepository.initialize(context);
        return prodRepository;
    }

}
