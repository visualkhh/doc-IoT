package exam.Widget;

import android.app.*;
import android.content.res.*;
import android.os.*;
import android.widget.*;
import exam.AndroidExam.*;

public class ReadResource extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_readresource);

		Resources res = getResources();
		
		TextView text = (TextView)findViewById(R.id.text);
		String str = res.getString(R.string.textstr);
		text.setText(str);
		//text.setText(R.string.textstr);
		int textcolor = res.getColor(R.color.textcolor);
		text.setTextColor(textcolor);
		//text.setTextColor(R.color.textcolor);
		float textsize = res.getDimension(R.dimen.textsize);
		text.setTextSize(textsize);
		//text.setTextSize(R.dimen.textsize);
	}
}