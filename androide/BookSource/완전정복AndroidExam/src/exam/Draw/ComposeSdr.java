package exam.Draw;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.Shader.*;
import android.os.*;
import android.view.*;
import exam.AndroidExam.*;

public class ComposeSdr extends Activity {
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

			Bitmap clover = BitmapFactory.decodeResource(getContext().getResources(), 
					R.drawable.clover);

			ComposeShader comp = new ComposeShader(
					new BitmapShader(clover, TileMode.REPEAT, TileMode.REPEAT),
					new LinearGradient(0,0,320,0, 0x0, Color.BLACK, TileMode.REPEAT), 
					new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
			Pnt.setShader(comp);
			canvas.drawRect(0, 0, 320, 200, Pnt);
		}
	}
}
