package exam.Output;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;

public class Primitive2 extends Activity {
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
			//canvas.drawARGB(255,255,255,255);
			//canvas.drawRGB(255,255,255);
			//canvas.drawColor(0xffffffff);
			Pnt.setColor(Color.WHITE);
			canvas.drawPaint(Pnt);
			RectF r=new RectF(10,10,100,100);
			Pnt.setColor(Color.RED);
			canvas.drawRoundRect(r,10,10,Pnt);
			r.set(110,10,150,100);
			canvas.drawOval(r,Pnt);
			Pnt.setColor(Color.MAGENTA);
			r.set(10,110,100,200);
			canvas.drawArc(r,10,150,false,Pnt);
			r.set(110,110,200,200);
			canvas.drawArc(r,10,150,true,Pnt);
			Pnt.setColor(Color.BLUE);
			float[] pts={10,210,50,250,50,250,110,220};
			canvas.drawLines(pts,Pnt);
			Pnt.setColor(Color.BLACK);
			float[] pts2={20,210,50,240,100,220};
			canvas.drawPoints(pts2, Pnt);
		}
	}
}
