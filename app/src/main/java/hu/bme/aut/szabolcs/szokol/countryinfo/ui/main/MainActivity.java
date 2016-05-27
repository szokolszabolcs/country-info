package hu.bme.aut.szabolcs.szokol.countryinfo.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import hu.bme.aut.szabolcs.szokol.countryinfo.CountyInfoApplication;
import hu.bme.aut.szabolcs.szokol.countryinfo.R;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.favourites.FavouritesFragment;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.login.LoginActivity;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.search.SearchFragment;

public class MainActivity extends AppCompatActivity
        implements MainScreen, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    MainPresenter mainPresenter;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.container)
    FrameLayout container;
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private CountyInfoApplication application;
    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CountyInfoApplication.injector.inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        application = (CountyInfoApplication) getApplication();
        mTracker = application.getDefaultTracker();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (drawerLayout != null) {
            drawerLayout.setDrawerListener(toggle);
        }
        toggle.syncState();

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = null;
        fragment = fm.findFragmentByTag(SearchFragment.FRAGMENT_SEARCH);
        if (fragment == null) {
            fragment = SearchFragment.newInstance();
        }
        fm.beginTransaction().replace(R.id.container, fragment)
                .addToBackStack(SearchFragment.FRAGMENT_SEARCH).commit();

        if (navView != null) {
            navView.setNavigationItemSelectedListener(this);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Log.i("Analytics", "Main sceeen loaded");
        mTracker.setScreenName("Image~" + this.getClass().getSimpleName());
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void onBackPressed() {
        if ((drawerLayout != null) && (drawerLayout.isDrawerOpen(GravityCompat.START))) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = null;

        int id = item.getItemId();

        if (id == R.id.nav_search) {
            fragment = fm.findFragmentByTag(SearchFragment.FRAGMENT_SEARCH);
            if (fragment == null) {
                fragment = SearchFragment.newInstance();
            }
            fm.beginTransaction().replace(R.id.container, fragment)
                    .addToBackStack(SearchFragment.FRAGMENT_SEARCH).commit();
        } else if (id == R.id.nav_favourites) {
            fragment = fm.findFragmentByTag(FavouritesFragment.FRAGMENT_FAVOURITES);
            if (fragment == null) {
                fragment = FavouritesFragment.newInstance();
            }
            fm.beginTransaction().replace(R.id.container, fragment)
                    .addToBackStack(FavouritesFragment.FRAGMENT_FAVOURITES).commit();
        } else if (id == R.id.nav_all_countries) {
            throw new UnsupportedOperationException("Try crash!");
            //fragment = fm.findFragmentByTag(AllCountriesFragment.FRAGMENT_ALL_COUNTRIES);
            //if (fragment == null) {
            //    fragment = AllCountriesFragment.newInstance();
            //}
            //fm.beginTransaction().replace(R.id.container, fragment)
            //        .addToBackStack(AllCountriesFragment.FRAGMENT_ALL_COUNTRIES).commit();
        } else if (id == R.id.nav_log_out) {
            mainPresenter.logout();
        }

        Log.i("Analytics", "Tab changed");
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Tab changed")
                .build());

        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        return true;
    }

    @Override
    public void navigateToLogIn() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
