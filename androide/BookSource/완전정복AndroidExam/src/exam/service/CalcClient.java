package exam.service;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class CalcClient extends Activity {
	ICalc mCalc;
	TextView mResult;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_calcclient);
		
		mResult = (TextView)findViewById(R.id.result);
		
		Button btnLCM = (Button)findViewById(R.id.btnLCM);
		btnLCM.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				int LCM = 0;
				try {
					LCM = mCalc.getLCM(6, 8);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				mResult.setText("6과 8의 최소 공배수 = " + LCM);
			}
		});

		Button btnPrime = (Button)findViewById(R.id.btnPrime);
		btnPrime.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				boolean prime = false;
				try {
					prime = mCalc.isPrime(7);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				mResult.setText("7의 소수 여부 = " + prime);
			}
		});
	}
	
	public void onResume() {
		super.onResume();
		Intent intent = new Intent(this, CalcService.class);
		bindService(intent, srvConn, BIND_AUTO_CREATE);
	}	

	public void onPause() {
		super.onPause();        
		unbindService(srvConn);
	}

	ServiceConnection srvConn = new ServiceConnection() {
		public void onServiceConnected(ComponentName className, IBinder binder) {
			mCalc = ICalc.Stub.asInterface(binder);
		}

		public void onServiceDisconnected(ComponentName className) {
			mCalc = null;
		}
	};
}

