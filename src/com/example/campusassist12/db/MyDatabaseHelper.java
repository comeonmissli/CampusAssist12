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
		// ��һ�ν�����䣬��ִ�н�����䣬��ʼ�����ݿ�
        db.execSQL(CREAT_TABLE_SQL);
        init(db);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
     System.out.println("--------------"+oldVersion+"--------"+newVersion);
	}
	private void init(SQLiteDatabase db) {
		// �����ʼ��¼
		db.execSQL("insert into phone_tb values (null,'���̹���ѧԺ','83816813','ѧԺ����','���̹���ѧԺ83816813')");
		db.execSQL("insert into phone_tb values (null,'���ѧԺ','83823181','ѧԺ����','���ѧԺ83823181')");
		db.execSQL("insert into phone_tb values (null,'����ѧԺ','83816532','ѧԺ����','����ѧԺ83816532')");
		db.execSQL("insert into phone_tb values (null,'����ѧԺ','83816792','ѧԺ����','����ѧԺ83816792')");
		db.execSQL("insert into phone_tb values (null,'ͳ��ѧԺ','83816428','ѧԺ����','ͳ��ѧԺ83816428')");
		db.execSQL("insert into phone_tb values (null,'��Ϣ����ѧԺ','83983891','ѧԺ����','��Ϣ����ѧԺ83983891')");
		db.execSQL("insert into phone_tb values (null,'�����ͨ�Ź���ѧԺ','83845851','ѧԺ����','�����ͨ�Ź���ѧԺ83845851')");
		db.execSQL("insert into phone_tb values (null,'��Ԫ������','13367090011','��ʦ����','��Ԫ��13367090011')");
		db.execSQL("insert into phone_tb values (null,'����ǿ��ʦ','13870689620','��ʦ����','����ǿ13870689620')");
	}

}
