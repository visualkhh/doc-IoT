package exam.Widget;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;
import exam.AndroidExam.*;

public class GridTest extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_gridtest);

		GridView grid = (GridView)findViewById(R.id.grid);
		ImageAdapter Adapter = new ImageAdapter(this);
		grid.setAdapter(Adapter);
		
		grid.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(GridTest.this, position + "번째 그림 선택",
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}

class ImageAdapter extends BaseAdapter {
	private Context mContext;

	int[] picture = { R.drawable.pride, R.drawable.dog, R.drawable.cloud };

	public ImageAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return 100;
	}

	public Object getItem(int position) {
		return picture[position % 3];
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) {
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(45, 45));
			imageView.setAdjustViewBounds(false);
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}

		imageView.setImageResource(picture[position % 3]);

		return imageView;
	}
}
