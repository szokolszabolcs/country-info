package hu.bme.aut.szabolcs.szokol.countryinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.dsl.Table;

import java.util.ArrayList;
import java.util.List;

@Table
public class Country {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("capital")
    @Expose
    private String capital;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("population")
    @Expose
    private Long population;
    @SerializedName("area")
    @Expose
    private Integer area;
    @SerializedName("currencies")
    @Expose
    private List<String> currencies = new ArrayList<String>();
    @SerializedName("callingCodes")
    @Expose
    private List<String> callingCodes = new ArrayList<String>();
    @SerializedName("topLevelDomain")
    @Expose
    private List<String> topLevelDomain = new ArrayList<String>();
    @SerializedName("smallImageUrl")
    @Expose
    private String smallImageUrl;
    @SerializedName("normalImageUrl")
    @Expose
    private String normalImageUrl;

    public Country() {
    }

    public Country(Long id,
                   String name,
                   String capital,
                   String region,
                   Long population,
                   Integer area,
                   List<String> currencies,
                   List<String> callingCodes,
                   List<String> topLevelDomain,
                   String smallImageUrl,
                   String normalImageUrl) {

        this.id = id;
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.population = population;
        this.area = area;
        this.currencies = currencies;
        this.callingCodes = callingCodes;
        this.topLevelDomain = topLevelDomain;
        this.smallImageUrl = smallImageUrl;
        this.normalImageUrl = normalImageUrl;

    }

    /**
     * @return The id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * @param capital The capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * @return The region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region The region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return The population
     */
    public Long getPopulation() {
        return population;
    }

    /**
     * @param population The population
     */
    public void setPopulation(Long population) {
        this.population = population;
    }

    /**
     * @return The area
     */
    public Integer getArea() {
        return area;
    }

    /**
     * @param area The area
     */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
     * @return The currencies
     */
    public List<String> getCurrencies() {
        return currencies;
    }

    /**
     * @param currencies The currencies
     */
    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }

    /**
     * @return The callingCodes
     */
    public List<String> getCallingCodes() {
        return callingCodes;
    }

    /**
     * @param callingCodes The callingCodes
     */
    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    /**
     * @return The topLevelDomain
     */
    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    /**
     * @param topLevelDomain The topLevelDomain
     */
    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    /**
     * @return The smallImageUrl
     */
    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    /**
     * @param smallImageUrl The smallImageUrl
     */
    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    /**
     * @return The normalImageUrl
     */
    public String getNormalImageUrl() {
        return normalImageUrl;
    }

    /**
     * @param normalImageUrl The normalImageUrl
     */
    public void setNormalImageUrl(String normalImageUrl) {
        this.normalImageUrl = normalImageUrl;
    }

}
