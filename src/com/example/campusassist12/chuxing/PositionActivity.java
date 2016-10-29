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
	private MKSearch mkSearch;// ����λ�ü������ܱ߼�������Χ�����������������ݳ˼��������м���
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
					Toast.makeText(PositionActivity.this, "��֤��ͨ�������������룡",
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
			// ���ز���·���������
		}
		public void onGetTransitRouteResult(MKTransitRouteResult result,
				int arg1) {
			// ���ع����������				
		}
		public void onGetSuggestionResult(MKSuggestionResult arg0, int arg1) {
			// �����������Ϣ�������
		}
		public void onGetPoiResult(MKPoiResult result, int type, int iError) {
			// ����poi������� result - ������� iError - ����ţ�0��ʾ��ȷ����
			if (result == null || iError != 0) {
				Toast.makeText(PositionActivity.this, "�Բ���û����Ӧ���",
						Toast.LENGTH_LONG).show();
				return;
			}
            // �����ͼ�����е����и�����  
            mapView.getOverlays().clear();  
            // PoiOverlay��baidu map api�ṩ��������ʾPOI��Overlay  
            PoiOverlay poioverlay = new PoiOverlay(PositionActivity.this, mapView);  
            // ������������POI����  
            poioverlay.setData(result.getAllPoi());  
            // �ڵ�ͼ����ʾPoiOverlay��������������Ȥ���ע�ڵ�ͼ�ϣ�  
            mapView.getOverlays().add(poioverlay);  
  
            if(result.getNumPois() > 0) {  
                // ��������һ������������ڵ�������Ϊ��ͼ������  
                MKPoiInfo poiInfo = result.getPoi(0);  
                mc.setCenter(poiInfo.pt);  
            } 			
		}
		public void onGetDrivingRouteResult(MKDrivingRouteResult result,
				int arg1) {
			// ���ؼݳ�·���������
		}
		public void onGetBusDetailResult(MKBusLineResult result, int iError) {
			// ���ع�����������Ϣ�������
		}
		public void onGetAddrResult(MKAddrInfo arg0, int arg1) {
			// ���ص�ַ��Ϣ�������
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
