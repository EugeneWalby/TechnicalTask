package practicaltask.riseapps.com.practicaltask.ui.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import practicaltask.riseapps.com.practicaltask.ui.SplashActivity;

@SuppressLint("Registered")
public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    protected abstract int provideLayout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayout());
    }

    protected void moveToScreen(@NonNull final Class<?> screenToMove) {
        final Intent intent = new Intent(this, screenToMove);
        startActivity(intent);
        finish();
    }
}