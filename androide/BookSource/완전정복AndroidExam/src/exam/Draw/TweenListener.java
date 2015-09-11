package exam.Draw;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.animation.*;
import android.view.animation.Animation.*;
import android.widget.*;
import exam.AndroidExam.*;

public class TweenListener extends Activity {
	LinearLayout mLinear;
	Button mBtn;
	Animation mAni1;
	Animation mAni2;
	Animation mAni3;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.draw_tweenlistener);

		mLinear = (LinearLayout)findViewById(R.id.linear);

		mBtn = (Button)findViewById(R.id.start);
		mBtn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				mBtn.startAnimation(mAni1);
			}
		}); 

		mAni1 = AnimationUtils.loadAnimation(this, R.anim.rotate2);
		mAni2 = AnimationUtils.loadAnimation(this, R.anim.alpha2);
		mAni3 = AnimationUtils.loadAnimation(this, R.anim.scale2);

		mAni1.setAnimationListener(new AnimationListener() {
			public void onAnimationEnd(Animation animation) {
				mBtn.startAnimation(mAni2);
			}

			public void onAnimationRepeat(Animation animation) {;}
			public void onAnimationStart(Animation animation) {;}
		});

		mAni2.setAnimationListener(new AnimationListener() {
			public void onAnimationEnd(Animation animation) {
				mBtn.startAnimation(mAni3);
			}

			public void onAnimationRepeat(Animation animation) {;}
			public void onAnimationStart(Animation animation) {;}
		});

		mAni3.setAnimationListener(new AnimationListener() {
			public void onAnimationEnd(Animation animation) {
				Toast.makeText(TweenListener.this, "Animation End", 0).show();
			}

			public void onAnimationRepeat(Animation animation) {;}
			public void onAnimationStart(Animation animation) {;}
		});
	}
}