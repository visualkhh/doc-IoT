package hest.co.kr;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MyAlarm extends Activity {
	private Timer timer = new Timer();
	private DateFormat dtf = DateFormat.getDateTimeInstance();
	private TextView dateAndTime;
	private Calendar cal = Calendar.getInstance();
	DatePickerDialog.OnDateSetListener d = new OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, monthOfYear);
			cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			updateLabel();
		}
	};
	TimePickerDialog.OnTimeSetListener t = new OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
			cal.set(Calendar.MINUTE, minute);
			updateLabel();
		}
	};

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_alarm);
		Button btn_date = (Button) findViewById(R.id.btn_date);
		Button btn_time = (Button) findViewById(R.id.btn_time);
		dateAndTime = (TextView) findViewById(R.id.dateAndTime);
		updateLabel();
		btn_date.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				DatePickerDialog d1 = new DatePickerDialog(MyAlarm.this, d, cal
						.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal
						.get(Calendar.DAY_OF_MONTH));
				d1.show();
			}
		});
		btn_time.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				TimePickerDialog t1 = new TimePickerDialog(MyAlarm.this, t, cal
						.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
						true);
				t1.show();
			}
		});
	}

	private void updateLabel() {
		dateAndTime.setText(dtf.format(cal.getTime()));
		runTimer();
	}

	private void runTimer() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				notifyMe();
			}
		};
		timer.schedule(task, cal.getTime());
	}

	private int count = 0;
	private void notifyMe() {
		final NotificationManager mgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Notification note = new Notification(R.drawable.icon, "okgosu 메시지",
				System.currentTimeMillis());
		PendingIntent i = PendingIntent.getActivity(this, 0, new Intent(this,
				MyImageView.class), 0);
		note.setLatestEventInfo(this, "알림제목", "본문이오~", i);
		note.sound = Uri.parse("file:///sdcard/1.mp3");
		note.number = ++count;
		mgr.notify(12345, note);
	}
}
