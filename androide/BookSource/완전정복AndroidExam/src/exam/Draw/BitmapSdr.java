package exam.Draw;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.Shader.*;
import android.os.*;
import android.view.*;
import exam.AndroidExam.*;

public class BitmapSdr extends Activity {
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
			
			Pnt.setShader(new BitmapShader(clover, TileMode.REPEAT, TileMode.REPEAT));
			canvas.drawRect(0, 0, 320, 150, Pnt);
			
			Pnt.setShader(new BitmapShader(clover, TileMode.MIRROR, TileMode.REPEAT));
			canvas.drawRect(0, 160, 320, 310, Pnt);
		}
	}
}
