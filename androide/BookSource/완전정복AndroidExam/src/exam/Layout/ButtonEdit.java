package exam.Layout;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class ButtonEdit extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_buttonedit);

		Button btn = (Button)findViewById(R.id.btn);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				EditText edit = (EditText)findViewById(R.id.edit);
				String str = edit.getText().toString();
				Toast.makeText(ButtonEdit.this, str, Toast.LENGTH_SHORT).show();
			}
		});
	}
}