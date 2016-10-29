package com.example.campusassist12.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    final String CREAT_TABLE_SQL="creat table phone_tb(_id integer primary)"+
     "key autoincreament,name,phone,type,keyword";
	public MyDatabaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// 第一次建表语句，并执行建表语句，初始化数据库
        db.execSQL(CREAT_TABLE_SQL);
        init(db);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
     System.out.println("--------------"+oldVersion+"--------"+newVersion);
	}
	private void init(SQLiteDatabase db) {
		// 插入初始记录
		db.execSQL("insert into phone_tb values (null,'工商管理学院','83816813','学院号码','工商管理学院83816813')");
		db.execSQL("insert into phone_tb values (null,'会计学院','83823181','学院号码','会计学院83823181')");
		db.execSQL("insert into phone_tb values (null,'经济学院','83816532','学院号码','经济学院83816532')");
		db.execSQL("insert into phone_tb values (null,'金融学院','83816792','学院号码','金融学院83816792')");
		db.execSQL("insert into phone_tb values (null,'统计学院','83816428','学院号码','统计学院83816428')");
		db.execSQL("insert into phone_tb values (null,'信息管理学院','83983891','学院号码','信息管理学院83983891')");
		db.execSQL("insert into phone_tb values (null,'软件与通信工程学院','83845851','学院号码','软件与通信工程学院83845851')");
		db.execSQL("insert into phone_tb values (null,'钟元生教授','13367090011','老师号码','钟元生13367090011')");
		db.execSQL("insert into phone_tb values (null,'朱文强老师','13870689620','老师号码','朱文强13870689620')");
	}

}
