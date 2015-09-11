package exam.Widget;

import android.app.*;
import android.os.*;
import android.widget.*;
import exam.AndroidExam.*;

public class Rating extends Activity {
	RatingBar mRating;
	TextView mRateText;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_rating);

		mRating = (RatingBar)findViewById(R.id.ratingbar);
		mRateText = (TextView)findViewById(R.id.ratetext);

		mRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
			public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
				mRateText.setText("Now Rate : " + rating);
			}
		});
	}
}