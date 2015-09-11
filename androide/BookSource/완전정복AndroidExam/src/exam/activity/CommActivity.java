package exam.activity;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class CommActivity extends Activity {
	TextView mText;
	final static int ACT_EDIT = 0;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commactivity);

		mText = (TextView)findViewById(R.id.text);

		Button btnEdit=(Button)findViewById(R.id.edit);
        btnEdit.setOnClickListener(new Button.OnClickListener() {
        	public void onClick(View v) {
        		Intent intent = new Intent(CommActivity.this, ActEdit.class);
        		intent.putExtra("TextIn", mText.getText().toString());
        		startActivityForResult(intent,ACT_EDIT);
        	}
        });
    }
    
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
    	switch (requestCode) {
    	case ACT_EDIT:
    		if (resultCode == RESULT_OK) {
    	        mText.setText(data.getStringExtra("TextOut"));
    		}
    		break;
    	}
    }
}
