package com.example.campusassist12.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBHandler {
	public ArrayList<String> getType(SQLiteDatabase db,String sql){
		ArrayList<String> type=new ArrayList<String>();
		Cursor cursor=db.rawQuery(sql,null);//查询数据库，得到查询结果Cursor
		while(cursor.moveToNext()){			
			type.add(cursor.getString(0));  //循环遍历结果，将结果放入集合
		}		
		return type;              //返回结果集合
	}
	public ArrayList<Map<String, String>> getData(SQLiteDatabase db,String sql,String[] str){
		ArrayList<Map<String, String>> children=new ArrayList<Map<String,String>>();
		Cursor cursor=db.rawQuery(sql,str);
		while(cursor.moveToNext()){	
			Map<String,String> item=new HashMap<String, String>();
			item.put("name",cursor.getString(0));
			item.put("phone",cursor.getString(1));
			children.add(item);
			
		}		
		return children;
	}
	public void insert(SQLiteDatabase db,String sql,String[] str){
		db.execSQL(sql,str);
	}
}
