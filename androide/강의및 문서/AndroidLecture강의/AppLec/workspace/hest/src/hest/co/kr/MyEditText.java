package hest.co.kr;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MyEditText extends Activity {
	TextView tv;
	EditText ed;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_edit_text);
		tv = (TextView)findViewById(R.id.label);
		ed = (EditText)findViewById(R.id.entry);
		ed.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				tv.setText("You typed: " + ed.getText().length());
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				
			}
			
			public void afterTextChanged(Editable s) {
				
			}
		});
		
	}
}








