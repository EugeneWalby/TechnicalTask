package practicaltask.riseapps.com.practicaltask.ui.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

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
    }

    protected void moveToScreenWithoutBack(@NonNull final Class<?> screenToMove) {
        moveToScreen(screenToMove);
        finish();
    }

    protected void showToast(final String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(@StringRes final int text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}