package exam.Widget;

import android.app.*;
import android.os.*;
import android.text.*;
import android.widget.*;
import exam.AndroidExam.*;

public class EditLimit extends Activity {
	EditText mLimitEdit;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_editlimit);

		mLimitEdit = (EditText)findViewById(R.id.limit);
		mLimitEdit.setFilters(new InputFilter[] {
				new InputFilter.LengthFilter(3)
		});
	}
}