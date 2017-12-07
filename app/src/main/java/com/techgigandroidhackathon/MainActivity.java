package com.techgigandroidhackathon;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.techgigandroidhackathon.Adapters.CountryListAdapter;
import com.techgigandroidhackathon.AsyncTaskManager.GetCountryDetailsFromServer;
import com.techgigandroidhackathon.DBHandler.DBHandler;
import com.techgigandroidhackathon.VOs.CountryVO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DBHandler dbHandler;
    private MenuItem searchMenuItem;
    private SearchView searchView;
    private CountryListAdapter countryListAdapter;
    private ArrayList<CountryVO> countryVOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUiElements();
        new GetCountryDetailsFromServer(this).execute();
        bindList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainscreen_menu, menu);
        SearchManager searchManager = (SearchManager)
                getSystemService(Context.SEARCH_SERVICE);
        searchMenuItem = menu.findItem(R.id.searchMenu);
        searchView = (SearchView) searchMenuItem.getActionView();

        searchView.setSearchableInfo(searchManager.
                getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.searchMenu:

                break;
        }
        return true;
    }

    private void initializeUiElements() {
        dbHandler = new DBHandler(this);
        recyclerView = (RecyclerView) findViewById(R.id.countryRecyclerView);
    }

    private void bindList() {
        countryVOS = dbHandler.retrieveCountryDetails();
        countryListAdapter = new CountryListAdapter(this, countryVOS);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(countryListAdapter);
    }
}
