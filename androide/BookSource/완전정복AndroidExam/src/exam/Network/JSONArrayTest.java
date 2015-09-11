package exam.Network;

import org.json.*;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class JSONArrayTest extends Activity {
	EditText mResult;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.network_domparser);

		mResult = (EditText)findViewById(R.id.result);

		Button btn = (Button)findViewById(R.id.parse);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				String Json = "[8,9,6,2,9]";
				try {
					int sum = 0;
					JSONArray ja = new JSONArray(Json);
					for (int i = 0; i < ja.length(); i++) {
						sum += ja.getInt(i);
					}
					mResult.setText("Sum = " + sum);
				} catch (JSONException e) {
					Toast.makeText(v.getContext(), e.getMessage(), 0).show();
				}
			}
		});
	}
}
