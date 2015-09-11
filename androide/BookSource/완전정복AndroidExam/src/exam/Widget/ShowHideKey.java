package exam.Widget;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.inputmethod.*;
import android.widget.*;
import exam.AndroidExam.*;

public class ShowHideKey extends Activity {
	InputMethodManager mImm;
	EditText mEdit;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_showhidekey);

		mImm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
		mEdit = (EditText)findViewById(R.id.edit);

		((Button)findViewById(R.id.show)).setOnClickListener(mClickListener);
		((Button)findViewById(R.id.hide)).setOnClickListener(mClickListener);
	}

	Button.OnClickListener mClickListener = new Button.OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.show:
				mImm.showSoftInput(mEdit, 0);
				break;
			case R.id.hide:
				mImm.hideSoftInputFromWindow(mEdit.getWindowToken(), 0);
				break;
			}
		}
	};
}