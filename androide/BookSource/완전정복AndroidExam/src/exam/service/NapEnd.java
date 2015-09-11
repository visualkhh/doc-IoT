package exam.service;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class NapEnd extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_napend);

        NotificationManager NM = (NotificationManager) 
        	getSystemService(NOTIFICATION_SERVICE);
        NM.cancel(NapAlarm.NAPNOTI);

        Button btn = (Button)findViewById(R.id.end);
        btn.setOnClickListener(new Button.OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
        });        
    }
}
