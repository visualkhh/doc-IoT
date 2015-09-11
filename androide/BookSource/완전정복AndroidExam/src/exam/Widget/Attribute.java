package exam.Widget;

import android.app.*;
import android.content.*;
import android.content.res.*;
import android.os.*;
import android.util.*;
import android.widget.*;
import exam.AndroidExam.*;

public class Attribute extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_attribute);
		
		AttrButton btn = (AttrButton)findViewById(R.id.attrbtn);
		EditText edit = (EditText)findViewById(R.id.attredit);
		edit.setText(btn.mText);
	}
}

class AttrButton extends Button {
	String mText = "";
	
	public AttrButton(Context context, AttributeSet attrs) {
		super(context, attrs);

		int i;
		String Name;
		String Value;
		for (i=0;i<attrs.getAttributeCount();i++) {
			Name = attrs.getAttributeName(i);
			Value = attrs.getAttributeValue(i);
			mText += (Name + " = " + Value + "\n");
		}
		
		//* 아래 ??? 자리에 구하고자 하는 속성의 id 배열을 전달해야 하는데 어떻게 전달하는지를 잘 모르겠음.
		// TypedArray ar = context.obtainStyledAttributes(attrs, android.R.styleable.TextView);
		//*/
	}
}