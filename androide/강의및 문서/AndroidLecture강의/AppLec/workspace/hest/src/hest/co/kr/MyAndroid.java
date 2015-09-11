package hest.co.kr;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MyAndroid extends Activity {

	private OnClickListener btnOneListener = new OnClickListener() {
		public void onClick(View v) {
			Toast.makeText(MyAndroid.this, "반갑습니다", 1000).show();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_android);
		Button btn_one = (Button) findViewById(R.id.btn_one);
		btn_one.setOnClickListener(btnOneListener );
		
		final Button btn_two = (Button)findViewById(R.id.btn_two);
		btn_two.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//Toast.makeText(MyAndroid.this, "안녕하세요.", 1000).show();
				
				new AlertDialog.Builder(MyAndroid.this)
					.setTitle("선택상자")
					.setMessage("안녕하세요")
					.setNeutralButton("닫기", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							btn_two.setText(getResources().getString(R.string.hello));
						}
					}).show();
			}
		});
	}
}





