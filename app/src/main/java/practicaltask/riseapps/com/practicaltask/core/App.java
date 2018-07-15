package practicaltask.riseapps.com.practicaltask.core;

import android.app.Application;

import practicaltask.riseapps.com.practicaltask.dagger.AppComponent;
import practicaltask.riseapps.com.practicaltask.dagger.DaggerAppComponent;
import practicaltask.riseapps.com.practicaltask.dagger.module.AppModule;
import practicaltask.riseapps.com.practicaltask.dagger.module.GlobalModule;
import practicaltask.riseapps.com.practicaltask.dagger.module.NetworkModule;
import practicaltask.riseapps.com.practicaltask.network.CountriesApi;
import practicaltask.riseapps.com.practicaltask.storage.preferences.PreferencesImpl;

public class App extends Application {
    private static App instance;
    private AppComponent appComponent;
    private PreferencesImpl preferences;

    public static App getInstance() {
        return instance;
    }

    public AppComponent getApplicationComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        initializeDagger();
        initPreferences();
    }

    private void initializeDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .globalModule(new GlobalModule())
                .build();
    }

    private void initPreferences() {
        preferences = new PreferencesImpl(this);
    }

    public PreferencesImpl getPreferences() {
        return preferences;
    }
}