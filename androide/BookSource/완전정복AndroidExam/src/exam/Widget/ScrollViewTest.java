package exam.Widget;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class ScrollViewTest extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_scrollviewtest);
        
        ScrollView svw = (ScrollView)findViewById(R.id.scr);
        //svw.setScrollBarStyle(View.SCROLLBARS_INSIDE_INSET);
        //svw.setVerticalFadingEdgeEnabled(false);
        //svw.setVerticalScrollBarEnabled(false);
        svw.addView(new ColorView(this));
    }
}

class ColorView extends View {
    public ColorView(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas) {
		Paint Pnt = new Paint();
		for (int y=0;y<1024;y+=4) {
			Pnt.setARGB(255,255-y/4,255-y/4,255);
			canvas.drawRect(0,y,500,y+4,Pnt);
		}
	}
    
    protected void onMeasure (int widthMeasureSpec, int heightMeasureSpec) {
    	setMeasuredDimension(500,1024);
    }
}
