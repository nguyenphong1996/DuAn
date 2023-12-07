package com.example.duan.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {

    public Dbhelper(@Nullable Context context) {
        super(context, "Duan", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String nguoidung = "CREATE TABLE NGUOIDUNG(id_nguoidung integer primary key autoincrement, user text, pass text, email text)";
        db.execSQL(nguoidung);
        String data = "INSERT INTO NGUOIDUNG (user, pass, email) VALUES" +
                "('phong', '123', 'phong@example.com')," +
                "('quy', '123', 'quy@example.com')," +
                "('tien', '123', 'tien@example.com')," +
                "('kien', '123', 'kien@example.com')," +
                "('bao', '123', 'bao@example.com')";
        db.execSQL(data);

        // Bảng thông tin người dùng
        db.execSQL("CREATE TABLE ThongTinND(" +
                "Id_NguoiDung INTEGER PRIMARY KEY AUTOINCREMENT," +
                "SDT text," +
                "Role_ND INTEGER," +
                "Id_TaiKhoan INTEGER," +
                "FOREIGN KEY(Id_TaiKhoan) REFERENCES TaiKhoanND(Id_TaiKhoan))"
        );
        data = "INSERT INTO ThongTinND VALUES" +
                "(0, '27928', '1', 0)," +
                "(1, '27683', '2', 1)";
        db.execSQL(data);

        // Bảng dịch vụ
        db.execSQL("CREATE TABLE DichVu(" +
                "Id_DV integer primary key autoincrement," +
                "Ten_DV text," +
                "GiaTien float," +
                "MoTa text)"
        );
        data = "INSERT INTO DichVu VALUES" +
                "(null, 'Giặt sấy đồ < 3kg', 45000, null)," +
                "(null, 'Giặt sấy đồ < 5kg', 75000, null)";
        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
        db.execSQL("DROP TABLE IF EXISTS ThongTinND");
        db.execSQL("DROP TABLE IF EXISTS DichVu");
        onCreate(db);
    }
}
