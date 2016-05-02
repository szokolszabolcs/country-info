package hu.bme.aut.szabolcs.szokol.countryinfo.repository.prod;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

import hu.bme.aut.szabolcs.szokol.countryinfo.model.Country;
import hu.bme.aut.szabolcs.szokol.countryinfo.repository.Repository;

public class ProdRepository implements Repository {

    @Override
    public void initialize(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void terminate() {
        SugarContext.terminate();
    }

    @Override
    public List<Country> getAllFavourites() {
        return SugarRecord.listAll(Country.class);
    }

    @Override
    public void addNewFavourite(Country country) {
        SugarRecord.save(country);
    }

    @Override
    public void deleteFavourite(Country country) {
        SugarRecord.delete(country);
    }

}
