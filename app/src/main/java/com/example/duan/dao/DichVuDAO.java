package com.example.duan.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan.database.Dbhelper;
import com.example.duan.model.DichVu;

import java.util.ArrayList;

public class DichVuDAO {
    Dbhelper helper;
    SQLiteDatabase db;

    public DichVuDAO(Context context) {
        this.helper = new Dbhelper(context);
    }

    // Lấy danh sách DichVu đang bán
    public ArrayList<DichVu> getListDV() {
        db = helper.getReadableDatabase();
        ArrayList<DichVu> list = new ArrayList<DichVu>();
        Cursor cursor = db.rawQuery("select * from DichVu", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                list.add(new DichVu(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getFloat(2),
                        cursor.getInt(3)
                ));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public boolean insertDichVu(DichVu dichVu) {
        db = helper.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put("Ten_KH", dichVu.getTen_KH());
        values.put("GiaTien", dichVu.getGiaTien());
        values.put("SoLuong", dichVu.getSoluong());

        long check = db.insert("DichVu", null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        return check != -1;
    }

    public boolean updateDichVu(DichVu dichVu) {
        Log.d("DAO_DichVu", "Updating DichVu with ID: " + dichVu.getId_DV());
        db = helper.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put("Ten_KH", dichVu.getTen_KH());
        values.put("GiaTien", dichVu.getGiaTien());
        values.put("SoLuong", dichVu.getSoluong());

        // Cập nhật dữ liệu của DichVu trong cơ sở dữ liệu
        int check = db.update(
                "DichVu", // Tên bảng
                values, // Dữ liệu cần cập nhật
                "Id_DV = ?", // Điều kiện WHERE
                new String[]{String.valueOf(dichVu.getId_DV())} // Tham số cho điều kiện WHERE
        );
        db.setTransactionSuccessful();
        db.endTransaction();
        return check > 0;
    }

    public boolean deleteDichVu(DichVu dichVu) {
        Log.d("DAO_DichVu", "Deleting DichVu with ID: " + dichVu.getId_DV());
        db = helper.getWritableDatabase();
        db.beginTransaction();
        long result = db.delete("DichVu", "Id_DV = ?", new String[]{String.valueOf(dichVu.getId_DV())});
        db.setTransactionSuccessful();
        db.endTransaction();
        return result > 0;
    }
}
