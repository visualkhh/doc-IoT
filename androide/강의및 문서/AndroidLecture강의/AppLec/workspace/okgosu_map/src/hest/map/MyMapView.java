package hest.map;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MyMapView extends MapActivity {

	double lat = 0f;
	double lon = 0f;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_map_view);
		final Geocoder coder = new Geocoder(getApplicationContext());
		final MapView map = (MapView) findViewById(R.id.map);
		final EditText loc_name = (EditText) findViewById(R.id.placename);
		final TextView results = (TextView) findViewById(R.id.result);
		final Button mapLoc = (Button) findViewById(R.id.map_it);
		// 맵 컨트롤러 참조
		final MapController mapControl = map.getController();
		mapControl.setZoom(10);
		// 터치하면 줌컨트롤 나오게
		map.setBuiltInZoomControls(true);

		Button geocode = (Button) findViewById(R.id.geocode);
		geocode.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String placeName = loc_name.getText().toString();
				List<Address> geocodeResults;
				
				lat = 37.422006f;
				lon =-122.084095f;				
				try {
					geocodeResults = coder.getFromLocationName(placeName, 3);
					Iterator<Address> locations = geocodeResults.iterator();
					String locInfo = "주소검색결과:\n";
					while (locations.hasNext()) {
						Address loc = locations.next();
						locInfo += String.format("Location: %f, %f", loc
								.getLatitude(), loc.getLongitude());
						lat = loc.getLatitude();
						lon = loc.getLongitude();
					}
					results.setText(locInfo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		mapLoc.setVisibility(View.VISIBLE);
		mapLoc.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				GeoPoint newPoint = new GeoPoint((int) (lat * 1E6),
						(int) (lon * 1E6));
				mapControl.animateTo(newPoint);
				mapControl.setZoom(15);
				InputMethodManager imm =
					(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(loc_name.getWindowToken(), 0);				
			}
		});
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}
