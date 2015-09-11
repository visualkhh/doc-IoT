package exam.Widget;

import android.app.*;
import android.content.*;
import android.os.*;
import android.text.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class NumEdit extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_numedit);
	}
}

class NumEditWidget extends LinearLayout implements TextWatcher {
	EditText mEdit;
	TextView mText;
	
	public NumEditWidget(Context context) {
		super(context);
		init();
	}
	
	public NumEditWidget(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	void init() {
		/* 코드로 직접 차일드 생성
		setOrientation(LinearLayout.VERTICAL);
		mEdit = new EditText(getContext());
		mText = new TextView(getContext());
		mText.setText("Now Length : 0 Characters");

		LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		addView(mEdit, param);
		addView(mText, param);
		//*/
		
		//* 레이아웃 전개
		LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.widget_numeditwidget, this, true);
		mEdit = (EditText)findViewById(R.id.limedit_edit);
		mText = (TextView)findViewById(R.id.limedit_text);
		//*/
		
		mEdit.addTextChangedListener(this);
	}

	public void afterTextChanged(Editable s) {
	}

	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
	}

	public void onTextChanged(CharSequence s, int start, int before, int count) {
		mText.setText("Now Length : " + s.length() + " Characters");
	}
}
