package exam.thread;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class ANR extends Activity  implements View.OnClickListener {
	Button mUpload;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thread_upload);

		mUpload = (Button)findViewById(R.id.upload);
		mUpload.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.upload:
			doUpload();
			Toast.makeText(this, "업로드를 완료했습니다.", 0).show();
			break;
		}
	}

	void doUpload() {
		for (int i = 0; i < 100; i++) {
			try { Thread.sleep(100); } catch (InterruptedException e) {;}
		}
	}
}
