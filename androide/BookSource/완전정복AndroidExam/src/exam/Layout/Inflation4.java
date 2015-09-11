package exam.Layout;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class Inflation4 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    LinearLayout linear = new LinearLayout(this);
	    linear.setOrientation(LinearLayout.VERTICAL);
	    linear.setBackgroundColor(Color.WHITE);

	    TextView text = (TextView)View.inflate(this, R.layout.layout_mytext, null);

	    linear.addView(text);
	    setContentView(linear);
	}
}