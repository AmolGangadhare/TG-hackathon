package com.techgigandroidhackathon.DBHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.gson.Gson;
import com.techgigandroidhackathon.Constants.Constants;
import com.techgigandroidhackathon.Constants.DBConstants;
import com.techgigandroidhackathon.VOs.CountryVO;
import com.techgigandroidhackathon.VOs.CurrenciesVO;
import com.techgigandroidhackathon.VOs.LanguagesVO;
import com.techgigandroidhackathon.VOs.RegionalBlocsVO;
import com.techgigandroidhackathon.VOs.TranslationsVO;

import java.util.ArrayList;
import java.util.zip.CheckedOutputStream;

/**
 * Created by Amol G on 23-11-2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AndroidHackathonDB";
    private static final int DATABASE_VERSION = 1;
    private static final String COUNTRY_TABLE = DBConstants.COUNTRY_TABLE;
    private static final String CURRENCY_TABLE = DBConstants.CURRENCY_TABLE;
    private static final String LANGUAGE_TABLE = DBConstants.LANGUAGE_TABLE;
    private static final String REGIONAL_BLOCKS_TABLE = DBConstants.REGIONAL_BLOCKS_TABLE;
    private static final String TRANSLATIONS_TABLE = DBConstants.TRANSLATIONS_TABLE;

    private static final String CREATE_TABLE_COUNTRY = DBConstants.CREATE_TABLE_COUNTRY;
    private static final String CREATE_TABLE_CURRENCY = DBConstants.CREATE_TABLE_CURRENCY;
    private static final String CREATE_TABLE_LANGUAGES = DBConstants.CREATE_TABLE_LANGUAGES;
    private static final String CREATE_TABLE_REGIONAL_BLOCKS = DBConstants.CREATE_TABLE_REGIONAL_BLOCKS;
    private static final String CREATE_TABLE_TRANSLATIONS = DBConstants.CREATE_TABLE_TRANSLATIONS;


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_COUNTRY);
        db.execSQL(CREATE_TABLE_CURRENCY);
        db.execSQL(CREATE_TABLE_LANGUAGES);
        db.execSQL(CREATE_TABLE_REGIONAL_BLOCKS);
        db.execSQL(CREATE_TABLE_TRANSLATIONS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + COUNTRY_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CURRENCY_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + LANGUAGE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + REGIONAL_BLOCKS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TRANSLATIONS_TABLE);
        onCreate(db);
    }


    /**
     * Insert country list downloaded into database
     *
     * @param countryVOS
     * @return
     */
    public boolean insertCountryDetails(ArrayList<CountryVO> countryVOS) {
        SQLiteDatabase sqLiteDatabase = null;
        try {
            sqLiteDatabase = getWritableDatabase();
            for (CountryVO countryVO : countryVOS) {
                long rowId = sqLiteDatabase.insert(COUNTRY_TABLE, null, getContentValuesFromVO(countryVO, Constants.VO_ENUM.Country.ordinal()));
                if (rowId != -1) {
                    countryVO.setCountryId((int) rowId);
                    sqLiteDatabase.insert(CURRENCY_TABLE, null, getContentValuesFromVO(countryVO, Constants.VO_ENUM.Currencies.ordinal()));
                    sqLiteDatabase.insert(LANGUAGE_TABLE, null, getContentValuesFromVO(countryVO, Constants.VO_ENUM.Languages.ordinal()));
                    sqLiteDatabase.insert(REGIONAL_BLOCKS_TABLE, null, getContentValuesFromVO(countryVO, Constants.VO_ENUM.RegionalBlocs.ordinal()));
                    sqLiteDatabase.insert(TRANSLATIONS_TABLE, null, getContentValuesFromVO(countryVO, Constants.VO_ENUM.Translations.ordinal()));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != sqLiteDatabase) {
                sqLiteDatabase.close();
            }
        }
        return true;
    }

    /**
     * Retrieve country list
     *
     * @return
     */
    public ArrayList<CountryVO> retrieveCountryDetails() {
        ArrayList<CountryVO> countryVOS = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        String getCountryQuery = "select * from " + COUNTRY_TABLE;
        try {
            sqLiteDatabase = getReadableDatabase();
            cursor = sqLiteDatabase.rawQuery(getCountryQuery, null, null);
            getDataFromCursor(cursor, sqLiteDatabase, countryVOS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != sqLiteDatabase) {
                sqLiteDatabase.close();
            }
            if (null != cursor) {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
        return countryVOS;
    }

    public ContentValues getContentValuesFromVO(CountryVO countryVO, int voType) {
        ContentValues contentValues = new ContentValues();

        try {
            if (Constants.VO_ENUM.Country.ordinal() == voType) {
                contentValues.put(DBConstants.PARAM_COUNTRY_CIOC, countryVO.getCioc());
                contentValues.put(DBConstants.PARAM_COUNTRY_REGION, countryVO.getRegion());
                contentValues.put(DBConstants.PARAM_COUNTRY_NUMERIC_CODE, countryVO.getNumericCode());
                contentValues.put(DBConstants.PARAM_COUNTRY_CALLING_CODES, countryVO.getCallingCodes()[0]);
                contentValues.put(DBConstants.PARAM_COUNTRY_ALPHA3CODE, countryVO.getAlpha3Code());
                contentValues.put(DBConstants.PARAM_COUNTRY_NATIVE_NAME, countryVO.getNativeName());
                contentValues.put(DBConstants.PARAM_COUNTRY_TOP_LEVEL_DOMAIN, countryVO.getTopLevelDomain()[0]);
                contentValues.put(DBConstants.PARAM_COUNTRY_ALPHA2CODE, countryVO.getAlpha2Code());
                contentValues.put(DBConstants.PARAM_COUNTRY_CAPITAL, countryVO.getCapital());
                contentValues.put(DBConstants.PARAM_COUNTRY_ALT_SPELLINGS, countryVO.getAltSpellings()[0]);
                contentValues.put(DBConstants.PARAM_COUNTRY_SUB_REGION, countryVO.getSubregion());
                contentValues.put(DBConstants.PARAM_COUNTRY_TIME_ZONES, countryVO.getTimezones()[0]);
                contentValues.put(DBConstants.PARAM_COUNTRY_FLAG, countryVO.getFlag());
                contentValues.put(DBConstants.PARAM_COUNTRY_AREA, countryVO.getArea());
                contentValues.put(DBConstants.PARAM_COUNTRY_NAME, countryVO.getName());
                contentValues.put(DBConstants.PARAM_COUNTRY_LAT_LNG, countryVO.getLatlng()[0]);
                contentValues.put(DBConstants.PARAM_COUNTRY_DEMONYM, countryVO.getDemonym());
                contentValues.put(DBConstants.PARAM_COUNTRY_GINI, countryVO.getGini());
                contentValues.put(DBConstants.PARAM_COUNTRY_BORDERS, countryVO.getBorders().toString());
                contentValues.put(DBConstants.PARAM_COUNTRY_POPULATION, countryVO.getPopulation());

            } else if (Constants.VO_ENUM.Currencies.ordinal() == voType) {
                CurrenciesVO[] currenciesVO = countryVO.getCurrencies();
                contentValues.put(DBConstants.PARAM_CURRENCY_SYMBOL, currenciesVO[0].getSymbol());
                contentValues.put(DBConstants.PARAM_CURRENCY_NAME, currenciesVO[0].getName());
                contentValues.put(DBConstants.PARAM_CURRENCY_CODE, currenciesVO[0].getCode());

            } else if (Constants.VO_ENUM.Languages.ordinal() == voType) {
                LanguagesVO[] languagesVO = countryVO.getLanguages();
                contentValues.put(DBConstants.PARAM_ISO639_2, languagesVO[0].getIso639_2());
                contentValues.put(DBConstants.PARAM_ISO639_1, languagesVO[0].getIso639_1());
                contentValues.put(DBConstants.PARAM_LANGUAGE_NAME, languagesVO[0].getName());
                contentValues.put(DBConstants.PARAM_LANGUAGE_NATIVE_NAME, languagesVO[0].getNativeName());

            } else if (Constants.VO_ENUM.RegionalBlocs.ordinal() == voType) {
                RegionalBlocsVO[] regionalBlocsVO = countryVO.getRegionalBlocs();
                RegionalBlocsVO regionalBlocsVO1 = new Gson().fromJson(regionalBlocsVO.toString(), RegionalBlocsVO.class);
                if (null != regionalBlocsVO1.getOtherAcronyms().toString()) {
                    contentValues.put(DBConstants.PARAM_REGIONAL_BLOCK_OTHER_ACRONYM, regionalBlocsVO1.getOtherAcronyms().toString());
                } else {
                    contentValues.put(DBConstants.PARAM_REGIONAL_BLOCK_OTHER_ACRONYM, "");
                }
                if (null != regionalBlocsVO1.getAcronym()) {
                    contentValues.put(DBConstants.PARAM_REGIONAL_BLOCK_ACRONYM, regionalBlocsVO1.getAcronym());
                } else {
                    contentValues.put(DBConstants.PARAM_REGIONAL_BLOCK_ACRONYM, "");
                }
                if (null != regionalBlocsVO1.getName()) {
                    contentValues.put(DBConstants.PARAM_REGIONAL_BLOCK_NAME, regionalBlocsVO1.getName());
                } else {
                    contentValues.put(DBConstants.PARAM_REGIONAL_BLOCK_NAME, "");
                }
                if (null != regionalBlocsVO1.getOtherNames().toString()) {
                    contentValues.put(DBConstants.PARAM_REGIONAL_BLOCK_OTHER_NAMES, regionalBlocsVO1.getOtherNames().toString());
                } else {
                    contentValues.put(DBConstants.PARAM_REGIONAL_BLOCK_OTHER_NAMES, "");
                }

            } else if (Constants.VO_ENUM.Translations.ordinal() == voType) {
                TranslationsVO translationsVO = countryVO.getTranslations();
                contentValues.put(DBConstants.PARAM_TRANSLATIONS_HR, translationsVO.getHr());
                contentValues.put(DBConstants.PARAM_TRANSLATIONS_DE, translationsVO.getDe());
                contentValues.put(DBConstants.PARAM_TRANSLATIONS_IT, translationsVO.getIt());
                contentValues.put(DBConstants.PARAM_TRANSLATIONS_PT, translationsVO.getPt());
                contentValues.put(DBConstants.PARAM_TRANSLATIONS_FA, translationsVO.getFa());
                contentValues.put(DBConstants.PARAM_TRANSLATIONS_FR, translationsVO.getFr());
                contentValues.put(DBConstants.PARAM_TRANSLATIONS_BR, translationsVO.getBr());
                contentValues.put(DBConstants.PARAM_TRANSLATIONS_ES, translationsVO.getEs());
                contentValues.put(DBConstants.PARAM_TRANSLATIONS_NL, translationsVO.getNl());
                contentValues.put(DBConstants.PARAM_TRANSLATIONS_JA, translationsVO.getJa());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentValues;
    }

    /**
     * Get data from cursor
     *
     * @param cursor
     * @return
     */
    public void getDataFromCursor(Cursor cursor, SQLiteDatabase sqLiteDatabase, ArrayList<CountryVO> countryVOS) {
        if (null == cursor) {
            return;
        }
        if (cursor.moveToFirst()) {
            do {
                CountryVO countryVO = new CountryVO();
                int countryId = cursor.getInt(0);
                countryVO.setCioc(cursor.getString(1));
                countryVO.setRegion(cursor.getString(2));
                countryVO.setNumericCode(cursor.getString(3));
                countryVO.setCallingCodes(new String[]{cursor.getString(4)});
                countryVO.setAlpha3Code(cursor.getString(5));
                countryVO.setNativeName(cursor.getString(6));
                countryVO.setTopLevelDomain(new String[]{cursor.getString(7)});
                countryVO.setAlpha2Code(cursor.getString(8));
                countryVO.setCapital(cursor.getString(9));
                countryVO.setAltSpellings(new String[]{cursor.getString(10)});
                countryVO.setSubregion(cursor.getString(11));
                countryVO.setTimezones(new String[]{cursor.getString(12)});
                countryVO.setFlag(cursor.getString(13));
                countryVO.setArea(cursor.getString(14));
                countryVO.setName(cursor.getString(15));
                countryVO.setLatlng(new String[]{cursor.getString(16)});
                countryVO.setDemonym(cursor.getString(17));
                countryVO.setGini(cursor.getString(18));
                countryVO.setBorders(new String[]{cursor.getString(19)});
                countryVO.setPopulation(cursor.getString(20));
                countryVO.setCurrencies(new CurrenciesVO[]{getCurrencyForCountry(countryId, sqLiteDatabase)});
                countryVO.setLanguages(new LanguagesVO[]{getLanguageVOFroCountry(countryId, sqLiteDatabase)});
                countryVO.setRegionalBlocs(new RegionalBlocsVO[]{getRegionalBlocsVOForCountry(countryId, sqLiteDatabase)});
                countryVO.setTranslations(getTranslationsVOForCountry(countryId, sqLiteDatabase));
                countryVOS.add(countryVO);
            } while (cursor.moveToNext());
        }
    }

    /**
     * Get currencyVO
     *
     * @param countryId
     * @param sqLiteDatabase
     * @return
     */
    public CurrenciesVO getCurrencyForCountry(int countryId, SQLiteDatabase sqLiteDatabase) {
        CurrenciesVO currenciesVO = new CurrenciesVO();
        String getCurrencyVOFromDBQuery = "select * from " + CURRENCY_TABLE + " where " + DBConstants.PARAM_COUNTRY_ID + "=" + countryId;
        Cursor cursor = null;
        try {
            cursor = sqLiteDatabase.rawQuery(getCurrencyVOFromDBQuery, null);
            if (cursor.moveToFirst()) {
                int countryIdCurrency = cursor.getInt(0);
                currenciesVO.setSymbol(cursor.getString(1));
                currenciesVO.setName(cursor.getString(2));
                currenciesVO.setCode(cursor.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currenciesVO;
    }

    /**
     * Get LanguageVO
     *
     * @param countryId
     * @param sqLiteDatabase
     * @return
     */
    public LanguagesVO getLanguageVOFroCountry(int countryId, SQLiteDatabase sqLiteDatabase) {
        LanguagesVO languagesVO = new LanguagesVO();
        String getLanguageVOFroCountryQuery = "select * from " + LANGUAGE_TABLE + " where " + DBConstants.PARAM_COUNTRY_ID + "=" + countryId;
        Cursor cursor = null;
        try {
            cursor = sqLiteDatabase.rawQuery(getLanguageVOFroCountryQuery, null);
            if (cursor.moveToFirst()) {
                int countryIdLanguage = cursor.getInt(0);
                languagesVO.setIso639_2(cursor.getString(1));
                languagesVO.setIso639_1(cursor.getString(2));
                languagesVO.setName(cursor.getString(3));
                languagesVO.setNativeName(cursor.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return languagesVO;
    }

    /**
     * Get regionalBlocsVO for country
     *
     * @param countryId
     * @param sqLiteDatabase
     * @return
     */
    public RegionalBlocsVO getRegionalBlocsVOForCountry(int countryId, SQLiteDatabase sqLiteDatabase) {
        RegionalBlocsVO regionalBlocsVO = new RegionalBlocsVO();
        Cursor cursor = null;
        String getRegionalBlocsVOForCountryQuery = "select * from " + REGIONAL_BLOCKS_TABLE + " where " + DBConstants.PARAM_COUNTRY_ID + "=" + countryId;
        try {
            cursor = sqLiteDatabase.rawQuery(getRegionalBlocsVOForCountryQuery, null);
            if (cursor.moveToFirst()) {

                int countryIdRegionalBlocs = cursor.getInt(0);
                regionalBlocsVO.setOtherAcronyms(new String[]{cursor.getString(1)});
                regionalBlocsVO.setAcronym(cursor.getString(2));
                regionalBlocsVO.setName(cursor.getString(3));
                regionalBlocsVO.setOtherNames(new String[]{cursor.getString(4)});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regionalBlocsVO;
    }

    /**
     * Get translationsVO for Country
     *
     * @param countryId
     * @param sqLiteDatabase
     * @return
     */
    public TranslationsVO getTranslationsVOForCountry(int countryId, SQLiteDatabase sqLiteDatabase) {
        TranslationsVO translationsVO = new TranslationsVO();
        String getTranslationsVOForCountryQuery = "select * from " + TRANSLATIONS_TABLE + " where " + DBConstants.PARAM_COUNTRY_ID + "=" + countryId;
        Cursor cursor = null;
        try {
            cursor = sqLiteDatabase.rawQuery(getTranslationsVOForCountryQuery, null);
            if (cursor.moveToFirst()) {

                int countryIdTranslation = cursor.getInt(0);
                translationsVO.setHr(cursor.getString(1));
                translationsVO.setDe(cursor.getString(2));
                translationsVO.setIt(cursor.getString(3));
                translationsVO.setPt(cursor.getString(4));
                translationsVO.setFa(cursor.getString(5));
                translationsVO.setFr(cursor.getString(6));
                translationsVO.setBr(cursor.getString(7));
                translationsVO.setEs(cursor.getString(8));
                translationsVO.setNl(cursor.getString(9));
                translationsVO.setJa(cursor.getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return translationsVO;
    }
}
