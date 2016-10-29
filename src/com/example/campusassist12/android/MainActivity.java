package com.example.campusassist12.android;

import com.example.campusassist12.R;
import com.example.campusassist12.R.layout;
import com.example.campusassist12.R.menu;
import com.example.campusassist12.campuslife.CampusLifeActivity;
import com.example.campusassist12.chuxing.ChuxinzhinanActivity;

import com.example.campusassist12.phone.PhoneListActivity;
import com.example.campusassist12.play.SceneryActivity;


import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
private Button phoneAssist,trafficAssist,campusLife,scenery;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		phoneAssist=(Button) this.findViewById(R.id.phoneAssist);
		trafficAssist=(Button) this.findViewById(R.id.trafficAssist);
		campusLife=(Button) this.findViewById(R.id.campusLife);
		scenery=(Button) this.findViewById(R.id.scenery);
		MyOnClickListener myOnClickListener=new MyOnClickListener();
		phoneAssist.setOnClickListener(myOnClickListener);
		trafficAssist.setOnClickListener(myOnClickListener);
		campusLife.setOnClickListener(myOnClickListener);
		scenery.setOnClickListener(myOnClickListener);
	}
  public class MyOnClickListener implements OnClickListener{
   Intent intent=null;
@Override
public void onClick(View v) {
	switch(v.getId()){
	case R.id.phoneAssist:
		intent=new Intent(MainActivity.this,PhoneListActivity.class);
		break;
	case R.id.trafficAssist:
		intent=new Intent(MainActivity.this,ChuxinzhinanActivity.class);
		break;
	case R.id.campusLife:
		intent=new Intent(MainActivity.this,CampusLifeActivity.class);
		break;
	
    case R.id.scenery:
	   intent=new Intent(MainActivity.this,SceneryActivity.class);
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
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
