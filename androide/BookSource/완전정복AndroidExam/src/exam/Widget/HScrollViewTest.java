package exam.Widget;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class HScrollViewTest extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_hscrollviewtest);
        
        HorizontalScrollView svw = (HorizontalScrollView)findViewById(R.id.scr);
        svw.addView(new HColorView(this));
    }
}

class HColorView extends View {
    public HColorView(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas) {
		Paint Pnt = new Paint();
		for (int x=0;x<1024;x+=4) {
			Pnt.setARGB(255,255-x/4,255-x/4,255);
			canvas.drawRect(x,0,x+4,500,Pnt);
		}
	}
    
    protected void onMeasure (int widthMeasureSpec, int heightMeasureSpec) {
    	setMeasuredDimension(1024, 500);
    }
}
