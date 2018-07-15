package practicaltask.riseapps.com.practicaltask.storage.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferencesImpl extends BasePreferences implements Preferences {
    private interface Keys {
        String LAST_REGION = "Last region";
    }

    private interface DefaultValues {
        String STRING_DEF_VALUE = "";
    }

    private SharedPreferences sharedPreferences;

    public PreferencesImpl(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getLastRegion() {
        return getString(Keys.LAST_REGION, DefaultValues.STRING_DEF_VALUE);
    }

    public void setLastRegion(final String lastRegion) {
        putString(Keys.LAST_REGION, lastRegion);
    }

    @Override
    protected SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    @Override
    public void test() {
    }


}