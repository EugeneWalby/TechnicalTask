package practicaltask.riseapps.com.practicaltask.ui;

import android.os.Bundle;

import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainView {
    private final MainPresenter mainPresenter = new MainPresenter();

    @Override
    protected int provideLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter.setView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.setView(null);
    }
}