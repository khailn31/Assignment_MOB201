package khailnph29864.fpoly.assignment_mob201.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.Nullable;

import khailnph29864.fpoly.assignment_mob201.DAO.UserDAO;
import khailnph29864.fpoly.assignment_mob201.OB.User;
import khailnph29864.fpoly.assignment_mob201.RegActivity;

public class RegService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();
        String username = bundle.getString("user");
        String password = bundle.getString("pass");
        // Khởi tạo lại dao
        UserDAO dao = new UserDAO(RegService.this);
        User user=new User();
        user.setName_user(username);
        user.setPass_user(password);
        int check = dao.insert(user);
        Intent intentBr = new Intent();
        Bundle bundleBr = new Bundle();
        bundleBr.putInt("check",check);
        intentBr.putExtras(bundleBr);
        intentBr.setAction("Register");
        sendBroadcast(intentBr);
        return super.onStartCommand(intent, flags, startId);
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
