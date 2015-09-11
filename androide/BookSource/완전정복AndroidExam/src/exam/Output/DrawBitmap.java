package exam.Output;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import exam.AndroidExam.*;

public class DrawBitmap extends Activity {
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
			
			/* 원론적인 방법
			Resources r=getResources();
			BitmapDrawable bd=(BitmapDrawable)r.getDrawable(R.drawable.eighty8);
			Bitmap bit=bd.getBitmap();
			//*/
			
			// 간단한 방법
			Bitmap bit = BitmapFactory.decodeResource(getResources(), R.drawable.eighty8);
			
			canvas.drawBitmap(bit, 10, 10, null);
			canvas.drawBitmap(bit, null, new Rect(80,10,110,58), null);
			canvas.drawBitmap(bit, new Rect(30,40,58,90), new Rect(120,10,120+56,10+80), null);
			
			Bitmap BackBit = Bitmap.createBitmap(200,100,Bitmap.Config.ARGB_8888);
			Canvas offscreen = new Canvas(BackBit);
			offscreen.drawColor(Color.GREEN);
			Pnt.setColor(Color.RED);
			for (int x=0;x<200;x+=5) {
				offscreen.drawLine(x,0,200-x,100,Pnt);
			}
			canvas.drawBitmap(BackBit,10,120,null);
		}
	}
}
