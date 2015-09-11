package hest.map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyLocationView extends Activity implements LocationListener {
	LocationManager locationMgr = null;
	Location lastLocation = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_location_view);
		final Button start = (Button) findViewById(R.id.start);
		final TextView status = (TextView) findViewById(R.id.status);
		locationMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		start.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(MyLocationView.this, "위치 조회중....",
						Toast.LENGTH_SHORT).show();
				locationMgr.requestLocationUpdates("gps", 1000, 0,
						MyLocationView.this);
			}
		});
	}

	public void onLocationChanged(Location location) {
		final String geoURI = String.format("geo: %f,%f", location
				.getLatitude(), location.getLongitude());
		Button show = (Button) findViewById(R.id.show_map);
		show.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(MyLocationView.this, "위치 이동:" + geoURI,
						Toast.LENGTH_SHORT).show();
				Intent map = new Intent(Intent.ACTION_VIEW, Uri.parse(geoURI));
				startActivity(map);
			}
		});
		show.setVisibility(View.VISIBLE);
	}

	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
