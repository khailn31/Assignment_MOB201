package khailnph29864.fpoly.assignment_mob201.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import khailnph29864.fpoly.assignment_mob201.Database.DbHelper;
import khailnph29864.fpoly.assignment_mob201.OB.News;
import khailnph29864.fpoly.assignment_mob201.OB.User;

public class UserDAO {
    private  final SQLiteDatabase sqLiteDatabase;


    public UserDAO(Context context) {
        DbHelper helper=new DbHelper(context);
        sqLiteDatabase=helper.getWritableDatabase();
    }
    public int insert(User user){
        ContentValues values=new ContentValues();
        values.put("name_user",user.getName_user());
        values.put("pass_user",user.getPass_user());
        return (int) sqLiteDatabase.insert("tbl_user",null,values);
    }
    public int update(User user) {
        ContentValues values = new ContentValues();
        values.put("name_user",user.getName_user());
        values.put("pass_user",user.getPass_user());
        return sqLiteDatabase.update("tbl_user", values, "id_user=?", new String[]{String.valueOf(user.getId_user())});
    }

    public int delete(int ID) {
        return sqLiteDatabase.delete("tbl_user", "id_user=?", new String[]{String.valueOf(ID)});
    }
    public ArrayList<User> getData(String sql, String... SelectAvgs) {
        ArrayList<User> lst = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, SelectAvgs);
        while (cursor.moveToNext()) {
            User ob=new User();
            ob.setId_user(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id_user"))));
            ob.setName_user(cursor.getString(cursor.getColumnIndex("name_user")));
            ob.setPass_user(cursor.getString(cursor.getColumnIndex("pass_user")));
            lst.add(ob);
        }
        return lst;
    }

    public ArrayList<User> getAllData() {
        String sql = "SELECT * FROM tbl_user";
        return getData(sql);
    }

    public User getByID(String id) {
        String sql = "SELECT * FROM tbl_user where name_user=?";
        return getData(sql, id).get(0);
    }
    public boolean checkLogin(String names,String password){
        String sql="SELECT * FROM tbl_user WHERE name_user=? AND pass_user=?";
        ArrayList<User> list=getData(sql,names,password);
        if(list.size()==0){
            return false;
        }
        return true;
    }

}
