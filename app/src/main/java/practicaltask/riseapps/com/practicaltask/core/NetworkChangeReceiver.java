package practicaltask.riseapps.com.practicaltask.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import practicaltask.riseapps.com.practicaltask.R;

public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, final Intent intent) {
        final ConnectivityManager connMgr =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        final NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if (!wifi.isAvailable() || !mobile.isAvailable()) {
            Toast.makeText(App.getInstance(), R.string.msgCheckInternetConnection, Toast.LENGTH_SHORT).show();
        }
    }
}