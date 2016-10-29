package com.example.campusassist12.phone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.campusassist12.R;
import com.example.campusassist12.R.layout;
import com.example.campusassist12.R.menu;
import com.example.campusassist12.db.DBHandler;
import com.example.campusassist12.db.MyDatabaseHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleExpandableListAdapter;

public class PhoneListActivity extends Activity {
	public static MyDatabaseHelper myHelper;
	private EditText keyword;
	private Button query;
	DBHandler dbHandler=new DBHandler();
	SQLiteDatabase db;
	List<? extends List<? extends Map<String, ?>>> children = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_list);
		myHelper=new MyDatabaseHelper(this,"phone.db",null,1);
		db=myHelper.getReadableDatabase();
		String sql="select distinct type from phone_tb";
		ArrayList<String>type=dbHandler.getType(db, sql);
		ArrayList<Map<String,String>>groups=new ArrayList<Map<String,String>>();
		for(String str:type){
			Map<String,String>item=new HashMap<String,String>();
			item.put("group", str);
			ArrayList<Map<String,String>>child=dbHandler.getData(db, 
					"select name,phone from _tb where type=?", new String[]{str});
			children.add(null);
			
		}
		
		SimpleExpandableListAdapter simpleExpandListAdapter=new SimpleExpandableListAdapter(
				this,groups,R.layout.group,new String[]{"group"},new int[]{R.id.group},
				children,R.layout.child,new String[]{"name","phone"},new int[]{R.id.name,R.id.phone});
		setListAdapter(simpleExpandListAdapter);
		keyword=(EditText)this.findViewById(R.id.keyword);
		query=(Button) this.findViewById(R.id.query);
		query.setOnClickListener(new View.OnClickListener() {
			String sql="select name,phone from phone_tb where keyword like?";
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ArrayList<Map<String,String>>phoneList=dbHandler.getData(db, sql, 
						new String[]{"%"+keyword.getText().toString()+"%"});
				Intent intent=new Intent(PhoneListActivity.this,ResultActivity.class);
				Bundle bundle=new Bundle();
				bundle.putSerializable("result", phoneList);
				intent.putExtras(bundle);
				startActivity(intent);
				
			}
		});
	}

	private void setListAdapter(
			SimpleExpandableListAdapter simpleExpandListAdapter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.phone_manager, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.addphone:
			Intent intent = new Intent(PhoneListActivity.this,
					AddPhoneActivity.class);
			startActivity(intent);
			break;
		case R.id.exit:
			this.finish();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
