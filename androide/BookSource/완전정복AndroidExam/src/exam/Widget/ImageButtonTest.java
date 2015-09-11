package exam.Widget;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class ImageButtonTest extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_imagebuttontest);

		ImageButton imgbtn = (ImageButton)findViewById(R.id.imagebtn);
		imgbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(ImageButtonTest.this, "Image Button Clicked", 
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}