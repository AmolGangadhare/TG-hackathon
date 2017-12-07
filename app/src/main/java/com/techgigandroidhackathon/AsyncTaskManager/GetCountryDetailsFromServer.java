package com.techgigandroidhackathon.AsyncTaskManager;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.techgigandroidhackathon.Constants.HttpConstants;
import com.techgigandroidhackathon.DBHandler.DBHandler;
import com.techgigandroidhackathon.Utils.ApplicationUtils;
import com.techgigandroidhackathon.VOs.CountryVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amol G on 01-12-2017.
 */

public class GetCountryDetailsFromServer extends AsyncTask<Void, Void, Void> {

    private Type type = new TypeToken<List<CountryVO>>() {
    }.getType();
    private Context context;
    private DBHandler dbHandler;

    public GetCountryDetailsFromServer(Context context) {
        this.context = context;
        dbHandler = new DBHandler(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        ApplicationUtils.showProgressDialog(context, "Loading", "Please wait");
    }

    @Override
    protected Void doInBackground(Void... params) {

        String str = HttpConstants.URL;
        URLConnection urlConn = null;
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(str);
            urlConn = url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            ArrayList<CountryVO> countryVOS = new Gson().fromJson(stringBuffer.toString(), type);
            dbHandler.insertCountryDetails(countryVOS);
        } catch (Exception ex) {
            Log.e("App", "yourDataTask", ex);
            return null;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        try {
            ApplicationUtils.cancelProgressDialog();
        } catch (Exception ex) {
            Log.e("App", "Failure", ex);
        }
    }
}