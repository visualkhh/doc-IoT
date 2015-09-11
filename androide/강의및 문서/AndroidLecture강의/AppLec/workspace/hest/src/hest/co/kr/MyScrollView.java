package hest.co.kr;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyScrollView extends Activity {
	LinearLayout layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_scroll_view);
		layout = (LinearLayout)findViewById(R.id.LinearLayout01);
		createWidgets(); // 버튼을 동적으로 생성
	}
	
	private void createWidgets() {
		for(int i=0; i<15; i++) {
			TextView tv = new TextView(this);
			tv.setText("TextView: " + i);
			layout.addView(tv);
			Button btn = new Button(this);
			btn.setText("버튼:" + i);
			btn.setTextColor(Color.YELLOW);
			LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT
			);
			layout.addView(btn, p);
		}
	}
}










