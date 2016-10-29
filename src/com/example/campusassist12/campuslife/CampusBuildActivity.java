package com.example.campusassist12.campuslife;

import com.example.campusassist12.R;
import com.example.campusassist12.R.layout;
import com.example.campusassist12.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class CampusBuildActivity extends Activity {
 private Button goBack;
 private Spinner mySpinner;
 private ImageView myImage;
 private float mx,my;
 int[] imageIds=new int[]{R.drawable.jiaotong,R.drawable.yaohuxiaoqu,R.drawable.qingshanhuxiaoqu,
		  R.drawable.laoxiaoqu};
 String[] xiaoqu=new String[]{"交通示意图","瑶湖校区","青山湖校区","老校区"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_campus_build);
		mySpinner=(Spinner)this.findViewById(R.id.mySpinner);
		myImage=(ImageView) this.findViewById(R.id.myImage);
		goBack=(Button) this.findViewById(R.id.goBack);
		 goBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent intent = new Intent (CampusBuildActivity.this,CampusLifeActivity.class);
	                startActivity(intent);
	                finish();
				
			}
		});  
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(
		   this,android.R.layout.simple_dropdown_item_1line,xiaoqu);//设置样式和内容
		mySpinner.setAdapter(adapter);
		mySpinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				// TODO Auto-generated method stub
				myImage.setImageResource(imageIds[position]);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				myImage.setImageResource(imageIds[0]);
			}
			
		});
		
		
		myImage.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				float curX = 0,curY = 0;  //触摸事件发生的坐标
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					mx=event.getX();
					my=event.getY();
					break;
				case MotionEvent.ACTION_MOVE:
					mx=event.getX();
					my=event.getY();
					break;
				case MotionEvent.ACTION_UP:
					mx=event.getX();
					my=event.getY();
					myImage.scrollBy((int)(mx-curX),(int)(my-curY));
					break;
				default:
					break;
				}
				return true;
			}
			
		});
	}
       
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.campus_build, menu);
		return true;
	}

}
