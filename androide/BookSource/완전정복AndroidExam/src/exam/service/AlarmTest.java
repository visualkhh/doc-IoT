package exam.service;

import java.util.*;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class AlarmTest extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_alarmtest);

		Button btn;
		btn = (Button)findViewById(R.id.onetime);
		btn.setOnClickListener(mClick);
		btn = (Button)findViewById(R.id.repeat);
		btn.setOnClickListener(mClick);
		btn = (Button)findViewById(R.id.stop);
		btn.setOnClickListener(mClick);
	}

	Button.OnClickListener mClick = new Button.OnClickListener() {
		public void onClick(View v) {
			AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
			Intent intent;
			PendingIntent sender;

			switch (v.getId()) {
			case R.id.onetime:
				// 예약에 의해 호출될 BR 지정
				intent = new Intent(AlarmTest.this, AlarmReceiver.class);
				sender = PendingIntent.getBroadcast(AlarmTest.this, 0, intent, 0);

				// 알람 시간. 10초후
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(System.currentTimeMillis());
				calendar.add(Calendar.SECOND, 10);

				// 알람 등록
				am.set(AlarmManager.RTC, calendar.getTimeInMillis(), sender);
				break;
			case R.id.repeat:
			case R.id.stop:
				intent = new Intent(AlarmTest.this, DisplayScore.class);
				sender = PendingIntent.getBroadcast(AlarmTest.this, 0, intent, 0);

				// 8초당 한번 알람 등록
				if (v.getId() == R.id.repeat) {
					am.setRepeating(AlarmManager.ELAPSED_REALTIME, 
							SystemClock.elapsedRealtime(), 
							6000, sender);
				} else {
					am.cancel(sender);
				}
				break;
			}
		}
	};
}
