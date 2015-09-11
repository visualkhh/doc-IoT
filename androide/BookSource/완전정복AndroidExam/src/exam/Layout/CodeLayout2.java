package exam.Layout;

import android.app.*;
import android.os.*;
import android.widget.*;
import exam.AndroidExam.*;

public class CodeLayout2 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_codelayout);

		LinearLayout MyLinear=(LinearLayout)findViewById(R.id.MyLinear);
		MyLinear.setOrientation(LinearLayout.HORIZONTAL);

		Button MyBtn = (Button)findViewById(R.id.MyButton);
		MyBtn.setTextSize(40);

		EditText MyEdit = (EditText)findViewById(R.id.MyEdit);
		MyEdit.setBackgroundColor(0xff00ff00);
	}
}