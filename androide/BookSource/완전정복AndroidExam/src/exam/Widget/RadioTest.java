package exam.Widget;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.widget.*;
import exam.AndroidExam.*;

public class RadioTest extends Activity implements RadioGroup.OnCheckedChangeListener,
CompoundButton.OnCheckedChangeListener {
	private ToggleButton mTogBtn;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_radiotest);

		mTogBtn = (ToggleButton)findViewById(R.id.MyToggle);

		RadioGroup ColGroup = (RadioGroup)findViewById(R.id.ColorGroup);
		ColGroup.setOnCheckedChangeListener(this);

		CheckBox chkBig = (CheckBox)findViewById(R.id.BigFont);
		chkBig.setOnCheckedChangeListener(this);
	}

	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (group.getId() == R.id.ColorGroup) {
			switch (checkedId) {
			case R.id.Red:
				mTogBtn.setTextColor(Color.RED);
				break;
			case R.id.Green:
				mTogBtn.setTextColor(Color.GREEN);
				break;
			case R.id.Blue:
				mTogBtn.setTextColor(Color.BLUE);
				break;
			}
		}
	}

	public void onCheckedChanged (CompoundButton buttonView, boolean isChecked) {
		if (buttonView.getId() == R.id.BigFont) {
			if (isChecked) {
				mTogBtn.setTextSize(40);
			} else {
				mTogBtn.setTextSize(20);
			}
		}
	}
}
