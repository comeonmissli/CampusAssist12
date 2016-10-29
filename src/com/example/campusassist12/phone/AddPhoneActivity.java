package com.example.campusassist12.phone;

import com.example.campusassist12.R;
import com.example.campusassist12.R.layout;
import com.example.campusassist12.R.menu;
import com.example.campusassist12.db.DBHandler;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPhoneActivity extends Activity {
	private Button submit, reset;
	private EditText name, phone, type, keyword;
	private SQLiteDatabase db = PhoneListActivity.myHelper
			.getReadableDatabase();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_phone);
		
		submit = (Button) findViewById(R.id.submit);
		reset = (Button) findViewById(R.id.reset);
		name = (EditText) findViewById(R.id.name);
		phone = (EditText) findViewById(R.id.phone);
		type = (EditText) findViewById(R.id.type);
		keyword = (EditText) findViewById(R.id.keyword);
		myOnclickListener myOnclickListener = new myOnclickListener();
		submit.setOnClickListener(myOnclickListener);
		reset.setOnClickListener(myOnclickListener);
	}

	private class myOnclickListener implements OnClickListener {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.submit:
				DBHandler dbHandler = new DBHandler();
				String sql = "insert into phone_tb values(null,?,?,?,?)";
				String keywordStr = keyword.getText().toString();
				if (keywordStr == null || "".equals(keywordStr)) {
					keywordStr = name.getText().toString()
							+ phone.getText().toString();
				}
				dbHandler.insert(db, sql, new String[] {
						name.getText().toString(), phone.getText().toString(),
						type.getText().toString(), keywordStr });
				Toast.makeText(AddPhoneActivity.this, "ºÅÂëÌí¼Ó³É¹¦£¡", 1000).show();
				Intent intent=new Intent(AddPhoneActivity.this,PhoneListActivity.class);
				startActivity(intent);
				finish();
				break;
			case R.id.reset:
				name.setText("");
				phone.setText("");
				type.setText("");
				keyword.setText("");
				break;
			default:
				break;
			}

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_phone, menu);
		return true;
	}

}
