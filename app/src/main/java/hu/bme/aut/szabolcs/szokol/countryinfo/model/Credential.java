package hu.bme.aut.szabolcs.szokol.countryinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Credential {

    /**
     * (Required)
     */
    @SerializedName("name")
    @Expose
    private String name;
    /**
     * (Required)
     */
    @SerializedName("password")
    @Expose
    private String password;

    /**
     * (Required)
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * (Required)
     *
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * (Required)
     *
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * (Required)
     *
     * @param password The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
