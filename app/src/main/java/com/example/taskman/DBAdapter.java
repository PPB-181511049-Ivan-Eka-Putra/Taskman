package com.example.taskman;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {

    static final String KEY_TASKID = "task_id";
    static final String KEY_TASKNAME = "task_name";
    static final String KEY_TASKDEADLINE = "task_deadline";
    static final String TAG = "DBAdapter";
    static final String DATABASE_NAME = "Taskman";
    static final String DATABASE_TABLE = "task";
    static final int DATABASE_VERSION = 1;
    static final String DATABASE_CREATE = "create table task (task_id integer primary key autoincrement, " +
            "task_name text not null, task_deadline text not null)";
    final Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public DBAdapter(Context context) {
        this.context = context;
        DBHelper = new DatabaseHelper(context);
    }

    private class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database for version" + oldVersion + " to " +
                    newVersion + ", which will destroy all old data");
            onCreate(db);
        }
    }

    // Opens the database
    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    // Closes the database
    public  void close() {
        DBHelper.close();
    }

    // Insert a contact into the database
    public long insertTask(String taskName, String taskDeadline) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_TASKNAME, taskName);
        initialValues.put(KEY_TASKDEADLINE, taskDeadline);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }
}
