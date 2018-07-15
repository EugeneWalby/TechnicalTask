package practicaltask.riseapps.com.practicaltask.ui.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.core.App;
import practicaltask.riseapps.com.practicaltask.ui.SplashActivity;


@SuppressLint("Registered")
public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    protected abstract int provideLayout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayout());
        initActionBar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void moveToScreen(@NonNull final Class<?> screenToMove) {
        final Intent intent = new Intent(this, screenToMove);
        startActivity(intent);
    }

    protected void moveToScreenWithoutBack(@NonNull final Class<?> screenToMove) {
        moveToScreen(screenToMove);
        finish();
    }

    protected void showToast(final String text) {
        final Toast toast = Toast.makeText(App.getInstance(), text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    protected void showToast(@StringRes final int text) {
        final Toast toast = Toast.makeText(App.getInstance(), text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    protected boolean isInternetConnectionEstablished() {
        final ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    private void initActionBar() {
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}