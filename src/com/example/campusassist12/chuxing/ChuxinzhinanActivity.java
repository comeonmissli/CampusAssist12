package com.example.campusassist12.chuxing;

import com.example.campusassist12.R;
import com.example.campusassist12.R.layout;
import com.example.campusassist12.R.menu;
import com.example.campusassist12.android.MainActivity;
import com.example.campusassist12.campuslife.CampusBuildActivity;
import com.example.campusassist12.campuslife.CampusLifeActivity;
import com.example.campusassist12.campuslife.CampusSceneryActivity;
import com.example.campusassist12.campuslife.FreshAssistActivity;
import com.example.campusassist12.campuslife.CampusLifeActivity.MyOnClickListener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChuxinzhinanActivity extends Activity {
Button xianluchaxun,wodeweizhi,weizhichaxun,goBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chuxinzhinan);
		xianluchaxun=(Button) this.findViewById(R.id.xianluchaxun);
		wodeweizhi=(Button) this.findViewById(R.id.wodeweizhi);
		weizhichaxun=(Button) this.findViewById(R.id.weizhichaxun);
		goBack=(Button) this.findViewById(R.id.goBack);
		MyOnClickListener myOnClickListener=new MyOnClickListener();
		xianluchaxun.setOnClickListener(myOnClickListener);
		wodeweizhi.setOnClickListener(myOnClickListener);
		weizhichaxun.setOnClickListener(myOnClickListener);
		goBack.setOnClickListener(myOnClickListener);
		
		
	}
	public class MyOnClickListener implements OnClickListener{
		   Intent intent=null;
	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.xianluchaxun:
				intent=new Intent(ChuxinzhinanActivity.this,GongjiaoluxianActivity.class);
			break;
			case R.id.wodeweizhi:
				intent=new Intent(ChuxinzhinanActivity.this,WodeweizhiActivity.class);
			break;
			case R.id.weizhichaxun:
				intent=new Intent(ChuxinzhinanActivity.this,PositionActivity.class);
			break;
			case R.id.goBack:
				intent=new Intent(ChuxinzhinanActivity.this,MainActivity.class);
			break;
			default:
			break;
				
			}
			startActivity(intent);	
			}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chuxinzhinan, menu);
		return true;
	}

}
