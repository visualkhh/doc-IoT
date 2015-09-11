package exam.thread;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

/* 메시지 전송
public class HandlerTest extends Activity {
	int mMainValue = 0;
	int mBackValue = 0;
	TextView mMainText;
	TextView mBackText;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thread_threadtest);

		mMainText = (TextView)findViewById(R.id.mainvalue);
		mBackText = (TextView)findViewById(R.id.backvalue);
		Button btn = (Button)findViewById(R.id.increase);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				mMainValue++;
				mMainText.setText("MainValue : " + mMainValue);
			}
		});

		BackThread thread = new BackThread();
		thread.setDaemon(true);
		thread.start();
	}

	class BackThread extends Thread {
		public void run() {
			while (true) {
				mBackValue++;
				mHandler.sendEmptyMessage(0);
				try { Thread.sleep(1000); } catch (InterruptedException e) {;}
			}
		}
	}

	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == 0) {
				mBackText.setText("BackValue : " + mBackValue);
			}
		}
	};
}
//*/

/* Runnable 객체 보내기
public class HandlerTest extends Activity {
	int mMainValue = 0;
	int mBackValue = 0;
	TextView mMainText;
	TextView mBackText;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thread_threadtest);

		mMainText = (TextView)findViewById(R.id.mainvalue);
		mBackText = (TextView)findViewById(R.id.backvalue);
		Button btn = (Button)findViewById(R.id.increase);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				mMainValue++;
				mMainText.setText("MainValue : " + mMainValue);
			}
		});

		BackThread thread = new BackThread();
		thread.setDaemon(true);
		thread.start();
	}

	class BackThread extends Thread {
		public void run() {
			while (true) {
				mBackValue++;
				mHandler.post(new Runnable() {
					public void run() {
						mBackText.setText("BackValue : " + mBackValue);
					}
				});
				try { Thread.sleep(1000); } catch (InterruptedException e) {;}
			}
		}
	}

	Handler mHandler = new Handler();
}
//*/

/* 외부 스레드
public class HandlerTest extends Activity {
	int mMainValue = 0;
	TextView mMainText;
	TextView mBackText;
	BackThread mThread;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thread_threadtest);

		mMainText = (TextView)findViewById(R.id.mainvalue);
		mBackText = (TextView)findViewById(R.id.backvalue);
		Button btn = (Button)findViewById(R.id.increase);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				mMainValue++;
				mMainText.setText("MainValue : " + mMainValue);
			}
		});		
		mThread = new BackThread(mHandler);
		mThread.setDaemon(true);
		mThread.start();
	}

	Handler mHandler = new Handler() {
    	public void handleMessage(Message msg) {
    		if (msg.what == 0) {
				mBackText.setText("BackValue : " + msg.arg1);
    		}
    	}
    };
}

class BackThread extends Thread {
	int mBackValue = 0;
	Handler mHandler;

	BackThread(Handler handler) {
		mHandler = handler;
	}

	public void run() {
		while (true) {
			mBackValue++;
			Message msg = new Message();
			msg.what = 0;
			msg.arg1 = mBackValue;
			mHandler.sendMessage(msg);
			try { Thread.sleep(1000); } catch (InterruptedException e) {;}
		}
	}
}
//*/

//* 외부 스레드 - obtain으로 메시지 얻기
public class HandlerTest extends Activity {
	int mMainValue = 0;
	TextView mMainText;
	TextView mBackText;
	BackThread mThread;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thread_threadtest);

		mMainText = (TextView)findViewById(R.id.mainvalue);
		mBackText = (TextView)findViewById(R.id.backvalue);
		Button btn = (Button)findViewById(R.id.increase);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				mMainValue++;
				mMainText.setText("MainValue : " + mMainValue);
			}
		});		
		mThread = new BackThread(mHandler);
		mThread.setDaemon(true);
		mThread.start();
	}

	Handler mHandler = new Handler() {
    	public void handleMessage(Message msg) {
    		if (msg.what == 0) {
				mBackText.setText("BackValue : " + msg.arg1);
    		}
    	}
    };
}

class BackThread extends Thread {
	int mBackValue = 0;
	Handler mHandler;

	BackThread(Handler handler) {
		mHandler = handler;
	}

	public void run() {
		while (true) {
			mBackValue++;
			Message msg = Message.obtain(mHandler, 0, mBackValue, 0);
			mHandler.sendMessage(msg);
			try { Thread.sleep(1000); } catch (InterruptedException e) {;}
		}
	}
}
//*/
