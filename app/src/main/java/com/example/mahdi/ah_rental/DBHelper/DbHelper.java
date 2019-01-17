package com.example.mahdi.ah_rental.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String userTable = "CREATE TABLE IF NOT EXISTS user(_id INTEGER PRIMARY KEY AUTOINCREMENT,fname TEXT, lname TEXT, phone TEXT, password TEXT,profile TEXT)";
        try{
//            db.execSQL(userTable);

        }catch (Exception e){
            Log.e("table error: ", e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertTo(String tableName,ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        //TODO: return the insert row id or -1 if an error accursed
        long rowId=-1;
        try{
            rowId = db.insert(tableName,null,values);
        }catch (Exception e){ rowId = -1;}
        finally {
            return rowId;
        }
    }
    public Cursor getAlldataFrom(String tableName){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * from " + tableName, null);
    }
    public Cursor getAlldataAlternativelyFrom(String tableName){
        Cursor allData = null;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            allData =  db.query(tableName, null, null, null, null, null, null);
        }catch (Exception e){}
        return allData;
    }
    public Cursor getAlldataReverce(String tableName,String phoneNumber){
        Cursor allData = null;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            allData =  db.query(tableName,null,"phone=?",new String[]{phoneNumber},null, null,"_id DESC");
        }catch (Exception e){}
        return allData;
    }
    public Cursor getDataFrom(String tableName,String[]columnName){
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            //TODO: return all selected data with type cursor
            Cursor data = db.query(tableName, columnName, null, null, null, null, null);
            //db.close();
            return data;
        }catch (Exception e){
            return null;
        }
    }
    public Cursor getDataFromWithId(String tableName,String[]columnName,long id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = null;
        try {
            data = db.query(tableName, columnName, "_id = ?", new String[]{Long.toString(id)}, null, null, null);
        }catch (Exception e){}
        //db.close();
        return data;
    }
   /* public Cursor getSumOfRow(String tableName,int id){
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            return db.rawQuery("SELECT SUM(totlas) FROM"+tableName+" WHERE _id = "+id,null);
        }catch (Exception e){
            return null;
        }
    }*/

    public Cursor validateForLogin(String phone, String password){
        SQLiteDatabase myDb =this.getWritableDatabase();
        return myDb.rawQuery("SELECT _id FROM user WHERE phone = '"+phone+"' AND password = '"+password +"'",null);
    }

    public int deleteDataFrom(String tableName,String wereCluse,long id){
        SQLiteDatabase db = this.getWritableDatabase();
        int result = 0;
        // TODO: return the number of row deleted or 0 if not effected any row
        try {
            result = db.delete(tableName, wereCluse, new String[]{Long.toString(id)});
        }catch (Exception e){
//            Toast.makeText(context,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {
            return result;
        }
    }
    public int updateTable(String tableName,ContentValues updateValue,int id){
        SQLiteDatabase db = getWritableDatabase();
        //TODO: return the number of row effected or 0 if not update
        return db.update(tableName, updateValue, "_id=?", new String[]{Integer.toString(id)});
    }

}
