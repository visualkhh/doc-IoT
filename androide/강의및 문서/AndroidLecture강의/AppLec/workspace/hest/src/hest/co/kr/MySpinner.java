package hest.co.kr;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MySpinner extends Activity {
	Spinner s1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_spinner);
		s1 = (Spinner)findViewById(R.id.spinner1);
		String[] items = {"°í·¡¹ä", "»ç¶Ç¹ä", "ÀÎµð¾ð¹ä"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_spinner_item, items);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s1.setAdapter(adapter);
		s1.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				TextView tv = (TextView)findViewById(R.id.tv_sp);
				tv.setText("You choosed: " + s1.getSelectedItem().toString());				
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
	}
}






