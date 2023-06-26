//package khailnph29864.fpoly.assignment_mob201.DAO;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import java.util.ArrayList;
//
//import khailnph29864.fpoly.assignment_mob201.Database.DbHelper;
//import khailnph29864.fpoly.assignment_mob201.OB.News;
//
//public class NewsDAO {
//    private  final SQLiteDatabase sqLiteDatabase;
//    private Context context;
//
//    public NewsDAO( Context context) {
//        DbHelper helper=new DbHelper(context);
//        sqLiteDatabase=helper.getWritableDatabase();
//    }
//    public long insert(News news){
//        ContentValues values=new ContentValues();
//        values.put("title_news",news.getTitle_news());
//        values.put("link_news",news.getLink_news());
//        return sqLiteDatabase.insert("tbl_news",null,values);
//    }
//    public int update(News news) {
//        ContentValues values = new ContentValues();
//        values.put("title_news",news.getTitle_news());
//        values.put("link_news",news.getLink_news());
//        return sqLiteDatabase.update("tbl_news", values, "id_news=?", new String[]{String.valueOf(news.getId_news())});
//    }
//
//    public int delete(int ID) {
//        return sqLiteDatabase.delete("tbl_news", "id_news=?", new String[]{String.valueOf(ID)});
//    }
//    public ArrayList<News> getData(String sql, String... SelectAvgs) {
//        ArrayList<News> lst = new ArrayList<>();
//        Cursor cursor = sqLiteDatabase.rawQuery(sql, SelectAvgs);
//        while (cursor.moveToNext()) {
//            News ob = new News();
//            ob.setId_news(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id_news"))));
//            ob.setTitle_news(cursor.getString(cursor.getColumnIndex("title_news")));
//            ob.setLink_news(cursor.getString(cursor.getColumnIndex("link_news")));
//            lst.add(ob);
//        }
//        return lst;
//    }
//
//    public ArrayList<News> getAllData() {
//        String sql = "SELECT * FROM tbl_news";
//        return getData(sql);
//    }
//
//    public News getByID(String id) {
//        String sql = "SELECT * FROM tbl_news  where id_news=?";
//        return getData(sql, id).get(0);
//    }
//
//}
