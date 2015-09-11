package exam.activity;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;

public class SaveState extends Activity {
	private MyView vw;
	int x;
	int y;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		x = 50;
		y = 50;
		vw = new MyView(this);
		vw.setFocusable(true);
		setContentView(vw);
	}

	protected class MyView extends View {
		public MyView(Context context) {
			super(context);
		}

		public void onDraw(Canvas canvas) {
			Paint p = new Paint();
			p.setColor(Color.GREEN);
			canvas.drawCircle(x, y, 16, p);
		}

		public boolean onKeyDown(int KeyCode, KeyEvent event) {
			super.onKeyDown(KeyCode, event);
			if (event.getAction() == KeyEvent.ACTION_DOWN) {
				switch (KeyCode) {
				case KeyEvent.KEYCODE_DPAD_LEFT:
					x -= 5;
					invalidate();
					return true;
				case KeyEvent.KEYCODE_DPAD_RIGHT:
					x += 5;
					invalidate();
					return true;
				case KeyEvent.KEYCODE_DPAD_UP:
					y -= 5;
					invalidate();
					return true;
				case KeyEvent.KEYCODE_DPAD_DOWN:
					y += 5;
					invalidate();
					return true;
				}
			}
			return false;
		}
	}
}