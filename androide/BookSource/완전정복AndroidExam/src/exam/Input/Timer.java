package exam.Input;

import android.app.*;
import android.os.*;
import android.widget.*;
import exam.AndroidExam.*;

/* 핸들러 멤버
public class Timer extends Activity {
	int value=0;
	TextView mText;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_timer);

		mText=(TextView)findViewById(R.id.text);
		mHandler.sendEmptyMessage(0);
	}

	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			value++;
			mText.setText("Value = " + value);
			mHandler.sendEmptyMessageDelayed(0,1000);
		}
	};
}
//*/

//* onCreate에서 생성한 핸들러
public class Timer extends Activity {
	int value=0;
	TextView mText;
	Handler mHandler;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_timer);

		mText=(TextView)findViewById(R.id.text);

		mHandler = new Handler() {
			public void handleMessage(Message msg) {
				value++;
				mText.setText("Value = " + value);
				if (value < 5) {
					mHandler.sendEmptyMessageDelayed(0,1000);
				}
			}
		};
		mHandler.sendEmptyMessage(0);
	}
}
//*/

/* 타이머 객체
public class Timer extends Activity {
	int value=0;
	TextView mText;
	CountDownTimer mTimer;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_timer);

		mText=(TextView)findViewById(R.id.text);

		new CountDownTimer(10 * 1000, 1000) {
			public void onTick(long millisUntilFinished) {
				value++;
				mText.setText("Value = " + value);
				if (value == 5) {
					cancel();
				}
			}
			public void onFinish() {
			}
		}.start();
	}
}
//*/

