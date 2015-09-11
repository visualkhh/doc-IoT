package exam.Widget;

import android.app.*;
import android.graphics.drawable.*;
import android.os.*;
import android.widget.*;
import exam.AndroidExam.*;

public class ListAttr extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_listtest);

		ArrayAdapter<CharSequence> Adapter;
		Adapter = ArrayAdapter.createFromResource(this, R.array.country,
				android.R.layout.simple_list_item_1);

		ListView list = (ListView)findViewById(R.id.list);
		list.setAdapter(Adapter);
		
		list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		list.setDivider(new ColorDrawable(0xffffff00));
		list.setDividerHeight(5);
	}
}
