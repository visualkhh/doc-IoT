package hest.co.kr;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MyTextStyle extends Activity {
	int tvStyle1;
	int tvStyle2;
	private String mytype = "sans";
	RadioGroup rdg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_text_style);
		final TextView tv1 = (TextView) findViewById(R.id.tv1);
		CheckBox cb1 = (CheckBox) findViewById(R.id.CheckBox01);
		CheckBox cb2 = (CheckBox) findViewById(R.id.CheckBox02);
		rdg = (RadioGroup) findViewById(R.id.rdg);
		cb1
				.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							tvStyle1 = Typeface.BOLD;
						} else {
							tvStyle1 = Typeface.NORMAL;
						}
						Typeface face = Typeface.create(mytype, tvStyle1
								| tvStyle2);
						tv1.setTypeface(face, tvStyle1 | tvStyle2);
					}
				});
		cb2
				.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							tvStyle2 = Typeface.ITALIC;
						} else {
							tvStyle2 = Typeface.NORMAL;
						}
						Typeface face = Typeface.create(mytype, tvStyle1
								| tvStyle2);
						tv1.setTypeface(face, tvStyle1 | tvStyle2);
					}
				});
		rdg
				.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						switch (checkedId) {
						case R.id.rb1:
							mytype = "sans";
							break;
						case R.id.rb2:
							mytype = "serif";
							break;
						case R.id.rb3:
							mytype = "monospace";
							break;
						}
						Typeface face = Typeface.create(mytype, 0);
						tv1.setTypeface(face);
					}
				});
		
	}
}
