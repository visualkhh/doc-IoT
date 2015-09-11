package exam.thread;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class LongTime5 extends Activity {
	int mValue;
	TextView mText;
	ProgressDialog mProgress;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thread_longtime);

		mText = (TextView)findViewById(R.id.text);
		Button btnUpdate = (Button)findViewById(R.id.update);
		btnUpdate.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				new AccumulateTask().execute(100);
			}
		});
	}
	
	class AccumulateTask extends AsyncTask<Integer, Integer, Integer> {
		protected void onPreExecute() {
			mValue = 0;
			mProgress = new ProgressDialog(LongTime5.this);
			mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			mProgress.setTitle("Updating");
			mProgress.setMessage("Wait...");
			mProgress.setCancelable(false);
			mProgress.setProgress(0);
			mProgress.setButton("Cancel", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					cancel(true);
				}
			});
			mProgress.show();
		}
		
		protected Integer doInBackground(Integer... arg0) {
			while (isCancelled() == false) { 
				mValue++;
				if (mValue <= 100) {
					publishProgress(mValue);
				} else {
					break;
				}
				try { Thread.sleep(50); } catch (InterruptedException e) {;}
			}
			return mValue;
		}
		
	    protected void onProgressUpdate(Integer... progress) {         
	    	mProgress.setProgress(progress[0]);     
	    	mText.setText(Integer.toString(progress[0]));     
	    }
	    
	    protected void onPostExecute(Integer result) { 
	    	mProgress.dismiss();
	    }
	    
	    protected void onCancelled() {
			mProgress.dismiss();
	    }
	}
}

