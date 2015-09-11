package exam.Draw;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.animation.*;
import android.widget.*;
import exam.AndroidExam.*;

public class Tween extends Activity {
	LinearLayout mLinear;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.draw_tween);

		mLinear = (LinearLayout)findViewById(R.id.linear);
		findViewById(R.id.translate).setOnClickListener(mClickListener);
		findViewById(R.id.rotate).setOnClickListener(mClickListener);
		findViewById(R.id.scale).setOnClickListener(mClickListener);
		findViewById(R.id.alpha).setOnClickListener(mClickListener);
		findViewById(R.id.set).setOnClickListener(mClickListener);
	}
	
	Button.OnClickListener mClickListener = new View.OnClickListener() {
		public void onClick(View v) {
			Animation ani = null;
			switch (v.getId()) {
			case R.id.translate:
				ani = AnimationUtils.loadAnimation(Tween.this, R.anim.translate);
				break;
			case R.id.rotate:
				ani = AnimationUtils.loadAnimation(Tween.this, R.anim.rotate);
				break;
			case R.id.scale:
				ani = AnimationUtils.loadAnimation(Tween.this, R.anim.scale);
				break;
			case R.id.alpha:
				ani = AnimationUtils.loadAnimation(Tween.this, R.anim.alpha);
				break;
			case R.id.set:
				ani = AnimationUtils.loadAnimation(Tween.this, R.anim.set);
				break;
			}
			mLinear.startAnimation(ani);
		}
	};	
}
