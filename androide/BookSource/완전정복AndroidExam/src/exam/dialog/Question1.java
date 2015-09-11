package exam.dialog;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

/* 리스너 안에 직접 코드 작성 - 중복이 심함
public class Question1 extends Activity {
	int a = 3;
	int b = 4;
	int result;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_dialogtest);

		Button btn = (Button)findViewById(R.id.call);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				new AlertDialog.Builder(Question1.this)
				.setTitle("질문")
				.setMessage("어떤 연산을 하시겠습니까?")
				.setPositiveButton("덧셈", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						result = a + b;
						TextView text = (TextView)findViewById(R.id.text);
						text.setText("연산 결과 = " + result);
						Toast.makeText(Question1.this, "연산을 완료하였습니다.", 
								Toast.LENGTH_LONG).show();
					}
				})
				.setNegativeButton("곱셈", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						result = a * b;
						TextView text = (TextView)findViewById(R.id.text);
						text.setText("연산 결과 = " + result);
						Toast.makeText(Question1.this, "연산을 완료하였습니다.", 
								Toast.LENGTH_LONG).show();
					}
				})
				.show();
			}
		});		
	}
}
//*/

/* 잘못된 코드
public class Question1 extends Activity {
	int a = 3;
	int b = 4;
	int result;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_dialogtest);

		Button btn = (Button)findViewById(R.id.call);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				new AlertDialog.Builder(Question1.this)
				.setTitle("질문")
				.setMessage("어떤 연산을 하시겠습니까?")
				.setPositiveButton("덧셈", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						result = a + b;
					}
				})
				.setNegativeButton("곱셈", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						result = a * b;
					}
				})
				.show();

				TextView text = (TextView)findViewById(R.id.text);
				text.setText("연산 결과 = " + result);
				Toast.makeText(Question1.this, "연산을 완료하였습니다.", 
						Toast.LENGTH_LONG).show();
			}
		});		
	}
}
//*/

//* 리스너를 통합 - 중복은 없으나 메서드를 따로 분리해야 함
public class Question1 extends Activity {
	int a = 3;
	int b = 4;
	int result;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_dialogtest);

		Button btn = (Button)findViewById(R.id.call);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				new AlertDialog.Builder(Question1.this)
				.setTitle("질문")
				.setMessage("어떤 연산을 하시겠습니까?")
				.setPositiveButton("덧셈", mClick)
				.setNegativeButton("곱셈", mClick)
				.show();
			}
		});		
	}
	
	DialogInterface.OnClickListener mClick = new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int whichButton) {
			if (whichButton == DialogInterface.BUTTON1) {
				result = a + b;
			} else {
				result = a * b;
			}
			TextView text = (TextView)findViewById(R.id.text);
			text.setText("연산 결과 = " + result);
			Toast.makeText(Question1.this, "연산을 완료하였습니다.", 
					Toast.LENGTH_LONG).show();
		}
	};
}
//*/

