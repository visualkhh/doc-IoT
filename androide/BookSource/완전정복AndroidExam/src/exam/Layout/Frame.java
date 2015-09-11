package exam.Layout;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class Frame extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_frame);

		Button btn = (Button)findViewById(R.id.btn);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				ImageView img=(ImageView)findViewById(R.id.img);
				if (img.getVisibility() == View.VISIBLE) {
					img.setVisibility(View.INVISIBLE);
				} else {
					img.setVisibility(View.VISIBLE);
				}
			}
		});
	}
}