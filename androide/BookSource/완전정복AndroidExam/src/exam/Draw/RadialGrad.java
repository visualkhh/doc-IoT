package exam.Draw;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.Shader.*;
import android.os.*;
import android.view.*;

public class RadialGrad extends Activity {
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

			Pnt.setShader(new RadialGradient(80, 80, 70,
					Color.BLUE, Color.WHITE, TileMode.CLAMP));
			canvas.drawCircle(80, 80, 70, Pnt);
			
			Pnt.setShader(new RadialGradient(230, 80, 70,
					Color.WHITE, Color.BLUE, TileMode.CLAMP));
			canvas.drawCircle(230, 80, 70, Pnt);

			Pnt.setShader(new RadialGradient(80, 230, 70,
					colors, null, TileMode.CLAMP));
			canvas.drawCircle(80, 230, 70, Pnt);

			Pnt.setShader(new RadialGradient(230, 230, 70,
					colors, pos, TileMode.CLAMP));
			canvas.drawCircle(230, 230, 70, Pnt);
		}
	}
}
