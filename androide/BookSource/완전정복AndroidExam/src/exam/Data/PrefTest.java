package exam.Data;

import android.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;
import exam.AndroidExam.*;

public class PrefTest extends Activity {
	TextView textName;
	TextView textStNum;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.data_preftest);

		textName = (TextView)findViewById(R.id.name);
		textStNum = (TextView)findViewById(R.id.stnum);

		SharedPreferences pref = getSharedPreferences("PrefTest",0);
		String Name = pref.getString("Name", "이름없음");
		textName.setText(Name);

		int StNum = pref.getInt("StNum",20101234);
		textStNum.setText("" + StNum);
	}

	public void onPause() {
		super.onPause();

		SharedPreferences pref = getSharedPreferences("PrefTest",0);
		SharedPreferences.Editor edit = pref.edit();

		String Name = textName.getText().toString();
		int StNum = 0;
		try {
			StNum = Integer.parseInt(textStNum.getText().toString());
		}
		catch (Exception e) {}

		edit.putString("Name", Name);
		edit.putInt("StNum", StNum);

		edit.commit();
	}
}
