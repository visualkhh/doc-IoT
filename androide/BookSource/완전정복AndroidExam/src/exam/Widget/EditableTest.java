package exam.Widget;

import android.app.*;
import android.os.*;
import android.text.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class EditableTest extends Activity {
	EditText mEdit;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_editabletest);

		mEdit = (EditText)findViewById(R.id.edit);

		((Button)findViewById(R.id.insert)).setOnClickListener(mClickListener);
		((Button)findViewById(R.id.delete)).setOnClickListener(mClickListener);
		((Button)findViewById(R.id.append)).setOnClickListener(mClickListener);
		((Button)findViewById(R.id.replace)).setOnClickListener(mClickListener);
		((Button)findViewById(R.id.clear)).setOnClickListener(mClickListener);
	}

	Button.OnClickListener mClickListener = new Button.OnClickListener() {
		public void onClick(View v) {
			Editable edit = mEdit.getText();
			switch (v.getId()) {
			case R.id.insert:
				edit.insert(0, "INS");
				break;
			case R.id.delete:
				edit.delete(2, 5);
				break;
			case R.id.append:
				edit.append("APP");
				/*
				String text = mEdit.getText().toString();
				text += "APP";
				mEdit.setText(text);
				//*/
				break;
			case R.id.replace:
				edit.replace(2, 5, "REP");
				break;
			case R.id.clear:
				edit.clear();
				break;
			}
		}
	};
}