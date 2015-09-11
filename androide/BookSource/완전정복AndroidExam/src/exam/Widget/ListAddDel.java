package exam.Widget;

import java.util.*;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class ListAddDel extends Activity {
	ArrayList<String> Items;
	ArrayAdapter<String> Adapter;
	ListView list;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_listadddel);

		Items = new ArrayList<String>();
		Items.add("First");
		Items.add("Second");
		Items.add("Third");

		Adapter = new ArrayAdapter<String>(this, android.R.layout.
				simple_list_item_single_choice, Items);
		list = (ListView)findViewById(R.id.list);
		list.setAdapter(Adapter);
		list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

		list.setOnItemClickListener(mItemClickListener);
		findViewById(R.id.add).setOnClickListener(mClickListener);
		findViewById(R.id.delete).setOnClickListener(mClickListener);
	}

	Button.OnClickListener mClickListener = new View.OnClickListener() {
		public void onClick(View v) {
			EditText ed = (EditText)findViewById(R.id.newitem);
			switch (v.getId()) {
			case R.id.add:
				String text = ed.getText().toString();
				if (text.length() != 0) {
					Items.add(text);
					ed.setText("");
					Adapter.notifyDataSetChanged();
				}
				break;
			case R.id.delete:
				int id;
				id=list.getCheckedItemPosition();
				if (id != ListView.INVALID_POSITION) {
					Items.remove(id);
					list.clearChoices();
					Adapter.notifyDataSetChanged();
				}
				break;
			}
		}
	};
	
	AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
		@SuppressWarnings("unchecked")
		public void onItemClick(AdapterView parent, View view, int position, long id) {
			String mes;
			mes = "Select Item = " + Items.get(position);
			Toast.makeText(ListAddDel.this,mes,Toast.LENGTH_SHORT).show();
		}
	};
}
