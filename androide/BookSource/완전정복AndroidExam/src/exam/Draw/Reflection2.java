package exam.Draw;

import java.util.*;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import exam.AndroidExam.*;

// 볼 하나에 대한 정보
/* Reflection.java에 정의되어 있으므로 다시 정의할 필요없음
class Ball {
	int x, y;
	int rad;
	int dx, dy;
	int color;
	int count;

	// 새로운 볼 생성
	static Ball Create(int x, int y, int Rad) {
		Random Rnd = new Random();
		Ball NewBall = new Ball();

		NewBall.x = x;
		NewBall.y = y;
		NewBall.rad = Rad;
		do {
			NewBall.dx = Rnd.nextInt(11) - 5;
			NewBall.dy = Rnd.nextInt(11) - 5;
		} while (NewBall.dx == 0 || NewBall.dy == 0);

		NewBall.count = 0;
		NewBall.color = Color.rgb(Rnd.nextInt(256), Rnd.nextInt(256), Rnd.nextInt(256));

		return NewBall;
	}

	// 볼 이동
	void Move(int Width, int Height) {
		x += dx;
		y += dy;

		if (x < rad || x > Width - rad) {
			dx *= -1;
			count++;
		}
		if (y < rad || y > Height - rad) {
			dy *= -1;
			count++;
		}
	}

	// 그리기
	void Draw(Canvas canvas) {
		Paint pnt = new Paint();
		pnt.setAntiAlias(true);

		int r;
		int alpha;

		for (r = rad, alpha = 1; r > 4; r --, alpha += 5) {
			pnt.setColor(Color.argb(alpha, Color.red(color), 
					Color.green(color), Color.blue(color)));
			canvas.drawCircle(x, y, r, pnt);
		}
	}
}
*/

public class Reflection2 extends Activity {
	SurfView vw;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		vw = new SurfView(this);
		setContentView(vw);
	}
}

class SurfView extends SurfaceView implements SurfaceHolder.Callback {
	Bitmap mBack;
	ArrayList<Ball> arBall = new ArrayList<Ball>();
	final static int DELAY = 50;
	final static int RAD = 24;
	SurfaceHolder mHolder;
	DrawThread mThread;

	public SurfView(Context context) {
		super(context);
		mBack = BitmapFactory.decodeResource(context.getResources(), R.drawable.family);

		// 표면에 변화가 생길때의 이벤트를 처리할 콜백을 자신으로 지정한다.
		mHolder = getHolder();
		mHolder.addCallback(this);
	}	

	// 표면이 생성될 때 그리기 스레드를 시작한다.
	public void surfaceCreated(SurfaceHolder holder) {
		mThread = new DrawThread(mHolder);
		mThread.start();
	}

	// 표면이 파괴될 때 그리기를 중지한다.
	public void surfaceDestroyed(SurfaceHolder holder) {
		mThread.bExit = true;
		for (;;) {
			try { 
				mThread.join();
				break;
			} 
			catch (Exception e) {;}
		}
	}

	// 표면의 크기가 바뀔 때 크기를 기록해 놓는다.
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		if (mThread != null) {
			mThread.SizeChange(width, height);
		}
	}

	// 새로운 볼 생성
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			synchronized(mHolder) {
				Ball NewBall = Ball.Create((int)event.getX(), (int)event.getY(), RAD);
				arBall.add(NewBall);
			}
			return true;
		}
		return false;
	}

	class DrawThread extends Thread {
		boolean bExit;
		int mWidth, mHeight;
		SurfaceHolder mHolder;

		DrawThread(SurfaceHolder Holder) {
			mHolder = Holder;
			bExit = false;
		}

		public void SizeChange(int Width, int Height) {
			mWidth = Width;
			mHeight = Height;
		}

		// 스레드에서 그리기를 수행한다.
		public void run() {
			Canvas canvas;
			Ball B;

			while (bExit == false) {
				// 애니메이션 진행
				for (int idx = 0;idx < arBall.size(); idx++) {
					B = arBall.get(idx);
					B.Move(mWidth, mHeight);
					if (B.count > 4) {
						arBall.remove(idx);
						idx--;
					}
				}

				// 그리기
				synchronized(mHolder) {
					canvas = mHolder.lockCanvas();
					if (canvas == null) break;
					canvas.drawColor(Color.BLACK);
					canvas.drawBitmap(mBack, 0, 0, null);

					for (int idx = 0;idx < arBall.size(); idx++) {
						arBall.get(idx).Draw(canvas);
						if (bExit) break;
					}
					mHolder.unlockCanvasAndPost(canvas);
				}

				try { Thread.sleep(MyView.DELAY); } catch (Exception e) {;}
			}
		}
	}
}

