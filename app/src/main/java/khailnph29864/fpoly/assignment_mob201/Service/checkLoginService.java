package khailnph29864.fpoly.assignment_mob201.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.Nullable;

import khailnph29864.fpoly.assignment_mob201.DAO.UserDAO;

public class checkLoginService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle=intent.getExtras();
        String user=bundle.getString("user");
        String pass=bundle.getString("pass");
        UserDAO dao=new UserDAO(this);
        boolean check=dao.checkLogin(user,pass);
        Intent i1=new Intent();
        Bundle bundle1=new Bundle();
        bundle1.putBoolean("check",check);
        i1.putExtras(bundle1);
        i1.setAction("Check_Login");
        sendBroadcast(i1);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
