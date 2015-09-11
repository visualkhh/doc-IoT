package exam.Widget;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class ProgressTitle2 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.widget_progresstitle2);

		findViewById(R.id.start).setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				setProgressBarIndeterminateVisibility(true);
			}
		});
		findViewById(R.id.stop).setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				setProgressBarIndeterminateVisibility(false);
			}
		});
	}
}