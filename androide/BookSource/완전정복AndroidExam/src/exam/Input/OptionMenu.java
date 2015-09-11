package exam.Input;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class OptionMenu extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView MyText = new TextView(this);
		MyText.setText("메뉴 키를 누르세요.");
		setContentView(MyText);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuItem item=menu.add(0,1,0,"짜장");
		item.setIcon(R.drawable.icon);
		item.setAlphabeticShortcut('a');
		//menu.add(0,1,0,"짜장").setIcon(R.drawable.icon).setAlphabeticShortcut('a');
		menu.add(0,2,0,"짬뽕").setIcon(R.drawable.icon);
		SubMenu etc = menu.addSubMenu("기타");
		etc.add(0,3,0,"우동");
		etc.add(0,4,0,"만두");

		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Toast.makeText(this,"짜장은 달콤해",Toast.LENGTH_SHORT).show();
			return true;
		case 2:
			Toast.makeText(this,"짬뽕은 매워",Toast.LENGTH_SHORT).show();
			return true;
		case 3:
			Toast.makeText(this,"우동은 시원해",Toast.LENGTH_SHORT).show();
			return true;
		case 4:
			Toast.makeText(this,"만두는 공짜야",Toast.LENGTH_SHORT).show();
			return true;
		}
		return false;
	}
}
