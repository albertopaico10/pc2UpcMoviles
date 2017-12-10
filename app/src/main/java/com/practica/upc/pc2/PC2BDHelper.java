package com.practica.upc.pc2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alberto.paico on 10/12/2017.
 */

public class PC2BDHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION= 1;
    public static final String  DATABASE_NAME = "Pc2.db";

    public PC2BDHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TablesPC2.JobEntry.TABLE_NAME +" ("+
                //TablesPC2.JobEntry._ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            TablesPC2.JobEntry.ID_JOB+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            TablesPC2.JobEntry.TITLE+" TEXT NOT NULL, "+
            TablesPC2.JobEntry.DESCRIPTION+" TEXT NOT NULL, "+
            TablesPC2.JobEntry.DATE+" TEXT NOT NULL, "+
            TablesPC2.JobEntry.STATUS+" TEXT NOT NULL, "+
            TablesPC2.JobEntry.PENDING_HOURS+" INTEGER NOT NULL) ");
    }

    public void doInsertData(List<JobModal> item){
        SQLiteDatabase sql=getWritableDatabase();
        for(int i=0;i<item.size();i++) {
            long insert = sql.insert(TablesPC2.JobEntry.TABLE_NAME, null, item.get(i).toContentValues());
        }
    }

    public List<JobModal> getAllJobByDate(String date){
        List<JobModal> listJob = new ArrayList<JobModal>();
        SQLiteDatabase db=getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM "+TablesPC2.JobEntry.TABLE_NAME+" WHERE "+TablesPC2.JobEntry.DATE
                +" = '"+date+"'", null);
        if (c.moveToFirst()) {
            do {
                int idJob = c.getInt(c.getColumnIndex(TablesPC2.JobEntry.ID_JOB));
                String title = c.getString(c.getColumnIndex(TablesPC2.JobEntry.TITLE));
                String description = c.getString(c.getColumnIndex(TablesPC2.JobEntry.DESCRIPTION));
                String status = c.getString(c.getColumnIndex(TablesPC2.JobEntry.STATUS));
                String pendingHours = c.getString(c.getColumnIndex(TablesPC2.JobEntry.PENDING_HOURS));
                String dateJob = c.getString(c.getColumnIndex(TablesPC2.JobEntry.DATE));
                JobModal beanJob = new JobModal (title,description,6,idJob,pendingHours,status,dateJob);
                listJob.add(beanJob);
            } while (c.moveToNext());
        }

        Log.d("PC2BDHelper",listJob.size()+"**");
        return listJob;
    }

    public void doUpdateJob(int id,String hours){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TablesPC2.JobEntry.PENDING_HOURS,"Horas Trabajadas : "+hours); //These Fields should be your String values of actual column names
        Log.d("PC2BDHelper","antes de actualizar");
        db.update(TablesPC2.JobEntry.TABLE_NAME,cv,TablesPC2.JobEntry.ID_JOB+"="+id,null);
        Log.d("PC2BDHelper","despues de actualizar");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXITS "+TablesPC2.JobEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
