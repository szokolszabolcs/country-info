package hu.bme.aut.szabolcs.szokol.countryinfo.network.api;

import hu.bme.aut.szabolcs.szokol.countryinfo.model.AccessToken;
import hu.bme.aut.szabolcs.szokol.countryinfo.model.Credential;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface AuthApi {

    /**
     * Login
     * Provides Login function to the application.
     *
     * @param body Login credentials of the user
     * @return Call<AccessToken>
     */

    @POST("login")
    Call<AccessToken> loginPost(
            @Body Credential body
    );


    /**
     * Logout
     * Provide log out facility, the acces token is invalidated.
     *
     * @param accessToken The acces token what is provided after a successful login
     * @return Call<Void>
     */

    @POST("logout")
    Call<Void> logoutPost(
            @Header("access_token") String accessToken
    );


    /**
     * Registartion
     * Provides registration facility to the application.
     *
     * @param body Login credentials of the user
     * @return Call<Credential>
     */

    @POST("register")
    Call<Credential> registerPost(
            @Body Credential body
    );


}
