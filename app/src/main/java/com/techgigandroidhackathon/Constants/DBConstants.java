package com.techgigandroidhackathon.Constants;

/**
 * Created by Amol G on 01-12-2017.
 */

public interface DBConstants {
    /**
     * Table names
     */
    String COUNTRY_TABLE = "CountryTable";
    String CURRENCY_TABLE = "CurrencyTable";
    String LANGUAGE_TABLE = "LanguageTable";
    String REGIONAL_BLOCKS_TABLE = "RegionalBlockTable";
    String TRANSLATIONS_TABLE = "TranslationTable";

    /**
     * Country table parameters
     */
    String PARAM_COUNTRY_ID = "CountryId";
    String PARAM_COUNTRY_CIOC = "cioc";
    String PARAM_COUNTRY_REGION = "region";
    String PARAM_COUNTRY_NUMERIC_CODE = "numericCode";
    String PARAM_COUNTRY_CALLING_CODES = "callingCodes";
    String PARAM_COUNTRY_ALPHA3CODE = "alpha3Code";
    String PARAM_COUNTRY_NATIVE_NAME = "nativeName";
    String PARAM_COUNTRY_TOP_LEVEL_DOMAIN = "topLevelDomain";
    String PARAM_COUNTRY_ALPHA2CODE = "alpha2Code";
    String PARAM_COUNTRY_CAPITAL = "capital";
    String PARAM_COUNTRY_ALT_SPELLINGS = "altSpellings";
    String PARAM_COUNTRY_SUB_REGION = "subregion";
    String PARAM_COUNTRY_TIME_ZONES = "timezones";
    String PARAM_COUNTRY_FLAG = "flag";
    String PARAM_COUNTRY_AREA = "area";
    String PARAM_COUNTRY_NAME = "name";
    String PARAM_COUNTRY_LAT_LNG = "latlng";
    String PARAM_COUNTRY_DEMONYM = "demonym";
    String PARAM_COUNTRY_GINI = "gini";
    String PARAM_COUNTRY_BORDERS = "borders";
    String PARAM_COUNTRY_POPULATION = "population";

    /**
     * Currency table parameters
     */
    String PARAM_CURRENCY_SYMBOL = "symbol";
    String PARAM_CURRENCY_NAME = "name";
    String PARAM_CURRENCY_CODE = "code";

    /**
     * Language table parameters
     */
    String PARAM_ISO639_2 = "iso639_2";
    String PARAM_ISO639_1 = "iso639_1";
    String PARAM_LANGUAGE_NAME = "name";
    String PARAM_LANGUAGE_NATIVE_NAME = "nativeName";

    /**
     * Regional blocks table parameter
     */
    String PARAM_REGIONAL_BLOCK_OTHER_ACRONYM = "otherAcronym";
    String PARAM_REGIONAL_BLOCK_ACRONYM = "acronym";
    String PARAM_REGIONAL_BLOCK_NAME = "name";
    String PARAM_REGIONAL_BLOCK_OTHER_NAMES = "otherNames";

    /**
     * TranslationsVO table parameter
     */
    String PARAM_TRANSLATIONS_HR = "hr";
    String PARAM_TRANSLATIONS_DE = "de";
    String PARAM_TRANSLATIONS_IT = "it";
    String PARAM_TRANSLATIONS_PT = "pt";
    String PARAM_TRANSLATIONS_FA = "fa";
    String PARAM_TRANSLATIONS_FR = "fr";
    String PARAM_TRANSLATIONS_BR = "br";
    String PARAM_TRANSLATIONS_ES = "es";
    String PARAM_TRANSLATIONS_NL = "nl";
    String PARAM_TRANSLATIONS_JA = "ja";

    /**
     * Create table queries
     */
    String CREATE_TABLE_COUNTRY = "create table " + COUNTRY_TABLE + "("
            + "CountryId INTEGER PRIMARY KEY AUTOINCREMENT,"
            + PARAM_COUNTRY_CIOC + " text,"
            + PARAM_COUNTRY_REGION + " text,"
            + PARAM_COUNTRY_NUMERIC_CODE + " text,"
            + PARAM_COUNTRY_CALLING_CODES + " text,"
            + PARAM_COUNTRY_ALPHA3CODE + " text,"
            + PARAM_COUNTRY_NATIVE_NAME + " text,"
            + PARAM_COUNTRY_TOP_LEVEL_DOMAIN + " text,"
            + PARAM_COUNTRY_ALPHA2CODE + " text,"
            + PARAM_COUNTRY_CAPITAL + " text,"
            + PARAM_COUNTRY_ALT_SPELLINGS + " text,"
            + PARAM_COUNTRY_SUB_REGION + " text,"
            + PARAM_COUNTRY_TIME_ZONES + " text,"
            + PARAM_COUNTRY_FLAG + " text,"
            + PARAM_COUNTRY_AREA + " text,"
            + PARAM_COUNTRY_NAME + " text,"
            + PARAM_COUNTRY_LAT_LNG + " text,"
            + PARAM_COUNTRY_DEMONYM + " text,"
            + PARAM_COUNTRY_GINI + " text,"
            + PARAM_COUNTRY_BORDERS + " text,"
            + PARAM_COUNTRY_POPULATION + " text)";

    String CREATE_TABLE_CURRENCY = "create table " + CURRENCY_TABLE + "("
            + PARAM_COUNTRY_ID + " integer,"
            + PARAM_CURRENCY_SYMBOL + " text,"
            + PARAM_CURRENCY_NAME + " text,"
            + PARAM_CURRENCY_CODE + " text)";

    String CREATE_TABLE_LANGUAGES = "create table " + LANGUAGE_TABLE + "("
            + PARAM_COUNTRY_ID + " integer,"
            + PARAM_ISO639_2 + " text,"
            + PARAM_ISO639_1 + " text,"
            + PARAM_LANGUAGE_NAME + " text,"
            + PARAM_LANGUAGE_NATIVE_NAME + " text)";

    String CREATE_TABLE_REGIONAL_BLOCKS = "create table " + REGIONAL_BLOCKS_TABLE + "("
            + PARAM_COUNTRY_ID + " integer,"
            + PARAM_REGIONAL_BLOCK_OTHER_ACRONYM + " text,"
            + PARAM_REGIONAL_BLOCK_ACRONYM + " text,"
            + PARAM_REGIONAL_BLOCK_NAME + " text,"
            + PARAM_REGIONAL_BLOCK_OTHER_NAMES + " text)";

    String CREATE_TABLE_TRANSLATIONS = "create table " + TRANSLATIONS_TABLE + "("
            + PARAM_COUNTRY_ID + " integer,"
            + PARAM_TRANSLATIONS_HR + " text,"
            + PARAM_TRANSLATIONS_DE + " text,"
            + PARAM_TRANSLATIONS_IT + " text,"
            + PARAM_TRANSLATIONS_PT + " text,"
            + PARAM_TRANSLATIONS_FA + " text,"
            + PARAM_TRANSLATIONS_FR + " text,"
            + PARAM_TRANSLATIONS_BR + " text,"
            + PARAM_TRANSLATIONS_ES + " text,"
            + PARAM_TRANSLATIONS_NL + " text,"
            + PARAM_TRANSLATIONS_JA + " text)";
}
