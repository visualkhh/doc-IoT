package exam.Draw;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import exam.AndroidExam.*;

public class ColorFlt extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}

	protected class MyView extends View {
		public MyView(Context context) {
			super(context);
		}

		public void onDraw(Canvas canvas) {
			Paint Pnt = new Paint();
			Pnt.setAntiAlias(true);

			Bitmap eighty8 = BitmapFactory.decodeResource(getContext().getResources(), 
					R.drawable.eight8);

			Pnt.setColorFilter(new LightingColorFilter(128,0));
			canvas.drawBitmap(eighty8, 30, 30, Pnt);
		}
	}
}