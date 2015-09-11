package exam.Draw;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;

public class Skew extends Activity {
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

			Pnt.setColor(Color.YELLOW);
			canvas.drawRect(10,10,50,50,Pnt);

			canvas.skew(-0.1f,0);
			canvas.translate(60,0);
			canvas.drawRect(10,10,50,50,Pnt);

			canvas.skew(-0.1f,0);
			canvas.translate(60,0);
			canvas.drawRect(10,10,50,50,Pnt);

			canvas.skew(-0.1f,0);
			canvas.translate(60,0);
			canvas.drawRect(10,10,50,50,Pnt);
		}
	}
}