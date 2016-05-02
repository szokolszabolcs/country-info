package hu.bme.aut.szabolcs.szokol.countryinfo.ui.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import hu.bme.aut.szabolcs.szokol.countryinfo.CountyInfoApplication;
import hu.bme.aut.szabolcs.szokol.countryinfo.R;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.main.MainPresenter;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.main.MainScreen;

public class DetailsActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CountyInfoApplication.injector.inject(this);
        setContentView(R.layout.activity_deatils);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

}
