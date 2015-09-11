package hest.co.kr;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MyRawXML extends ListActivity {
	ArrayList<String> items = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DocumentBuilder builder;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputStream in = getResources().openRawResource(R.raw.word);
			Document doc = builder.parse(in);
			NodeList words = doc.getElementsByTagName("word");
			for (int i=0; i<words.getLength(); i++) {
				items.add(((Element)words.item(i)).getAttribute("value"));
			}
			setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



