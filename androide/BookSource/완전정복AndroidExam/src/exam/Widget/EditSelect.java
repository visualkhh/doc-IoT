package exam.Widget;

import android.app.*;
import android.os.*;
import android.text.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class EditSelect extends Activity {
	EditText mEdit;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_editselect);

		mEdit = (EditText)findViewById(R.id.edit);

		((Button)findViewById(R.id.home)).setOnClickListener(mClickListener);
		((Button)findViewById(R.id.end)).setOnClickListener(mClickListener);
		((Button)findViewById(R.id.selblock)).setOnClickListener(mClickListener);
		((Button)findViewById(R.id.selall)).setOnClickListener(mClickListener);
		((Button)findViewById(R.id.getsel)).setOnClickListener(mClickListener);
	}

	Button.OnClickListener mClickListener = new Button.OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.home:
				mEdit.setSelection(0);
				break;
			case R.id.end:
				mEdit.setSelection(mEdit.getText().length());
				break;
			case R.id.selblock:
				mEdit.setSelection(3,10);
				break;
			case R.id.selall:
				mEdit.selectAll();
				break;
			case R.id.getsel:
				int start = mEdit.getSelectionStart();
				int end = mEdit.getSelectionEnd();
				Toast.makeText(EditSelect.this, 
						"start = " + start + ",end = " + end, 
						Toast.LENGTH_LONG).show();
				break;
			}
		}
	};
}