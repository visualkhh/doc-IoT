package exam.thread;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class LongTime2 extends Activity {
	int mValue;
	TextView mText;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thread_longtime);

		mText=(TextView)findViewById(R.id.text);
		Button btnUpdate = (Button)findViewById(R.id.update);
		btnUpdate.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				mValue = 0;
				mHandler.sendEmptyMessage(0);
			}
		});
	}

	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			mValue++;
			mText.setText(Integer.toString(mValue));
			try { Thread.sleep(50); } catch (InterruptedException e) {;}
			if (mValue < 100) {
				mHandler.sendEmptyMessage(0);
			}
		}
	};
}






