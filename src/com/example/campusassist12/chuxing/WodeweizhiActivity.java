package com.example.campusassist12.chuxing;

import java.util.List;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.MapController;
import com.baidu.mapapi.MapView;
import com.baidu.mapapi.Overlay;
import com.example.campusassist12.R;
import com.example.campusassist12.R.layout;
import com.example.campusassist12.R.menu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.Toast;

public class WodeweizhiActivity extends Activity {
	private MapView mapView;
	private BMapManager bMapManager;
	private MapController mc;
	private String keyString = "81856CEC017E23D5DA533A5BED3D0414BBB307C3";
	private Location location;
	private GeoPoint geoPoint;
	private LocationManager locMg;
	private Bitmap locBitmap;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wodeweizhi);
		locBitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.my_location);
		mapView = (MapView) findViewById(R.id.bmapView);
		bMapManager = new BMapManager(this);
		bMapManager.init(keyString, new MKGeneralListener() {
			public void onGetPermissionState(int arg0) {
			}

			public void onGetNetworkState(int result) {
				if (result == 300) {
					Toast.makeText(WodeweizhiActivity.this, "验证不通过，请重新输入！",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		initMapActivity(bMapManager);
		mapView.setBuiltInZoomControls(true);
		mc = mapView.getController();
		mc.setZoom(12);
		locMg = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		updateLocation(location);

		locMg.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10,
				new android.location.LocationListener() {
					public void onStatusChanged(String provider, int status,
							Bundle extras) {
					}

					public void onProviderEnabled(String provider) {
						updateLocation(locMg.getLastKnownLocation(provider));
					}

					public void onProviderDisabled(String provider) {
						updateLocation(null);
						System.out.println("Provider is invaliate");
					}

					public void onLocationChanged(Location location) {
						updateLocation(location);
					}
				});		
	}

	private void initMapActivity(BMapManager bMapManager2) {
		// TODO Auto-generated method stub
		
	}

	public void updateLocation(Location location) {
		if (location == null) {
			geoPoint = new GeoPoint((int) (28.73 * 1E6), (int) (115.81 * 1E6));
		} else {
			geoPoint = new GeoPoint((int) (location.getLatitude() * 1E6),
					(int) (location.getLongitude() * 1E6));
			System.out.println("Latitude=" + location.getLatitude());
			System.out.println("Longitude=" + location.getLongitude());
		}
		mapView.displayZoomControls(true);
		mapView.invalidate();
		mc.animateTo(geoPoint);
		mc.setCenter(geoPoint);
		List<Overlay> overLays = mapView.getOverlays();
		if (overLays != null) {
			overLays.clear();//清空覆盖层
		}
		//overLays.add(new MyOverLay(geoPoint, locBitmap));		
	}

	protected void onResume() {
		super.onResume();
		if (bMapManager != null) {
			bMapManager.start();
		}
	}

	protected void onPause() {
		super.onPause();
		if (bMapManager != null) {
			// myLocationManager.removeUpdates(locListener);
			bMapManager.stop();
		}
	}

	protected void onDestroy() {
		super.onDestroy();
		if (bMapManager != null) {
			bMapManager.destroy();
			bMapManager = null;
		}
	}

	protected boolean isRouteDisplayed() {
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wodeweizhi, menu);
		return true;
	}

}
