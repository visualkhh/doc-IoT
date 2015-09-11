package exam.Output;

import android.app.*;
import android.content.*;
import android.media.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class MessageBeep extends Activity {
	Beeper DingDong;
	Beeper Ddock;

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.output_messagebeep);
		
		DingDong = new Beeper(this, R.raw.dingdong);
		Ddock = new Beeper(this, R.raw.ddok);

		findViewById(R.id.direct1).setOnClickListener(mClickListener);
		findViewById(R.id.direct2).setOnClickListener(mClickListener);
		findViewById(R.id.prepare1).setOnClickListener(mClickListener);
		findViewById(R.id.prepare2).setOnClickListener(mClickListener);
	}

	Button.OnClickListener mClickListener = new Button.OnClickListener() {
		public void onClick(View v) {
			MediaPlayer player;
			switch (v.getId()) {
			case R.id.direct1:
				player = MediaPlayer.create(MessageBeep.this, R.raw.dingdong);
				player.start();
				break;
			case R.id.direct2:
				player = MediaPlayer.create(MessageBeep.this, R.raw.ddok);
				player.start();
				break;
			case R.id.prepare1:
				DingDong.play();
				break;
			case R.id.prepare2:
				Ddock.play();
				break;
			}
		}
	};
}

class Beeper {
	MediaPlayer player;
	Beeper(Context context, int id) {
		player = MediaPlayer.create(context, id);
	}

	void play() {
		player.seekTo(0);
		player.start();
	}
}
