package hest.co.kr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MyIntentCaller extends Activity {
	Button btn_caller;
	EditText ed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_intent_caller);
		ed = (EditText) findViewById(R.id.send_text);
		btn_caller = (Button) findViewById(R.id.btn_caller);
		btn_caller.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent("MyIntentReceiver");
				intent.putExtra("mysend", ed.getText().toString());
				startActivityForResult(intent, 1234);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1234) {
			if (resultCode != RESULT_OK) {
				ed.setText("Result Empty");
			} else {
				String result = data.getExtras().getString("ACT_RESULT");
				ed.setText("Intent호출결과:" + result);
			}
		} else {
			super.onActivityResult(requestCode, resultCode, data);
		}
	}
}
