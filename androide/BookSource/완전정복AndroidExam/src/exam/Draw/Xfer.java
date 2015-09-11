package exam.Draw;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;

public class Xfer extends Activity {
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

			Pnt.setColor(Color.RED);
			canvas.drawCircle(100,100,80,Pnt);
			
			Pnt.setXfermode(new PixelXorXfermode(Color.BLACK));
			
			Pnt.setColor(Color.BLUE);
			canvas.drawRect(100,100,200,200,Pnt);
		}
	}
}