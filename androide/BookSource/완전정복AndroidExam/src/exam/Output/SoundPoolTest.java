package exam.Output;

import android.app.*;
import android.media.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class SoundPoolTest extends Activity {
	SoundPool pool;
	int ddok;

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.output_soundpooltest);
		
		pool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		ddok = pool.load(this, R.raw.ddok, 1);

		findViewById(R.id.play1).setOnClickListener(mClickListener);
		findViewById(R.id.play2).setOnClickListener(mClickListener);
		findViewById(R.id.play3).setOnClickListener(mClickListener);
		findViewById(R.id.play4).setOnClickListener(mClickListener);
	}

	Button.OnClickListener mClickListener = new Button.OnClickListener() {
		public void onClick(View v) {
			MediaPlayer player;
			switch (v.getId()) {
			case R.id.play1:
				pool.play(ddok, 1, 1, 0, 0, 1);
				break;
			case R.id.play2:
				pool.play(ddok, 0.5f, 0.5f, 0, 0, 1);
				break;
			case R.id.play3:
				pool.play(ddok, 1, 1, 0, 2, 1);
				break;
			case R.id.play4:
				pool.play(ddok, 1, 1, 0, 0, 0.5f);
				break;
			}
		}
	};
}
	
