package exam.Widget;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class ProgressTitle extends Activity {
	int mProg;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.widget_progresstitle);

		mProg=5000;
		setProgress(mProg);
		setProgressBarVisibility(true);

		findViewById(R.id.decfirst).setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				if (mProg >= 200) mProg -= 200;
				setProgress(mProg);
			}
		});
		findViewById(R.id.incfirst).setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				if (mProg <= 9800) mProg += 200;
				setProgress(mProg);
			}
		});
	}
}