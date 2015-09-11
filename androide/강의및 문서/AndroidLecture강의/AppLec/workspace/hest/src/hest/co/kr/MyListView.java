package hest.co.kr;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyListView extends ListActivity {
	TextView itemSelected;
	String[] items = { "사과", "바나나", "포도", "딸기", "메론", "수박" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_list_view);
		itemSelected = (TextView) findViewById(R.id.listItem);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				items);
		setListAdapter(adapter);
		registerForContextMenu(getListView());
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		itemSelected.setText(items[position]);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		createMyMenu(menu);
	}

	private void createMyMenu(Menu menu) {
		//menu.add(0, 0, 0, "Menu One")
		menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "Menu One");
		//menu.add(0, 1, 0, "Menu Two")
		menu.add(Menu.NONE, Menu.FIRST + 1, Menu.NONE, "Menu Two");
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		return (myContextMenuChoice(item)||super.onContextItemSelected(item));
	}
	
	private boolean myContextMenuChoice(MenuItem item) {
		//Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
		//Toast toast = Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT);
		Toast toast = new Toast(this);
		LayoutInflater inflater = getLayoutInflater();
		toast.setView(inflater.inflate(R.layout.my_image_view, null));
		toast.setGravity(Gravity.TOP, 0, 0);
		toast.show();
		return true;
	}	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		new MenuInflater(getApplication()).inflate(R.menu.title_icon, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return (myContextMenuChoice(item)||super.onOptionsItemSelected(item));
	}
}








