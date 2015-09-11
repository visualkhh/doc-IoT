package exam.service;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.RemoteViews.*;
import exam.AndroidExam.*;

public class CustomNotiView extends Activity {
	static final int NAPNOTI = 1;
    NotificationManager mNotiManager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_napalarm);
        mNotiManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        
        Button btn = (Button)findViewById(R.id.start);
        btn.setOnClickListener(new Button.OnClickListener() {
        	public void onClick(View v) {
        		Toast.makeText(CustomNotiView.this, "안녕히 주무세요", 0).show();
        		v.postDelayed(new Runnable() {
					public void run() {
		    			Notification noti = new Notification(R.drawable.napalarm,
		    					"일어나세요",System.currentTimeMillis());
		    			noti.defaults |= Notification.DEFAULT_SOUND;
		    			noti.flags |= Notification.FLAG_INSISTENT;
		    			
		    			Intent intent = new Intent(CustomNotiView.this,NapEnd.class);
		    			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		    			PendingIntent content = PendingIntent.getActivity(
		    					CustomNotiView.this, 0, intent, 0);
		    			
		    			RemoteViews napView = new RemoteViews(getPackageName(), R.layout.service_customnotiview);
		    			noti.contentView = napView;
		    			noti.contentIntent = content;
		    			
		    			// 통지 출력
		    			mNotiManager.notify(NapAlarm.NAPNOTI, noti);
					}
        		}, 5 * 1000);
        	}
        });        
    }
}