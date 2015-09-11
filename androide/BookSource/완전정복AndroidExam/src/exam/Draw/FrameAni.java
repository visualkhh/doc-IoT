package exam.Draw;

import android.app.*;
import android.graphics.drawable.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class FrameAni extends Activity {
	AnimationDrawable mAni;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.draw_frameani);

		ImageView img = (ImageView)findViewById(R.id.count);
		mAni = (AnimationDrawable)img.getBackground();
		
		Button btn = (Button)findViewById(R.id.start);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				mAni.start();
			}
		});

		btn = (Button)findViewById(R.id.stop);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				mAni.stop();
			}
		});
	}
}
