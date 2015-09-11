package exam.thread;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class Upload extends Activity implements View.OnClickListener {
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
			new AlertDialog.Builder(Upload.this)
			.setTitle("질문")
			.setMessage("업로드 하시겠습니까?")
			.setPositiveButton("예", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					doUpload();
				}
			})
			.setNegativeButton("아니오", null)
			.show();
			break;
		}
	}

	void doUpload() {
		for (int i = 0; i < 20; i++) {
			try { Thread.sleep(100); } catch (InterruptedException e) {;}
		}
		Toast.makeText(this, "업로드를 완료했습니다.", 0).show();
	}
}
