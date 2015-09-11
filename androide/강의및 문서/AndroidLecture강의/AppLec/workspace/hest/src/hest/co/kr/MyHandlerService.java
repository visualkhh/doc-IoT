package hest.co.kr;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

public class MyHandlerService extends Service {
	private NotificationManager ntf;
	private boolean isRunning = false;
	private int noticeCount;

	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			Notification noti = new Notification(R.drawable.icon,
					(String) msg.obj, System.currentTimeMillis());
			PendingIntent i = PendingIntent.getActivity(MyHandlerService.this,
					0, new Intent("MyProdDBManager"), 0);
			noti.setLatestEventInfo(MyHandlerService.this, "okgosu 알림:"
					+ (String) msg.obj, "알림 메시지 본문 :" + (String) msg.obj, i);
			ntf.notify(noticeCount++, noti);
		}
	};

	@Override
	public void onStart(Intent intent, int startId) {
		Thread th = new Thread(new Runnable() {
			public void run() {
				while (isRunning) {
					try {
						Thread.sleep(5000);
						String obj = "[" + noticeCount + "] 번째 Service 알림:";
						handler.sendMessage(handler.obtainMessage(1, obj));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		isRunning = true;
		th.start();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		ntf = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		isRunning = false;
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
