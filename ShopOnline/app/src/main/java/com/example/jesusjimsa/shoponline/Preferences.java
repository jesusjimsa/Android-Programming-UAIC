package com.example.jesusjimsa.shoponline;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import java.util.List;

public class Preferences extends PreferenceActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
	}

	@Override
	protected boolean isValidFragment(String fragmentName) {
		return MyPreferenceFragment.class.getName().equals(fragmentName);
	}
}