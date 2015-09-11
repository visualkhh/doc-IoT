package hest.co.kr;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MyXMLPref extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.my_pref);
	}
}
