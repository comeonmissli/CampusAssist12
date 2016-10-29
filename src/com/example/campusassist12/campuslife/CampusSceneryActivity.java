package com.example.campusassist12.campuslife;

import com.example.campusassist12.R;
import com.example.campusassist12.R.layout;
import com.example.campusassist12.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class CampusSceneryActivity extends Activity {
    int images[]=new int[]{R.drawable.xiaoxinlin,R.drawable.fengyuqiuchang,R.drawable.tushuguan,R.drawable.guike,
    		   R.drawable.beike,R.drawable.luyuan,R.drawable.weiyilou,R.drawable.zhengdaguangchang,R.drawable.zhengdamen,R.drawable.jinghu};
 private Button goBack;	
   
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_campus_scenery);
	    goBack=(Button) this.findViewById(R.id.goBack);
	    goBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(CampusSceneryActivity.this,CampusLifeActivity.class);
				startActivity(intent);
				finish();
			}
		});
	   final Gallery gallery=(Gallery) this.findViewById(R.id.gallery);
	   final ImageSwitcher switcher=(ImageSwitcher) this.findViewById(R.id.switcher2);
	   
	   //为Switcher创建图片，并设置效果
	   switcher.setFactory(new ViewFactory(){
		@Override
		public View makeView() {
			ImageView imageView = new ImageView(CampusSceneryActivity.this);
			imageView.setBackgroundColor(0xff0000);
			imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
			imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			return imageView;
		}   
	   });
	   //设置图片切换为淡入淡出
	   switcher.setInAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in));
	   switcher.setInAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_out));
	  //下拉列表对应的内容信息
	   BaseAdapter adapter=new BaseAdapter(){
		   public int getCount(){
			 return Integer.MAX_VALUE;
		   }

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView imageView=new ImageView(CampusSceneryActivity.this);
			imageView.setImageResource(images[position %images.length]);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setLayoutParams(new Gallery.LayoutParams(75, 100));
			//TypedArray typedArray = obtainStyledAttributes(
			//	R.styleable.Gallery);
			//imageView.setBackgroundResource(typedArray.getResourceId(
			//	R.styleable.Gallery_android_galleryItemBackground, 0));
			return imageView;
		}
	   };
	   gallery.setAdapter(adapter);
	   gallery.setOnItemClickListener(new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long id) {
			// TODO Auto-generated method stub
			switcher.setImageResource(images[position%images.length]);
			
		}
		 public void onNothingSelected(AdapterView<?>arg0){
			 
		 }  
	   });
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.campus_scenery, menu);
		return true;
	}

}
