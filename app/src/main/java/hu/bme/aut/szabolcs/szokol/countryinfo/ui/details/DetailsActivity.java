package hu.bme.aut.szabolcs.szokol.countryinfo.ui.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import hu.bme.aut.szabolcs.szokol.countryinfo.CountyInfoApplication;
import hu.bme.aut.szabolcs.szokol.countryinfo.R;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {

    @Inject
    DetailsPresenter detailsPresenter;

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
        detailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailsPresenter.detachScreen();
    }

}
