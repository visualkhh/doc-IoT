package exam.thread;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class LongTime extends Activity {
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
				Update();
			}
		});
	}
	
	public void Update() {
		for (int i=0;i<100;i++) {
			mValue++;
			mText.setText(Integer.toString(mValue));
			try { Thread.sleep(50); } catch (InterruptedException e) {;}
		}
	}
}





