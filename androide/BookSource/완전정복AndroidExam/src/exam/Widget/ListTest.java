package exam.Widget;

import java.util.*;

import android.app.*;
import android.os.*;
import android.widget.*;
import exam.AndroidExam.*;

public class ListTest extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_listtest);

		//* 데이터 원본 준비
		ArrayList<String> arGeneral = new ArrayList<String>();
		arGeneral.add("김유신");
		arGeneral.add("이순신");
		arGeneral.add("강감찬");
		arGeneral.add("을지문덕");
		//*/
		
		/* 배열로 준비
		String[] arGeneral = {"김유신", "이순신", "강감찬", "을지문덕"};
		//*/

		// 어댑터 준비
		ArrayAdapter<String> Adapter;
		Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arGeneral);

		// 어댑터 연결
		ListView list = (ListView)findViewById(R.id.list);
		list.setAdapter(Adapter);
	}
}
