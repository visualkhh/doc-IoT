package exam.Widget;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.text.*;
import android.widget.*;
import exam.AndroidExam.*;

public class TextChange extends Activity {
	EditText mEdit;
	TextView mText;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_textchange);

		mEdit = (EditText)findViewById(R.id.edit);
		mText = (TextView)findViewById(R.id.text);
		mEdit.addTextChangedListener(mWatcher);
	}

	TextWatcher mWatcher = new TextWatcher() {
		public void afterTextChanged(Editable s) {
		}

		public void beforeTextChanged(CharSequence s, int start, int count,	int after) {
		}

		public void onTextChanged(CharSequence s, int start, int before, int count) {
			mText.setText("echo:" + s);
		}
	};
}

