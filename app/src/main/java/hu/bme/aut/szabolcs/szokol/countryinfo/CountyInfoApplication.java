package hu.bme.aut.szabolcs.szokol.countryinfo;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import hu.bme.aut.szabolcs.szokol.countryinfo.repository.Repository;
import hu.bme.aut.szabolcs.szokol.countryinfo.ui.UiModule;
import io.fabric.sdk.android.Fabric;

public class CountyInfoApplication extends Application {

    @Inject
    Repository repository;

    private Tracker mTracker;

    public static CountryInfoApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        if (BuildConfig.MOCK) {
            injector = DaggerMockCountryInfoApplicationComponent.builder().uiModule(new UiModule(this)).build();
        } else {
            injector = DaggerCountryInfoApplicationComponent.builder().uiModule(new UiModule(this)).build();
        }

        injector.inject(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        repository.terminate();
    }

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     *
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }

}
