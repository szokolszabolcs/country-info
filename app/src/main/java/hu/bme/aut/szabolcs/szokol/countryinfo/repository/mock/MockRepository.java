package hu.bme.aut.szabolcs.szokol.countryinfo.repository.mock;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.szabolcs.szokol.countryinfo.model.Country;
import hu.bme.aut.szabolcs.szokol.countryinfo.repository.Repository;

public class MockRepository implements Repository {

    List<Country> favourites;

    @Override
    public void initialize(Context context) {
        favourites = new ArrayList<>();

        favourites.add(new Country(1L, "Andorra", "Andorra la Vella", "Europe", 76949L, 468, getList("EUR"), getList("376"), getList(".ad"), "http://flagpedia.net/data/flags/mini/ad.png", "http://flags.fmcdn.net/data/flags/normal/ad.png"));
        favourites.add(new Country(2L, "Belgium", "Brussels", "Europe", 11248330L, 30528, getList("EUR"), getList("32"), getList(".be"), "http://flagpedia.net/data/flags/mini/be.png", "http://flags.fmcdn.net/data/flags/normal/be.png"));
        favourites.add(new Country(3L, "Finland", "Helsinki", "Europe", 5485215L, 338424, getList("EUR"), getList("358"), getList(".fi"), "http://flagpedia.net/data/flags/mini/fi.png", "http://flagpedia.net/data/flags/normal/fi.png"));
        favourites.add(new Country(4L, "Hungary", "Budapest", "Europe", 9849000L, 93028, getList("HUF"), getList("36"), getList(".hu"), "http://flagpedia.net/data/flags/mini/hu.png", "http://flagpedia.net/data/flags/normal/hu.png"));
        favourites.add(new Country(5L, "Russia", "Moscow", "Europe", 146556330L, 17124442, getList("RUB"), getList("7"), getList(".ru"), "http://flagpedia.net/data/flags/mini/ru.png", "http://flagpedia.net/data/flags/normal/ru.png"));
        favourites.add(new Country(6L, "Andorra", "Andorra la Vella", "Europe", 76949L, 468, getList("EUR"), getList("376"), getList(".ad"), "http://flagpedia.net/data/flags/mini/ad.png", "http://flags.fmcdn.net/data/flags/normal/ad.png"));
        favourites.add(new Country(7L, "Belgium", "Brussels", "Europe", 11248330L, 30528, getList("EUR"), getList("32"), getList(".be"), "http://flagpedia.net/data/flags/mini/be.png", "http://flags.fmcdn.net/data/flags/normal/be.png"));
        favourites.add(new Country(8L, "Finland", "Helsinki", "Europe", 5485215L, 338424, getList("EUR"), getList("358"), getList(".fi"), "http://flagpedia.net/data/flags/mini/fi.png", "http://flagpedia.net/data/flags/normal/fi.png"));
        favourites.add(new Country(9L, "Hungary", "Budapest", "Europe", 9849000L, 93028, getList("HUF"), getList("36"), getList(".hu"), "http://flagpedia.net/data/flags/mini/hu.png", "http://flagpedia.net/data/flags/normal/hu.png"));
        favourites.add(new Country(10L, "Russia", "Moscow", "Europe", 146556330L, 17124442, getList("RUB"), getList("7"), getList(".ru"), "http://flagpedia.net/data/flags/mini/ru.png", "http://flagpedia.net/data/flags/normal/ru.png"));
        favourites.add(new Country(11L, "Andorra", "Andorra la Vella", "Europe", 76949L, 468, getList("EUR"), getList("376"), getList(".ad"), "http://flagpedia.net/data/flags/mini/ad.png", "http://flags.fmcdn.net/data/flags/normal/ad.png"));
        favourites.add(new Country(12L, "Belgium", "Brussels", "Europe", 11248330L, 30528, getList("EUR"), getList("32"), getList(".be"), "http://flagpedia.net/data/flags/mini/be.png", "http://flags.fmcdn.net/data/flags/normal/be.png"));
        favourites.add(new Country(13L, "Finland", "Helsinki", "Europe", 5485215L, 338424, getList("EUR"), getList("358"), getList(".fi"), "http://flagpedia.net/data/flags/mini/fi.png", "http://flagpedia.net/data/flags/normal/fi.png"));
        favourites.add(new Country(14L, "Hungary", "Budapest", "Europe", 9849000L, 93028, getList("HUF"), getList("36"), getList(".hu"), "http://flagpedia.net/data/flags/mini/hu.png", "http://flagpedia.net/data/flags/normal/hu.png"));
        favourites.add(new Country(15L, "Russia", "Moscow", "Europe", 146556330L, 17124442, getList("RUB"), getList("7"), getList(".ru"), "http://flagpedia.net/data/flags/mini/ru.png", "http://flagpedia.net/data/flags/normal/ru.png"));
        favourites.add(new Country(16L, "Andorra", "Andorra la Vella", "Europe", 76949L, 468, getList("EUR"), getList("376"), getList(".ad"), "http://flagpedia.net/data/flags/mini/ad.png", "http://flags.fmcdn.net/data/flags/normal/ad.png"));
        favourites.add(new Country(17L, "Belgium", "Brussels", "Europe", 11248330L, 30528, getList("EUR"), getList("32"), getList(".be"), "http://flagpedia.net/data/flags/mini/be.png", "http://flags.fmcdn.net/data/flags/normal/be.png"));
        favourites.add(new Country(18L, "Finland", "Helsinki", "Europe", 5485215L, 338424, getList("EUR"), getList("358"), getList(".fi"), "http://flagpedia.net/data/flags/mini/fi.png", "http://flagpedia.net/data/flags/normal/fi.png"));
        favourites.add(new Country(19L, "Hungary", "Budapest", "Europe", 9849000L, 93028, getList("HUF"), getList("36"), getList(".hu"), "http://flagpedia.net/data/flags/mini/hu.png", "http://flagpedia.net/data/flags/normal/hu.png"));
        favourites.add(new Country(20L, "Russia", "Moscow", "Europe", 146556330L, 17124442, getList("RUB"), getList("7"), getList(".ru"), "http://flagpedia.net/data/flags/mini/ru.png", "http://flagpedia.net/data/flags/normal/ru.png"));
    }

    @Override
    public void terminate() {
        //do nothing
    }

    @Override
    public List<Country> getAllFavourites() {
        return favourites;
    }

    @Override
    public void addNewFavourite(Country country) {
        favourites.add(country);
    }

    @Override
    public void deleteFavourite(Country country) {
        favourites.remove(country);
    }

    public static List<String> getList(String item) {
        List<String> itemList = new ArrayList<>();
        itemList.add(item);

        return itemList;
    }

}
