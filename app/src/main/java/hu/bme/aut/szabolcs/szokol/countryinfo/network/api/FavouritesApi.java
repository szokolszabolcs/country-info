package hu.bme.aut.szabolcs.szokol.countryinfo.network.api;

import java.util.List;

import hu.bme.aut.szabolcs.szokol.countryinfo.model.Country;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface FavouritesApi {

    /**
     * Get all favourites
     * All favourite countries will be provided for the current user.
     *
     * @param accessToken The acces token what is provided after a successful login
     * @return Call<List<Country>>
     */

    @GET("favourites")
    Call<List<Country>> favouritesGet(
            @Header("access_token") String accessToken
    );


    /**
     * Add a new favourite
     * The country with the provided id will be added to favourites
     *
     * @param accessToken The acces token what is provided after a successful login
     * @param id          Country ID what should be added to favourites
     * @return Call<Void>
     */

    @POST("favourites")
    Call<Void> favouritesPost(
            @Header("access_token") String accessToken, @Query("id") String id
    );


    /**
     * Delete a favourite
     * The country with the provided ID will be deleted from the user&#39;s favourites
     *
     * @param accessToken The acces token what is provided after a successful login
     * @param id          Country ID what sould be deleted from favourites
     * @return Call<Void>
     */

    @DELETE("favourites")
    Call<Void> favouritesDelete(
            @Header("access_token") String accessToken, @Query("id") String id
    );


}
