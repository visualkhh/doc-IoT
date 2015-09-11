package exam.Draw;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;

public class SweepGrad extends Activity {
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

			int[] colors = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.WHITE };
			float[] pos = { 0.0f, 0.1f, 0.6f, 0.9f, 1.0f };

			Pnt.setShader(new SweepGradient(80, 80, Color.BLUE, Color.WHITE));
			canvas.drawCircle(80, 80, 70, Pnt);
			
			Pnt.setShader(new SweepGradient(230, 80, Color.WHITE, Color.BLUE));
			canvas.drawCircle(230, 80, 70, Pnt);
			
			Pnt.setShader(new SweepGradient(80, 230, colors, null));
			canvas.drawCircle(80, 230, 70, Pnt);
			
			Pnt.setShader(new SweepGradient(230, 230, colors, pos));
			canvas.drawCircle(230, 230, 70, Pnt);
		}
	}
}
