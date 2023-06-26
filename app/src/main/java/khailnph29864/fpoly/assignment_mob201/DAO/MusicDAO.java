//package khailnph29864.fpoly.assignment_mob201.DAO;
//
//import android.annotation.SuppressLint;
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import java.util.ArrayList;
//
//import khailnph29864.fpoly.assignment_mob201.Database.DbHelper;
//import khailnph29864.fpoly.assignment_mob201.OB.Music;
//import khailnph29864.fpoly.assignment_mob201.OB.News;
//
//public class MusicDAO {
//    private  final SQLiteDatabase sqLiteDatabase;
//    private Context context;
//
//    public MusicDAO(Context context) {
//        DbHelper helper=new DbHelper(context);
//        sqLiteDatabase=helper.getWritableDatabase();
//    }
////    public long insert(Music music){
////        ContentValues values=new ContentValues();
////        values.put("name_music",music.getTitle());
////        values.put("",music.getLink_music());
////        return sqLiteDatabase.insert("tbl_music",null,values);
////    }
////    public int update(Music music) {
////        ContentValues values=new ContentValues();
////        values.put("name_music",music.getName_music());
////        values.put("link_music",music.getLink_music());
////        return sqLiteDatabase.update("tbl_music", values, "id_music=?", new String[]{String.valueOf(music.getId_music())});
////    }
//
//    public int delete(int ID) {
//        return sqLiteDatabase.delete("tbl_music", "id_music=?", new String[]{String.valueOf(ID)});
//    }
//    @SuppressLint("Range")
//    public ArrayList<Music> getData(String sql, String... SelectAvgs) {
//        ArrayList<Music> lst = new ArrayList<>();
//        Cursor cursor = sqLiteDatabase.rawQuery(sql, SelectAvgs);
//        while (cursor.moveToNext()) {
//        Music ob=new Music();
//            ob.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id_music"))));
//            ob.setTitle(cursor.getString(cursor.getColumnIndex("name_music")));
//            ob.setFile(Integer.parseInt(cursor.getString(cursor.getColumnIndex("file_music"))));
//            lst.add(ob);
//        }
//        return lst;
//    }
//
//    public ArrayList<Music> getAllData() {
//        String sql = "SELECT * FROM tbl_music";
//        return getData(sql);
//    }
//
//    public Music getByID(String id) {
//        String sql = "SELECT * FROM tbl_music  where id_music=?";
//        return getData(sql, id).get(0);
//    }
//
//}
