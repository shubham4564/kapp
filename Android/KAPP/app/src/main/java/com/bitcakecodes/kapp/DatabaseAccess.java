package com.bitcakecodes.kapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public String databaseToString(int key, int a) {
        String data = "";
        String s = "";
        Cursor c = database.rawQuery("SELECT * FROM kuinfo", null);
        if (a == 2) {
            c.moveToFirst();
            int id = c.getInt(0);
            while (id != key) {
                c.moveToNext();
                id++;
            }
            data = c.getString(2);
            return data;
        } else if (a == 1) {
            c.moveToFirst();
            int id = c.getInt(0);
            while (id != key) {
                c.moveToNext();
                id++;
            }
            data = c.getString(1);
            return data;
        } else if (a == 6) {
            c.moveToFirst();
            int id = c.getInt(0);
            while (id != key) {
                c.moveToNext();
                id++;
            }
            data = c.getString(6);
            return data;
        } else if (a == 3) {
            c.moveToFirst();
            int id = c.getInt(0);
            while (id != key) {
                c.moveToNext();
                id++;
            }
            data = c.getString(3);
            return data;
        } else if (a == 4) {
            c.moveToFirst();
            int id = c.getInt(0);
            while (id != key) {
                c.moveToNext();
                id++;
            }
            data = c.getString(4);
            return data;
        } else if (a == 5) {
            c.moveToFirst();
            int id = c.getInt(0);
            while (id != key) {
                c.moveToNext();
                id++;
            }
            data = c.getString(5);
            return data;
        } else
            return s;
    }

    public double dataTodouble(int key, int a)
    {
        double d=0;
        Cursor c = database.rawQuery("SELECT * FROM kuinfo", null);
        if (a == 3) {
            c.moveToFirst();
            int id = c.getInt(0);
            while (id != key) {
                c.moveToNext();
                id++;
            }
            d = c.getDouble(3);
            return d;
        }
        if (a == 4) {
            c.moveToFirst();
            int id = c.getInt(0);
            while (id != key) {
                c.moveToNext();
                id++;
            }
            d = c.getDouble(4);
            return d;
        }
        else
            return 0;
    }

    /*public int databaseToInt(int key, int j)
    {
        int i;
        Cursor c = database.rawQuery("SELECT * FROM kuinfo", null);
        if(j == 1) {
            c.moveToFirst();
            int id = c.getInt(0);
            while (id != key) {
                c.moveToNext();
                id++;
            }
            i = c.getInt(1);
            return i;
        }
        else{
            c.moveToFirst();
            int id = c.getInt(0);
            while (id != key) {
                c.moveToNext();
                id++;
            }
            i = c.getInt(5);
            return i;
        }
    }
    public double databaseToDouble(int key, int i)
    {
        double j;
        Cursor c = database.rawQuery("SELECT * FROM kuinfo", null);
        if(i==3) {
            c.moveToFirst();
            int id = c.getInt(0);
            while (id != key) {
                c.moveToNext();
                id++;
            }
            j = c.getDouble(3);
            return j;
        }
        else {
            c.moveToFirst();
            int id = c.getInt(0);
            while (id != key) {
                c.moveToNext();
                id++;
            }
            j = c.getDouble(4);
            return j;
        }
    }
}
*/
}
