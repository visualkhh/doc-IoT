package exam.Data;

import java.io.*;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class SDCard extends Activity {
	EditText mEdit;
	String mSdPath;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.data_sdcard);

		mEdit = (EditText)findViewById(R.id.edittext);
		findViewById(R.id.test).setOnClickListener(mClickListener);
		findViewById(R.id.save).setOnClickListener(mClickListener);
		findViewById(R.id.load).setOnClickListener(mClickListener);

		String ext = Environment.getExternalStorageState();
		if (ext.equals(Environment.MEDIA_MOUNTED)) {
			mSdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
		} else {
			mSdPath = Environment.MEDIA_UNMOUNTED;
		}
	}

	Button.OnClickListener mClickListener = new View.OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.test:
				String rootdir = Environment.getRootDirectory().getAbsolutePath();
				String datadir = Environment.getDataDirectory().getAbsolutePath();
				String cachedir = Environment.getDownloadCacheDirectory().getAbsolutePath();
				mEdit.setText(String.format("ext = %s\nroot=%s\ndata=%s\ncache=%s", 
						mSdPath, rootdir, datadir, cachedir));
				break;
			case R.id.save:
				File dir = new File(mSdPath + "/dir");
				dir.mkdir();
				File file = new File(mSdPath + "/dir/file.txt");
				try {
					FileOutputStream fos = new FileOutputStream(file);
					String str = "This file exists in SDcard";
					fos.write(str.getBytes());
					fos.close();
					mEdit.setText("write success");
				} catch (FileNotFoundException e) {
					mEdit.setText("File Not Found." + e.getMessage());
				}
				catch (SecurityException e) {
					mEdit.setText("Security Exception");
				}
				catch (Exception e) {
					mEdit.setText(e.getMessage());
				}
				break;
			case R.id.load:
				try {
					FileInputStream fis = new FileInputStream(mSdPath + "/dir/file.txt");
					byte[] data = new byte[fis.available()];
					while (fis.read(data) != -1) {;}
					fis.close();
					mEdit.setText(new String(data));
				} catch (FileNotFoundException e) {
					mEdit.setText("File Not Found");
				}
				catch (Exception e) {;}
				break;
			}
		}
	};
}
