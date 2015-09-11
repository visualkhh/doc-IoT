package exam.Network;

import android.app.*;
import android.net.*;
import android.os.*;
import android.widget.*;
import exam.AndroidExam.*;

public class ConMgr extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.network_conmgr);

		EditText result = (EditText)findViewById(R.id.result);
		String sResult = "";
		ConnectivityManager mgr = (ConnectivityManager)
			getSystemService(CONNECTIVITY_SERVICE);
		
		NetworkInfo[] ani = mgr.getAllNetworkInfo();
		for (NetworkInfo n : ani) {
			sResult += (n.toString() + "\n\n");
		}

		NetworkInfo ni = mgr.getActiveNetworkInfo();
		sResult += ("Active : \n" + ni.toString() + "\n");
		result.setText(sResult);
	}
}

