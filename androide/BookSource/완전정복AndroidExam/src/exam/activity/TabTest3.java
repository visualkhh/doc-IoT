package exam.activity;

import android.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;

public class TabTest3 extends TabActivity {
	TabHost mTab;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        TabHost tabHost = getTabHost();

        tabHost.addTab(tabHost.newTabSpec("tag")
                .setIndicator("Curve")
                .setContent(new Intent(this, SaveCurve.class)));

        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("State")
                .setContent(new Intent(this, SaveState.class)));
        
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("Edit")
                .setContent(new Intent(this, ActEdit.class)));
	}
}