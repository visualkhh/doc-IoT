package exam.Network;

import java.io.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class DomParser extends Activity {
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
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = factory.newDocumentBuilder();
					InputStream istream = new ByteArrayInputStream(xml.getBytes("utf-8"));
					Document doc = builder.parse(istream);
		
					Element order = doc.getDocumentElement();
					NodeList items = order.getElementsByTagName("item");
					Node item = items.item(0);
					Node text = item.getFirstChild();
					String ItemName = text.getNodeValue();
					mResult.setText("주문 항목 : " + ItemName);
				} 
				catch (Exception e) {
					Toast.makeText(v.getContext(), e.getMessage(), 0).show();
				}
			}
		});
	}
}
