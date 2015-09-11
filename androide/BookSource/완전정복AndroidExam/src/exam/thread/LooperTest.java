package exam.thread;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class LooperTest extends Activity {
	int mMainValue = 0;
	TextView mMainText;
	TextView mBackText;
	EditText mNumEdit;
	CalcThread mThread;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thread_loopertest);

		mMainText = (TextView)findViewById(R.id.mainvalue);
		mBackText = (TextView)findViewById(R.id.backvalue);
		mNumEdit = (EditText)findViewById(R.id.number);

		Button btn = (Button)findViewById(R.id.increase);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				mMainValue++;
				mMainText.setText("MainValue : " + mMainValue);
			}
		});		

		btn = (Button)findViewById(R.id.square);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Message msg = Message.obtain();
				msg.what = 0;
				msg.arg1 = Integer.parseInt(mNumEdit.getText().toString());
				mThread.mBackHandler.sendMessage(msg);
			}
		});	
		
		btn = (Button)findViewById(R.id.root);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Message msg = Message.obtain();
				msg.what = 1;
				msg.arg1 = Integer.parseInt(mNumEdit.getText().toString());
				mThread.mBackHandler.sendMessage(msg);
			}
		});	
		mThread = new CalcThread(mHandler);
		mThread.setDaemon(true);
		mThread.start();
	}

	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				mBackText.setText("Square Result : " + msg.arg1);
				break;
			case 1:
				mBackText.setText("Root Result : " + ((Double)msg.obj).doubleValue());
				break;
			}
		}
	};
}

class CalcThread extends Thread {
	Handler mMainHandler;

	CalcThread(Handler handler) {
		mMainHandler = handler;
	}

	public void run() {
		Looper.prepare();
		Looper.loop();
	}

	public Handler mBackHandler = new Handler() {
		public void handleMessage(Message msg) {
			Message retmsg = Message.obtain();
			switch (msg.what) {
			case 0:
				try { Thread.sleep(100); } catch (InterruptedException e) {;}
				retmsg.what = 0;
				retmsg.arg1 = msg.arg1 * msg.arg1;
				break;
			case 1:
				try { Thread.sleep(100); } catch (InterruptedException e) {;}
				retmsg.what = 1;
				retmsg.obj = new Double(Math.sqrt((double)msg.arg1));
				break;
			}
		    mMainHandler.sendMessage(retmsg);
		}
	};
}
