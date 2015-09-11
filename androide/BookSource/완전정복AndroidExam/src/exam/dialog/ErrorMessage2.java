package exam.dialog;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class ErrorMessage2 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_dialogtest);

		Button btn = (Button)findViewById(R.id.call);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				// 어떤 작업을 수행한다.
				try {
					Thread.sleep(500);
				} catch (Exception e) {;}
				
				// 작업중에 에러 발생했다고 가정
				boolean ErrorOccur = true;
				if (ErrorOccur) {
					new AlertDialog.Builder(ErrorMessage2.this)
					.setTitle("에러 발생")
					.setMessage("어쩌고 저쩌고 이유로 작업을 계속할 수 없어 종료합니다.")
					.setPositiveButton("종료", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int whichButton) {
							finish();
						}
					})
					.show();
				} else {
					Toast.makeText(ErrorMessage2.this, "작업이 무사히 끝났습니다.", 
							Toast.LENGTH_LONG).show();
				}
			}
		});		
	}
}