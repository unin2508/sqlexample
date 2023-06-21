package com.example.sqlexample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sqlexample.model.Lophoc;
import com.example.sqlexample.model.Sinhvien;
import com.example.sqlexample.model.SinhvienLophoc;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "quanlysinhvien.db";
    private static int DATABASE_VERSION = 1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql1 = "CREATE TABLE sinhvien( "+
                "masv INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ten TEXT,namsinh TEXT,quequan TEXT, namhoc INTEGER)";
        String sql2 = "CREATE TABLE lophoc( "+
                "malop INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ten TEXT,mota TEXT)";
        String sql3 = "CREATE TABLE sinhvienlophoc( "+
                "idsv INTEGER,idlop INTEGER,kyhoc TEXT, sotinchi INTEGER)";
        sqLiteDatabase.execSQL(sql1);
        sqLiteDatabase.execSQL(sql2);
        sqLiteDatabase.execSQL(sql3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    public List<Sinhvien> getAllSinhvien(){
        List<Sinhvien> list = new ArrayList<Sinhvien>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor rs = db.query("sinhvien",null,null,null,
                null,null,null);
        while (rs != null && rs.moveToNext()){
            int id = rs.getInt(0);
            String ten = rs.getString(1);
            String namsinh = rs.getString(2);
            String quequan = rs.getString(3);
            int namhoc = rs.getInt(4);
            list.add(new Sinhvien(id,ten,namsinh,quequan,namhoc));
        }
        return list;
    }

    public List<Lophoc> getAllLophoc(){
        List<Lophoc> list = new ArrayList<Lophoc>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor rs = db.query("lophoc",null,null,null,null,null,null);
        while (rs != null && rs.moveToNext()){
            int id = rs.getInt(0);
            String ten = rs.getString(1);
            String mota = rs.getString(2);
            list.add(new Lophoc(id,ten,mota));
        }
        return list;
    }

    public List<SinhvienLophoc> getAllLophocTinchi(){
        List<SinhvienLophoc> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql3 = "CREATE TABLE sinhvienlophoc( "+
                "idsv INTEGER,idlop INTEGER,kyhoc TEXT, sotinchi INTEGER)";

        Cursor rs = db.query("sinhvienlophoc",null,null,null,null,null,null);
        while (rs != null && rs.moveToNext()){
            int idSv = rs.getInt(0);
            int idlop = rs.getInt(1);
            String kyhoc = rs.getString(2);
            int tinchi = rs.getInt(3);
            list.add(new SinhvienLophoc(idSv,idlop,kyhoc,tinchi));
        }
        return list;
    }
    public long addSV(Sinhvien x){
        ContentValues values = new ContentValues();
        values.put("ten",x.getTen());
        values.put("namsinh", x.getNamsinh());
        values.put("quequan",x.getQuequan());
        values.put("namhoc",x.getNamhoc());
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("sinhvien",null,values);
    }

    public long addlophoc(Lophoc x){
        ContentValues values = new ContentValues();
        values.put("ten",x.getTen());
        values.put("mota", x.getMota());
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("lophoc",null,values);
    }

    public long dangkylophoc(Lophoc x,Sinhvien y,String kyhoc,Integer tinchi){
        String sql3 = "CREATE TABLE sinhvienlophoc( "+
                "idsv INTEGER,idlop INTEGER,kyhoc TEXT, sotinchi INTEGER)";
        ContentValues values = new ContentValues();
        values.put("idsv",y.getMaSv());
        values.put("idlop", x.getMalop());
        values.put("kyhoc",kyhoc);
        values.put("sotinchi",tinchi);
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("sinhvienlophoc",null,values);
    }
}
