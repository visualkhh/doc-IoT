package exam.Input;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

/* 핸들러내의 지역 변수로 선언하기
public class HandlerAccess extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_handleraccess);

		LinearLayout linear = (LinearLayout)findViewById(R.id.linear); 
		linear.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					TextView text = (TextView)findViewById(R.id.text);
					text.setText("Touched");
					return true;
				}
				return false;
			}
		});
	}
}
//*/

/* 멤버로 선언해 놓기 
public class HandlerAccess extends Activity {
	TextView mText;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_handleraccess);

		mText = (TextView)findViewById(R.id.text);

		LinearLayout linear = (LinearLayout)findViewById(R.id.linear); 
		linear.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					mText.setText("Touched");
					return true;
				}
				return false;
			}
		});
	}
}
//*/

/* 핸들러를 포함한 메서드의 지역 변수 사용 
public class HandlerAccess extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_handleraccess);

		final TextView outText = (TextView)findViewById(R.id.text);

		LinearLayout linear = (LinearLayout)findViewById(R.id.linear); 
		linear.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					outText.setText("Touched");
					return true;
				}
				return false;
			}
		});
	}
}
//*/

//* 핸들러를 포함한서브 메서드의 인수 사용 
public class HandlerAccess extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_handleraccess);

		TextView outText = (TextView)findViewById(R.id.text);
		SetTouchHandler(outText);
	}
	
	void SetTouchHandler(TextView tv) {
		final TextView fText = tv;
		
		LinearLayout linear = (LinearLayout)findViewById(R.id.linear); 
		linear.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					fText.setText("Touched");
					return true;
				}
				return false;
			}
		});
	}
}
//*/
