package hest.co.kr;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class MyBundle extends Activity {

	private String mymsg = null;
	private EditText ed;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ed = new EditText(this);
		setContentView(ed);
		if(savedInstanceState==null) {
			mymsg = "null";
		} else {
			mymsg = savedInstanceState.getString("okgosu");
		}
		ed.setText(mymsg);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString("okgosu", ed.getText().toString());
	}
}






