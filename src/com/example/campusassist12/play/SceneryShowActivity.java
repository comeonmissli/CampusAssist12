package com.example.campusassist12.play;

import com.example.campusassist12.R;
import com.example.campusassist12.R.layout;
import com.example.campusassist12.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SceneryShowActivity extends Activity {
	private ImageView imageView;
	private TextView content;
	private Button goBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scenery_show);
		imageView=(ImageView)findViewById(R.id.image);
		content=(TextView)findViewById(R.id.content);
		goBack=(Button)findViewById(R.id.goBack);
		int image=getIntent().getIntExtra("image",R.drawable.tengwangge);
		String show=getIntent().getStringExtra("content");
		System.out.println(show);
		imageView.setBackgroundResource(image);
		content.setText(show);
		goBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(SceneryShowActivity.this,SceneryActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scenery_show, menu);
		return true;
	}

}
