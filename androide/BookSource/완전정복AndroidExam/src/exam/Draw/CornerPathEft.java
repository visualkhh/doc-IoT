package exam.Draw;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;

public class CornerPathEft extends Activity {
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

			Pnt.setColor(Color.WHITE);

			canvas.drawRect(10,10,100,50,Pnt);
			Pnt.setPathEffect(new CornerPathEffect(8));
			canvas.drawRect(10,60,100,100,Pnt);
			Pnt.setPathEffect(new CornerPathEffect(16));
			canvas.drawRect(10,110,100,150,Pnt);
		}
	}
}