package hest.co.kr;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyBindingDemo extends Activity {
	TextView mCallbackText;
	private boolean isBinded;
	IMyRemoteService myRemoteService = null;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_binding_demo);
		mCallbackText = (TextView) findViewById(R.id.callback);
		mCallbackText.setText("아직 서비스에 바인딩 안됨");
		Button button = (Button) findViewById(R.id.bind);
		button.setOnClickListener(mBindListener);
		button = (Button) findViewById(R.id.unbind);
		button.setOnClickListener(mUnbindListener);
		Button call_btn = (Button) findViewById(R.id.call);
		call_btn.setOnClickListener(mCalllListener);
	}

	private OnClickListener mBindListener = new OnClickListener() {
		public void onClick(View v) {
			isBinded = true;
			// startService(new Intent("MyBindingService"));
			bindService(new Intent("MyBindingService"), myServiceConnection,
					Context.BIND_AUTO_CREATE);
			mCallbackText.setText("Binding.....");
		}
	};
	private OnClickListener mUnbindListener = new OnClickListener() {
		public void onClick(View v) {
			if (isBinded) {
				// stopService(new Intent(" MyBindingService"));
				unbindService(myServiceConnection);
				isBinded = false;
				mCallbackText.setText("Unbinding....");
			}
		}
	};
	private ServiceConnection myServiceConnection = new ServiceConnection() {
		public void onServiceConnected(ComponentName name, IBinder service) {
			myRemoteService = IMyRemoteService.Stub.asInterface(service);
			try {
				String msg = myRemoteService.getMyRemoteMsg();
				Toast.makeText(MyBindingDemo.this, msg, Toast.LENGTH_SHORT)
						.show();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}

		public void onServiceDisconnected(ComponentName name) {
			myServiceConnection = null;
			mCallbackText.setText("Disconnected.");
			Toast.makeText(MyBindingDemo.this, "Remote Service disconnected",
					Toast.LENGTH_SHORT).show();
		}
	};

	private OnClickListener mCalllListener = new OnClickListener() {
		public void onClick(View v) {
			String res = null;
			try {
				res = myRemoteService.showMyRemoteMsg("하하하하하");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			mCallbackText.setText("myRemoteService.showMyRemoteMsg 호출결과: "
					+ res);
		}
	};
}
