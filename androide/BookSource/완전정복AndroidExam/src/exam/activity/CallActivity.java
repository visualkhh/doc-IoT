package exam.activity;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class CallActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_callactivity);

		Button btnCall=(Button)findViewById(R.id.call);
		btnCall.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(CallActivity.this, SubActivity.class);
				startActivity(intent);
			}
		});
	}
}
