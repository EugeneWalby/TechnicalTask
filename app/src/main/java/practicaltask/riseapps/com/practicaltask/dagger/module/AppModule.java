package practicaltask.riseapps.com.practicaltask.dagger.module;

import dagger.Module;
import dagger.Provides;
import practicaltask.riseapps.com.practicaltask.core.App;
import practicaltask.riseapps.com.practicaltask.dagger.PerApp;

@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @PerApp
    App providePracticalTaskApp() {
        return app;
    }
}