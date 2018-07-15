package practicaltask.riseapps.com.practicaltask.dagger.module;

import dagger.Module;
import dagger.Provides;
import practicaltask.riseapps.com.practicaltask.core.App;
import practicaltask.riseapps.com.practicaltask.dagger.PerApp;
import practicaltask.riseapps.com.practicaltask.storage.preferences.Preferences;
import practicaltask.riseapps.com.practicaltask.storage.preferences.PreferencesImpl;

@Module
public class GlobalModule {
    @Provides
    @PerApp
    Preferences providePreferencesImpl(App app) {
        return new PreferencesImpl(app);
    }
}