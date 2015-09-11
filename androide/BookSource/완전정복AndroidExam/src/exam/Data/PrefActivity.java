package exam.Data;

import android.os.*;
import android.preference.*;
import exam.AndroidExam.*;

public class PrefActivity extends PreferenceActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.layout.data_prefactivity);
    }
}