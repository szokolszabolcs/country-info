package hu.bme.aut.szabolcs.szokol.countryinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccessToken {

    /**
     * (Required)
     */
    @SerializedName("access_token")
    @Expose
    private String accessToken;

    /**
     * (Required)
     *
     * @return The accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * (Required)
     *
     * @param accessToken The access_token
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
