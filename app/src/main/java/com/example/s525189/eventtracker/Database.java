package com.example.s525189.eventtracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by S525189 on 3/31/2018.
 */

public class Database extends SQLiteOpenHelper {
    public static final String Database_Name = ".db";
    public static final String Table_Name = "user_info";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "first";
    public static final String COL_3 = "last";

    public Database(Context context) {
        super(context, Database_Name, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String createTable = ("Create table " + Table_Name + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, first TEXT, last TEXT)");
        sqLiteDatabase.execSQL(createTable);
        Log.d("The database is created", "Database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(sqLiteDatabase);
    }
}
