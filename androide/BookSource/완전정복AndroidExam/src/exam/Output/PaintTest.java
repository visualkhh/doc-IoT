package exam.Output;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;

public class PaintTest extends Activity {
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

			// 캡 모양 테스트
			Pnt.setColor(Color.BLUE);
			Pnt.setStrokeWidth(14);
			canvas.drawLine(10,10,200,10,Pnt);
			Pnt.setStrokeCap(Paint.Cap.ROUND);
			canvas.drawLine(10,30,200,30,Pnt);
			Pnt.setStrokeCap(Paint.Cap.SQUARE);
			canvas.drawLine(10,50,200,50,Pnt);

			// 조인 모양 테스트
			Pnt.setColor(Color.BLACK);
			Pnt.setStrokeWidth(15);
			Pnt.setStyle(Paint.Style.STROKE);
			Pnt.setStrokeJoin(Paint.Join.MITER);
			canvas.drawRect(10,80,60,130,Pnt);
			Pnt.setStrokeJoin(Paint.Join.BEVEL);
			canvas.drawRect(80,80,130,130,Pnt);
			Pnt.setStrokeJoin(Paint.Join.ROUND);
			canvas.drawRect(150,80,200,130,Pnt);
			
			// 스타일 테스트
			Pnt.setStrokeWidth(5);
			Pnt.setColor(Color.RED);
			Pnt.setStyle(Paint.Style.FILL);
			canvas.drawCircle(30,180,20,Pnt);
			Pnt.setStyle(Paint.Style.STROKE);
			canvas.drawCircle(80,180,20,Pnt);
			Pnt.setStyle(Paint.Style.FILL_AND_STROKE);
			canvas.drawCircle(130,180,20,Pnt);
			Pnt.setColor(Color.BLUE);
			canvas.drawCircle(180,180,20,Pnt);
			Pnt.setStyle(Paint.Style.FILL);
			Pnt.setColor(Color.RED);
			Pnt.setStyle(Paint.Style.STROKE);
			canvas.drawCircle(180,180,20,Pnt);
		}
	}
}
