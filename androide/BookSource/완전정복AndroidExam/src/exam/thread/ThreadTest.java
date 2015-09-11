package exam.thread;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

//* Thread 객체 사용
public class ThreadTest extends Activity {
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
				mBackText.setText("BackValue : " + mBackValue);
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
				//mBackText.setText("BackValue : " + mBackValue);
				try { Thread.sleep(1000); } catch (InterruptedException e) {;}
			}
		}
	}
}
//*/

/* Runnable 객체 사용하기
public class ThreadTest extends Activity {
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
				mBackText.setText("BackValue : " + mBackValue);
			}
		});
		
		BackRunnable runnable = new BackRunnable();
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
	}
	
	class BackRunnable implements Runnable {
		public void run() {
			while (true) {
				mBackValue++;
				try { Thread.sleep(1000); } catch (InterruptedException e) {;}
			}
		}
	}
}
//*/


