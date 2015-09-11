package exam.dialog;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class Cancelable extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_dialogtest);

		Button btn = (Button)findViewById(R.id.call);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
	    		new AlertDialog.Builder(Cancelable.this)
	    		.setTitle("공지 사항")
	    		.setMessage("이 메시지는 반드시 읽어야 합니다.")
	    		.setIcon(R.drawable.icon)
	    		.setCancelable(false)
	    		.setNegativeButton("닫기", null)
	    		.show();
			}
		});		
	}
}