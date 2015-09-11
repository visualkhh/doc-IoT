package exam.Layout;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Inflation2 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout linear = new LinearLayout(this);
		linear.setOrientation(LinearLayout.VERTICAL);
		linear.setBackgroundColor(Color.WHITE);

		TextView text = new TextView(this);
		text.setText("TextView");
		text.setGravity(Gravity.CENTER);
		text.setTextColor(Color.RED);
		text.setTextSize(20);

		linear.addView(text);
		setContentView(linear);
		/* 파라미터 전달
		LinearLayout.LayoutParams paramlinear = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT);
		setContentView(linear,paramlinear);
		//*/
	}
}