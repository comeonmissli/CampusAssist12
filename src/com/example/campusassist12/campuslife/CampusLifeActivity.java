package com.example.campusassist12.campuslife;

import com.example.campusassist12.R;
import com.example.campusassist12.R.layout;
import com.example.campusassist12.R.menu;
import com.example.campusassist12.android.MainActivity;
import com.example.campusassist12.android.MainActivity.MyOnClickListener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CampusLifeActivity extends Activity {
Button campusBuild,campusScenery,freshAssist,goBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_campus_life);
		campusBuild=(Button) this.findViewById(R.id.campusBuild);
		campusScenery=(Button) this.findViewById(R.id.campusScenery);
		freshAssist=(Button) this.findViewById(R.id.freshAssist);
		goBack=(Button) this.findViewById(R.id.goBack);
		MyOnClickListener myOnClickListener=new MyOnClickListener();
		campusBuild.setOnClickListener(myOnClickListener);
		campusScenery.setOnClickListener(myOnClickListener);
		freshAssist.setOnClickListener(myOnClickListener);
		goBack.setOnClickListener(myOnClickListener);
		
	}
	
	
	  public class MyOnClickListener implements OnClickListener{
		   Intent intent=null;
	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.campusBuild:
				intent=new Intent(CampusLifeActivity.this,CampusBuildActivity.class);
			break;
			case R.id.campusScenery:
				intent=new Intent(CampusLifeActivity.this,CampusSceneryActivity.class);
			break;
			case R.id.freshAssist:
				intent=new Intent(CampusLifeActivity.this,FreshAssistActivity.class);
			break;
			case R.id.goBack:
				intent=new Intent(CampusLifeActivity.this,MainActivity.class);
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
		getMenuInflater().inflate(R.menu.campus_life, menu);
		return true;
	}





}
