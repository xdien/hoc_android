package com.example.luutrushared;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class CaiDat extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		addPreferencesFromResource(R.xml.cauhinh);
		super.onCreate(savedInstanceState);
	}
	
}
