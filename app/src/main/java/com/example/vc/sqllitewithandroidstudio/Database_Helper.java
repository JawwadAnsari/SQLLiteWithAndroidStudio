package com.example.vc.sqllitewithandroidstudio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.jar.Attributes;

/**
 * Created by vc on 6/6/2017.
 */
public class Database_Helper extends SQLiteOpenHelper
{


    public static final String Database_name = "Employee";
    public static final String Table_name = "Employee_TB1";
    public static final String Col1 = "ID";
    public static final String Col2 = "Name";
    public static final String Col3 = "F_Name";
    public static final String Col4 = "Salary";



    public Database_Helper(Context context)
    {
        super(context, Database_name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("CREATE TABLE "+ Table_name+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,F_Name TEXT,Salary TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists "+Table_name);
        onCreate(db);

    }

    public boolean onAdd(String Name, String F_Name, String Salary)
    {
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues a= new ContentValues();
        a.put(Col2, Name);
        a.put(Col3, F_Name);
        a.put(Col4, Salary);
        long r = db.insert(Table_name,null,a);
        if (r == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
}
