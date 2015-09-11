package hest.co.kr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class MyReadBin extends Activity {
	final static String BIN_FILE_NAME = "my_bin.txt";
	EditText edit_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_read_bin);
		edit_text = (EditText) findViewById(R.id.edit_text);
	}

	@Override
	protected void onResume() {
		super.onResume();
		try {
			InputStream in = openFileInput(BIN_FILE_NAME);
			InputStreamReader ins = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(ins);
			String str;
			StringBuffer buf = new StringBuffer();
			while ((str = reader.readLine()) != null) {
				buf.append(str + "\n");
			}
			in.close();
			edit_text.setText(buf.toString());
		} catch (IOException e) {
			// throw new RuntimeException(e);
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		try {
			OutputStreamWriter out = new OutputStreamWriter(openFileOutput(
					BIN_FILE_NAME, 0));
			out.write(edit_text.getText().toString());
			out.close();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

}
