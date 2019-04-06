package com.example.dangvannam.coffeapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static com.example.dangvannam.coffeapplication.SanPhamActivity.modelList;

public class MySQLite extends SQLiteOpenHelper {
    public static final String DBName = "Demo_Sqlite";
    public static final int VERSION = 1;
    //--Table Danh sach Hoc//
    public static final String B_TABLEBAN = "Ban";
    public static final String B_ID = "ID";
    public static final String B_TenBAN = "TenBan";
    public static final String B_MABAN = "MaBan";
    public static final String B_DVT = "DVT";
    public static final String B_GT = "GiaTien";
    //Table Subjects//
    public static final String TABLE_SUBJECTS = "Subjects";
    public static final String SUBJECTS_ID = "ID";
    public static final String SUBJECTS_TENBAN = "Tenban";
    public static final String SUBJECTS_SOLUONG = "Soluong";
    public static final String SUBJECTS_TINHTRANGBAN = "Tinhtrangban";
    public static final String SUB_STATUS = "Status";
    public SQLiteDatabase mDB;
    //public SQLiteDatabase rDB;

    public MySQLite(Context context) {
        super(context, DBName, null, VERSION);
        //rDB = getReadableDatabase();
        OpenDB();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String mQuerry = String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",
                B_TABLEBAN, B_ID, B_TenBAN, B_MABAN, B_DVT, B_GT);
        String mSubjectsQuerry = String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s, %s, %s, %s)",
                TABLE_SUBJECTS, SUBJECTS_ID, SUBJECTS_TENBAN, SUBJECTS_TINHTRANGBAN, SUBJECTS_SOLUONG, SUB_STATUS);
        db.execSQL(mSubjectsQuerry);
        db.execSQL(mQuerry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void OpenDB() {
        mDB = getWritableDatabase();
    }

    public void CloseDB() {
        if (mDB != null) {
            mDB.close();
        }
    }

    public List<model> getALL() {
        List<model> banContactList = new ArrayList<>();
        String mQuerry = String.format("SELECT * FROM %s", TABLE_SUBJECTS);
        Cursor cursor = mDB.rawQuery(mQuerry, null);
        cursor.close();
        return modelList;
    }

    public void getAllSubject() {
        List<Votes> votesContacts = new ArrayList<>();
        String mQuerry = String.format("SELECT * FROM %s", TABLE_SUBJECTS);
        Cursor cursor = mDB.rawQuery(mQuerry, null);
        if (cursor.moveToFirst()) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                Votes votes = new Votes();
                votes.setID(cursor.getInt(0));
                votes.setTinhtrangban(cursor.getString(1));
                votes.setTenBan(cursor.getString(2));
                votes.setSoluongban(cursor.getString(3));
                votesContacts.add(votes);
            }
        }
        cursor.close();
    }
}

//        String mClase = String.format("%s = %d", TABLE_SUBJECTS, id);
//        ContentValues values = new ContentValues();
//        values.put(SUB_STATUS, status);
//        int iSuccess = mDB.update(TABLE_SUBJECTS, values, mClase, null);
//        return iSuccess;


