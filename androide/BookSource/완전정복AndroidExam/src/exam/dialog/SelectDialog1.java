package exam.dialog;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class SelectDialog1 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_dialogtest);

		Button btn = (Button)findViewById(R.id.call);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				new AlertDialog.Builder(SelectDialog1.this)
				.setTitle("음식을 선택하시오.")
				.setIcon(R.drawable.icon)
				.setItems(R.array.foods, 
				// .setItems(new String[] {"짜장면", "우동", "짱뽕", "탕수육" }, 
					new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						String[] foods = getResources().getStringArray(R.array.foods);
						TextView text = (TextView)findViewById(R.id.text);
						text.setText("선택한 음식 = " + foods[which]);
					}
				})
				.setNegativeButton("취소", null)
				.show();
			}
		});		
	}
}
