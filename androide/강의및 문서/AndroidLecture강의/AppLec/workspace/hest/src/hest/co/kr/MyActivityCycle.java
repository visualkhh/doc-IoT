package hest.co.kr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MyActivityCycle extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_activity_cycle);
		Button btn_go = (Button) findViewById(R.id.btn_go);
		Button btn_end = (Button) findViewById(R.id.btn_end);
		btn_go.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(MyActivityCycle.this, MyListView.class);
				startActivity(i);
			}
		});
		btn_end.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
	}

	@Override
	protected void onDestroy() {
		Toast.makeText(this, "액티비티 onDestroy", Toast.LENGTH_SHORT).show();
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		Toast.makeText(this, "액티비티 onPause", Toast.LENGTH_SHORT).show();
		super.onPause();
	}

	@Override
	protected void onRestart() {
		Toast.makeText(this, "액티비티 onRestart", Toast.LENGTH_SHORT).show();
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Toast.makeText(this, "액티비티 onResume", Toast.LENGTH_SHORT).show();
		super.onResume();
	}

}
