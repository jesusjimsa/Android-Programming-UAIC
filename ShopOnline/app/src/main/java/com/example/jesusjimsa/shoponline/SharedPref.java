package com.example.jesusjimsa.shoponline;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceActivity;

public class SharedPref extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

	public static final String KEY_CHECKBOX = "checkbox";
	public static final String KEY_LIST_PREF = "listpreference_key";

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		if(key.equals(KEY_CHECKBOX)){
			Preference connectionPref = findPreference(key);

			// Set summary to be the user-description for the selected value
			connectionPref.setSummary(sharedPreferences.getString(key, ""));
		}
		else{
			if(key.equals(KEY_LIST_PREF)){
				Preference connectionPref = findPreference(key);

				// Set summary to be the user-description for the selected value
				connectionPref.setSummary(sharedPreferences.getString(key, ""));
			}
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
	}
}