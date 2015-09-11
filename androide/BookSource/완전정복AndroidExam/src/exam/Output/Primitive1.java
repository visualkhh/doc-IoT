package exam.Output;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;

public class Primitive1 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyView vw = new MyView(this);
		setContentView(vw);
	}

	protected class MyView extends View {
		public MyView(Context context) {
			super(context);
		}

		public void onDraw(Canvas canvas) {
			Paint Pnt = new Paint();
			canvas.drawColor(Color.WHITE);
			canvas.drawPoint(10,10,Pnt);
			Pnt.setColor(Color.BLUE);
			canvas.drawLine(20,10,200,50,Pnt);
			Pnt.setColor(Color.RED);
			canvas.drawCircle(100,90,50,Pnt);
			Pnt.setColor(0x800000ff);
			canvas.drawRect(10,100,200,170,Pnt);
			Pnt.setColor(Color.BLACK);
			canvas.drawText("Canvas Text Out", 10,200,Pnt);
		}
	}
}
