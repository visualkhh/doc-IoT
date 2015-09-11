package exam.Widget;

import android.app.*;
import android.os.*;
import android.widget.*;
import exam.AndroidExam.*;

public class SeekBarTest extends Activity {
	SeekBar mSeekBar;
	TextView mVolume;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_seekbartest);

		mSeekBar = (SeekBar)findViewById(R.id.seekbar);
		mVolume = (TextView)findViewById(R.id.volume);

		mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				mVolume.setText("Now Volume : " + progress);
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
			}
		});

	}
}