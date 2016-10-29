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
import com.baidu.mapapi.MapActivity;
import com.baidu.mapapi.MapController;
import com.baidu.mapapi.MapView;
import com.baidu.mapapi.RouteOverlay;
import com.example.campusassist12.R;
import com.example.campusassist12.R.layout;
import com.example.campusassist12.R.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GongjiaoluxianActivity extends MapActivity {
private MapView mapView;  //mapview用于显示地图
private BMapManager bMapManager;//地图管理类
private MapController mc;//地图控制类
private MKSearch mkSearch;//用于位置检索、周边检索，公交检索等

private String keyString="81856CEC017E23D5DA533A5BED3D0414BBB307C3";
private EditText  bus,city;
private Button search;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gongjiaoluxian);
		bus=(EditText) this.findViewById(R.id.bus);
		search=(Button) this.findViewById(R.id.search);
		mapView=(MapView) this.findViewById(R.id.bmapView);
		city=(EditText)this.findViewById(R.id.city);
		bMapManager=new BMapManager(this); //创建地图管理类对象
		//初始化地图管理类
		bMapManager.init(keyString, new MKGeneralListener(){
            
			@Override
			public void onGetPermissionState(int result) {
				// TODO Auto-generated method stub
				if(result==300){
					Toast.makeText(GongjiaoluxianActivity.this, "验证不通过，请重新输入", 
                        Toast.LENGTH_SHORT).show();
				}
			}
			
			@Override
			public void onGetNetworkState(int result) {
				// TODO Auto-generated method stub
			}
		});
		initMapActivity(bMapManager);  //初始化MapActivity
		mapView.setBuiltInZoomControls(true);  //设置地图可放大缩小
		mc=mapView.getController();       //获取地图控制对象
		mc.setZoom(15);             //设置缩放级别为15
		
		search.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mkSearch=new MKSearch();
				mkSearch.init(bMapManager, new MyMKSearchListener());
				mkSearch.poiSearchInCity(city.getText().toString().trim(),bus.getText().toString().trim());
			}
		});
	}
     public class MyMKSearchListener implements MKSearchListener{
    	 @Override
 		public void onGetWalkingRouteResult(MKWalkingRouteResult result, int arg1) {
 			// T返回不行路线搜索结果
 			
 		}
    	 
    	 @Override
 		public void onGetTransitRouteResult(MKTransitRouteResult result, int arg1) {
 			// 返回公交路线搜索结果
 			
 		}
    	 
    	 @Override
 		public void onGetSuggestionResult(MKSuggestionResult arg0, int arg1) {
 			// 返回搜索结果
 			
 		}
    	 
    	 @Override
 		public void onGetPoiResult(MKPoiResult result, int type, int iError) {
 			// TODO 搜索公交详细信息
    		 if(result==null||iError!=0){
    			 Toast.makeText(GongjiaoluxianActivity.this, "对不起，没有相应结果", 1000).show();
    			 return;
    		 }
 			MKPoiInfo mkPoiInfo= null;
 			int mkPoiNum=result.getNumPois();
 			for(int i=0;i<mkPoiNum;i++){
 				mkPoiInfo=result.getPoi(i);
 				if(mkPoiInfo.ePoiType==2){
 					break;
 				}
 			}
 			mkSearch.busLineSearch(city.getText().toString().trim(), bus.getText().toString().trim());
 		}
    	 
    		@Override
    		public void onGetDrivingRouteResult(MKDrivingRouteResult result, int arg1) {
    			// 返回乘驾路线搜索结果
    			
    		}
    		
    		
    		@Override
    		public void onGetBusDetailResult(MKBusLineResult result, int iError) {
    			// TODO Auto-generated method stub
    			if(result==null||iError!=0){
       			 Toast.makeText(GongjiaoluxianActivity.this, "对不起，没有相应结果", 1000).show();
       			 return;
       		 }
    			RouteOverlay routeOverlay=new RouteOverlay(GongjiaoluxianActivity.this,mapView);
    			routeOverlay.setData(result.getBusRoute());
    			mapView.getOverlays().clear();
    			mapView.invalidate();
    			mapView.getController().animateTo(result.getBusRoute().getStart());
    		}

		@Override
		public void onGetAddrResult(MKAddrInfo result, int arg1) {
			// TODO Auto-generated method stub
		}
    	 
     }
     
     
	@Override
	protected void onResume() {
		 super.onResume();
		 if(bMapManager!=null){
    		 bMapManager.start();
    	 }
	}
   
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		 if(bMapManager!=null){
    		 bMapManager.stop();
    	 }
	}

	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		 if(bMapManager!=null){
    		 bMapManager.destroy();
    		 bMapManager=null; 
    	 }
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gongjiaoluxian, menu);
		return true;
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
