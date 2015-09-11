
package exam.Data;

import java.io.*;

import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;
import android.view.*;

//Android log write utility class.
//author : winapi@winapi.co.kr
//usage : 1.call init(this) at onCreate of main activity
//      2.call TextLog.o(some string) whenever you need
//      3.call TextLog.ViewLog() to inspect log
//      you can change mFile, mDir, mTag by direct assigning if need.
public class TextLog {
	static Context mMain;
	static String mFile;
	static String mTag;
	static int mDir;
	static final int DIR_SELF = 1;
	static final int LOG_SDCARD = 2;
	static final int LOG_SYSTEM = 4;
	static boolean mHaveSD;
	static String mSDPath;

	// init default setting.
	public static void init(Context main) {
		mMain = main;
		mFile = "andlog.txt";
		mTag = "textlog";
		mDir = DIR_SELF | LOG_SDCARD;
		mHaveSD = Environment.getExternalStorageState()
		.equals(Environment.MEDIA_MOUNTED);
		if (mHaveSD) {
			mSDPath = Environment.getExternalStorageDirectory()
			.getAbsolutePath();
		}
		o("start time:" + System.currentTimeMillis());
	}

	// delete log file neatly.
	public static void reset() {
		if ((mDir & DIR_SELF) != 0) {
			mMain.deleteFile(mFile);
		}
		if ((mDir & LOG_SDCARD) != 0 && mHaveSD) {
			File file = new File(mSDPath + "/" + mFile);
			file.delete();
		}
		o("reset time:" + System.currentTimeMillis());
	}

	// write string to log.
	public static void o(String text) {
		// null test is needed because some exception's getMessage() return null
		if (text == null) {
			return;
		}

		if ((mDir & DIR_SELF) != 0) {
			FileOutputStream fout = null;
			try {
				fout = mMain.openFileOutput(mFile, Context.MODE_APPEND);
				if (fout != null) {
					fout.write(text.getBytes());
					fout.write("\n".getBytes());
				}
			} 
			catch (Exception ex) {
				// silent fail
			}
			finally {
				try {
					if(fout != null) fout.close();
				}
				catch (Exception e) { ; }
			}
		}

		if ((mDir & LOG_SDCARD) != 0 && mHaveSD) {
			File file = new File(mSDPath + "/" + mFile);
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(file, true);
				if (fos != null) {
					fos.write(text.getBytes());
					fos.write("\n".getBytes());
				}
			} 
			catch (Exception e) {
				// silent fail
			}
			finally {
				try {
					if(fos != null) fos.close();
				}
				catch (Exception e) { ; }
			}
		}

		if ((mDir & LOG_SYSTEM) != 0) {
			Log.d(mTag, text);
		}

	}

	// always view self log file only. you should inspect log in SDcard 
	// using external program. for example file explorer or terminal
	public static void ViewLog() {
		String path;
		int ch;

		path = mMain.getFileStreamPath(mFile).toString();

		StringBuilder Result = new StringBuilder();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(path));
			if (in != null) {
				for (;;) {
					ch = in.read();
					if (ch == -1) break;
					Result.append((char)ch);
				}
			}
		}
		catch (Exception e) {
			Result.append("log file not found");
		}
		finally {
			try {
				if(in != null) in.close();
			}
			catch (Exception e) { ; }
		}

		new AlertDialog.Builder(mMain)
		.setMessage(Result.toString())
		.setTitle("Log")
		.setPositiveButton("OK", null)
		.show();        
	}

	public static void addMenu(Menu menu) {
		menu.add(0,101092+1,0,"ViewLog");
		menu.add(0,101092+2,0,"ResetLog");
	}

	public static boolean execMenu(MenuItem item) {
		switch (item.getItemId()) {
		case 101092+1:
			ViewLog();
			return true;
		case 101092+2:
			reset();
			return true;
		}
		return false;
	}
}

// wrapper class for internal package. 
// call shortly lg.o() instead of TextLog.o() 
class lg {
	public static void o(String text) {
		TextLog.o(text);
	}
}