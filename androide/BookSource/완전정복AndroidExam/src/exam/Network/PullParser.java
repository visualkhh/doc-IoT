package exam.Network;

import java.io.*;

import org.xmlpull.v1.*;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class PullParser extends Activity {
	EditText mResult;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.network_domparser);

		mResult = (EditText)findViewById(R.id.result);

		Button btn = (Button)findViewById(R.id.parse);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
				"<order><item>Mouse</item></order>";
				boolean initem = false;
				String ItemName = "";

				try {
					XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
					XmlPullParser parser = factory.newPullParser();
					parser.setInput(new StringReader(xml));
					
					int eventType = parser.getEventType();
					while (eventType != XmlPullParser.END_DOCUMENT) {
						switch (eventType) {
						case XmlPullParser.START_DOCUMENT:
							break;
						case XmlPullParser.END_DOCUMENT:
							break;
						case XmlPullParser.START_TAG:
							if (parser.getName().equals("item")) {
								initem = true;
							}
							break;
						case XmlPullParser.END_TAG:
							break;
						case XmlPullParser.TEXT:
							if (initem) {
								ItemName = parser.getText();
								initem = false;
							}
							break;
						}
						eventType = parser.next();
					}
					mResult.setText("주문 항목 : " + ItemName);
				}
				catch (Exception e) {
					Toast.makeText(v.getContext(), e.getMessage(), 0).show();
				}
			}
		});
	}
}