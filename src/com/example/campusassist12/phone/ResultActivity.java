package com.example.campusassist12.phone;

import java.util.ArrayList;
import java.util.Map;

import com.example.campusassist12.R;
import com.example.campusassist12.R.layout;
import com.example.campusassist12.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ResultActivity extends Activity {
	private ListView resultList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		resultList = (ListView) findViewById(R.id.result_list);
		Bundle bundle = getIntent().getExtras();
		ArrayList<Map<String, String>> phoneList = (ArrayList<Map<String, String>>) bundle
				.getSerializable("result");
		System.out.println(phoneList);
		System.out.println(phoneList.size());
		SimpleAdapter adapter = new SimpleAdapter(this, phoneList,
				R.layout.child, new String[] { "name", "phone" }, new int[] {
						R.id.name, R.id.phone });
		resultList.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}
