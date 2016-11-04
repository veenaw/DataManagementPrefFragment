package com.example.android.datamanagementpreffragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

public class ViewAndUpdatePreferencesActivity extends Activity {
    private static final String USERNAME = "uname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_and_update_preferences);
    }


    // Fragment that displays the username preference
    public static class UserPreferenceFragment extends PreferenceFragment {

        protected static final String TAG = "UserPrefsFragment";
        private SharedPreferences.OnSharedPreferenceChangeListener mListener;
        private Preference mUserNamePreference;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.user_prefs);

            // Get the username Preference
            mUserNamePreference = getPreferenceManager()
                    .findPreference(USERNAME);

            // Attach a listener to update summary when username changes
            mListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
                @Override
                public void onSharedPreferenceChanged(
                        SharedPreferences sharedPreferences, String key) {
                    mUserNamePreference.setSummary(sharedPreferences.getString(
                            USERNAME, "None Set"));
                }
            };

            // Get SharedPreferences object managed by the PreferenceManager for
            // this Fragment
            SharedPreferences prefs = getPreferenceManager()
                    .getSharedPreferences();

            // Register a listener on the SharedPreferences object
            prefs.registerOnSharedPreferenceChangeListener(mListener);

            // Invoke callback manually to display the current username
            mListener.onSharedPreferenceChanged(prefs, USERNAME);

        }

    }
}
