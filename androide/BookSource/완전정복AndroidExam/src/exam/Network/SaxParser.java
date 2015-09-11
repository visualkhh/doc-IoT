package exam.Network;

import java.io.*;

import javax.xml.parsers.*;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class SaxParser extends Activity {
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
	
				try {
					SAXParserFactory factory = SAXParserFactory.newInstance();
					SAXParser parser = factory.newSAXParser();
					XMLReader reader = parser.getXMLReader();
					SaxHandler handler = new SaxHandler();
					reader.setContentHandler(handler);
					InputStream istream = new ByteArrayInputStream(xml.getBytes("utf-8"));
					reader.parse(new InputSource(istream));
					mResult.setText("주문 항목 : " + handler.item);
				}
				catch (Exception e) {
					Toast.makeText(v.getContext(), e.getMessage(), 0).show();
				}
			}
		});
	}

	class SaxHandler extends DefaultHandler {
		boolean initem = false;
		StringBuilder item = new StringBuilder();

		public void startDocument () {}
		public void endDocument() {}
		
		public void startElement(String uri, String localName, String qName, Attributes atts) {
			if (localName.equals("item")) {
				initem = true;
			}
		}
		
		public void endElement(String uri, String localName, String qName) {}

		public void characters(char[] chars, int start, int length) {
			if (initem) {
				item.append(chars, start, length);
				initem = false;
			}
		}
	};
}