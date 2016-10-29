package com.example.campusassist12.chuxing;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKAddrInfo;
import com.baidu.mapapi.MKBusLineResult;
import com.baidu.mapapi.MKDrivingRouteResult;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.MKPoiInfo;
import com.baidu.mapapi.MKPoiResult;
import com.baidu.mapapi.MKSearch;
import com.baidu.mapapi.MKSearchListener;
import com.baidu.mapapi.MKSuggestionResult;
import com.baidu.mapapi.MKTransitRouteResult;
import com.baidu.mapapi.MKWalkingRouteResult;
import com.baidu.mapapi.MapController;
import com.baidu.mapapi.MapView;
import com.baidu.mapapi.PoiOverlay;
import com.example.campusassist12.R;
import com.example.campusassist12.R.layout;
import com.example.campusassist12.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PositionActivity extends Activity {
	private MapView mapView;
	private BMapManager bMapManager;
	private MapController mc;
	private MKSearch mkSearch;// 用于位置检索、周边检索、范围检索、公交检索、驾乘检索、步行检索
	private String keyString = "81856CEC017E23D5DA533A5BED3D0414BBB307C3";
	private EditText keyPoint,city;
	private Button search;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_position);
	
        keyPoint=(EditText)findViewById(R.id.keypoint);
        search=(Button)findViewById(R.id.search);        
        mapView = (MapView) findViewById(R.id.bmapView);
        city=(EditText)findViewById(R.id.city);
        
		bMapManager = new BMapManager(this);
		bMapManager.init(keyString, new MKGeneralListener() {
			public void onGetPermissionState(int arg0) {
			}
			public void onGetNetworkState(int result) {
				if (result == 300) {
					Toast.makeText(PositionActivity.this, "验证不通过，请重新输入！",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		initMapActivity(bMapManager);
		//mapView.setTraffic(true);
		mapView.setBuiltInZoomControls(true);
		mc=mapView.getController();
		mc.setZoom(12);
		MKSearch.setPoiPageCapacity(20);  
		search.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				mkSearch = new MKSearch();
				mkSearch.init(bMapManager,new MyMKSearchListener());
				mkSearch.poiSearchInCity(city.getText().toString().trim(),keyPoint.getText().toString().trim()); 
			}
		});
	}
	private void initMapActivity(BMapManager bMapManager2) {
		// TODO Auto-generated method stub
		
	}
	public class MyMKSearchListener implements MKSearchListener{
		public void onGetWalkingRouteResult(MKWalkingRouteResult result,
				int arg1) {
			// 返回步行路线搜索结果
		}
		public void onGetTransitRouteResult(MKTransitRouteResult result,
				int arg1) {
			// 返回公交搜索结果				
		}
		public void onGetSuggestionResult(MKSuggestionResult arg0, int arg1) {
			// 返回联想词信息搜索结果
		}
		public void onGetPoiResult(MKPoiResult result, int type, int iError) {
			// 返回poi搜索结果 result - 搜索结果 iError - 错误号，0表示正确返回
			if (result == null || iError != 0) {
				Toast.makeText(PositionActivity.this, "对不起，没有相应结果",
						Toast.LENGTH_LONG).show();
				return;
			}
            // 清除地图上已有的所有覆盖物  
            mapView.getOverlays().clear();  
            // PoiOverlay是baidu map api提供的用于显示POI的Overlay  
            PoiOverlay poioverlay = new PoiOverlay(PositionActivity.this, mapView);  
            // 设置搜索到的POI数据  
            poioverlay.setData(result.getAllPoi());  
            // 在地图上显示PoiOverlay（将搜索到的兴趣点标注在地图上）  
            mapView.getOverlays().add(poioverlay);  
  
            if(result.getNumPois() > 0) {  
                // 设置其中一个搜索结果所在地理坐标为地图的中心  
                MKPoiInfo poiInfo = result.getPoi(0);  
                mc.setCenter(poiInfo.pt);  
            } 			
		}
		public void onGetDrivingRouteResult(MKDrivingRouteResult result,
				int arg1) {
			// 返回驾乘路线搜索结果
		}
		public void onGetBusDetailResult(MKBusLineResult result, int iError) {
			// 返回公交车详情信息搜索结果
		}
		public void onGetAddrResult(MKAddrInfo arg0, int arg1) {
			// 返回地址信息搜索结果
		}
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
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.position, menu);
		return true;
	}

}
