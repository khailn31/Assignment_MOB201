package khailnph29864.fpoly.assignment_mob201.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import khailnph29864.fpoly.assignment_mob201.R;

public class DbHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "ass_mob201";
    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
//    public static final String table_news= "CREATE TABLE " +
//            "tbl_news(" +
//            "id_news INTEGER PRIMARY KEY AUTOINCREMENT," +
//            "title_news TEXT NOT NULL," +
//            "link_news TEXT NOT NULL)";
    public static final String table_music= "CREATE TABLE " +
            "tbl_music(" +
            "id_music INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name_music TEXT NOT NULL," +
            "file_music INTEGER NOT NULL)";
    public static final String table_music_favorite="CREATE TABLE " +
            "tbl_music_f(" +
            "id_music_f INTEGER PRIMARY KEY AUTOINCREMENT," +
            "id_music INTEGER NOT NULL," +
            "FOREIGN KEY (id_music) REFERENCES tbl_music (id_music))";
    public static final String table_user= "CREATE TABLE " +
            "tbl_user(" +
            "id_user INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name_user TEXT NOT NULL," +
            "pass_user TEXT NOT NULL)";
//    public static final String insert_tk="Insert into tbl_user(name_user,pass_user) values" +
//            "('khailn31','072001')";
//public static final String insert_tk="Insert into tbl_music(name_music,file_music) values" +
//                "('Chúng ta của hiện tại','R.raw.bai1')";
    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(table_news);
        db.execSQL(table_music);
        db.execSQL(table_user);
//        db.execSQL(table_music_favorite);
//        db.execSQL(insert_tk);
//        db.execSQL(insert_tk);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_news");
        db.execSQL("DROP TABLE IF EXISTS tbl_music");
        db.execSQL("DROP TABLE IF EXISTS tbl_user");
        db.execSQL("DROP TABLE IF EXISTS tbl_music_f");
        onCreate(db);
    }

}
