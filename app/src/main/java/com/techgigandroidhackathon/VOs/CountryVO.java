package com.techgigandroidhackathon.VOs;

/**
 * Created by Amol G on 23-11-2017.
 */

public class CountryVO {
    private int CountryId;
    private String cioc;
    private String region;
    private CurrenciesVO[] currencies;
    private String numericCode;
    private String[] callingCodes;
    private String alpha3Code;
    private String nativeName;
    private String[] topLevelDomain;
    private String alpha2Code;
    private String capital;
    private String[] altSpellings;
    private LanguagesVO[] languages;
    private String subregion;
    private String[] timezones;
    private String flag;
    private String area;
    private String name;
    private RegionalBlocsVO[] regionalBlocs;
    private TranslationsVO translations;
    private String[] latlng;
    private String demonym;
    private String gini;
    private String[] borders;
    private String population;

    public String getCioc() {
        return cioc;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public CurrenciesVO[] getCurrencies() {
        return currencies;
    }

    public void setCurrencies(CurrenciesVO[] currencies) {
        this.currencies = currencies;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public String[] getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(String[] callingCodes) {
        this.callingCodes = callingCodes;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String[] getTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(String[] topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String[] getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(String[] altSpellings) {
        this.altSpellings = altSpellings;
    }

    public LanguagesVO[] getLanguages() {
        return languages;
    }

    public void setLanguages(LanguagesVO[] languages) {
        this.languages = languages;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String[] getTimezones() {
        return timezones;
    }

    public void setTimezones(String[] timezones) {
        this.timezones = timezones;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegionalBlocsVO[] getRegionalBlocs() {
        return regionalBlocs;
    }

    public void setRegionalBlocs(RegionalBlocsVO[] regionalBlocs) {
        this.regionalBlocs = regionalBlocs;
    }

    public TranslationsVO getTranslations() {
        return translations;
    }

    public void setTranslations(TranslationsVO translations) {
        this.translations = translations;
    }

    public String[] getLatlng() {
        return latlng;
    }

    public void setLatlng(String[] latlng) {
        this.latlng = latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public String getGini() {
        return gini;
    }

    public void setGini(String gini) {
        this.gini = gini;
    }

    public String[] getBorders() {
        return borders;
    }

    public void setBorders(String[] borders) {
        this.borders = borders;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }


    @Override
    public String toString() {
        return "ClassPojo [cioc = " + cioc + ", region = " + region + ", currencies = " + currencies + ", numericCode = " + numericCode + ", callingCodes = " + callingCodes + ", alpha3Code = " + alpha3Code + ", nativeName = " + nativeName + ", topLevelDomain = " + topLevelDomain + ", alpha2Code = " + alpha2Code + ", capital = " + capital + ", altSpellings = " + altSpellings + ", languages = " + languages + ", subregion = " + subregion + ", timezones = " + timezones + ", flag = " + flag + ", area = " + area + ", name = " + name + ", regionalBlocs = " + regionalBlocs + ", translations = " + translations + ", latlng = " + latlng + ", demonym = " + demonym + ", gini = " + gini + ", borders = " + borders + ", population = " + population + "]";
    }
}