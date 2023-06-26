package khailnph29864.fpoly.assignment_mob201;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import khailnph29864.fpoly.assignment_mob201.DAO.UserDAO;
import khailnph29864.fpoly.assignment_mob201.DAO.UserDAO;
import khailnph29864.fpoly.assignment_mob201.Service.checkLoginService;

public class LoginActivity extends AppCompatActivity {
EditText ed1,ed2;
UserDAO dao;
Button btn1;
TextView tv1;
CheckBox ckb;
    public final static String ACTION_CHECK_LOGIN = "Check_Login";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed1=findViewById(R.id.edUsername);
        ed2=findViewById(R.id.edPassword);
        ckb=findViewById(R.id.chkRemberPass);
        dao=new UserDAO(getApplicationContext());
        btn1=findViewById(R.id.btnLogin);
        tv1=findViewById(R.id.tv_reg);
        Intent i1=new Intent(this,RegActivity.class);
//        Dialog dialog=new Dialog(this);
//        dialog.setContentView(R.layout.layout_dialog_login);
//        Button btn2=dialog.findViewById(R.id.btn_tk);
//        Button btn3=dialog.findViewById(R.id.btn_khach);
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(i);
//                finish();
//
//            }
//        });
//
//        dialog.show()
        SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        String user = pref.getString("user", "");
        String pass = pref.getString("pass", "");
        Boolean rem = pref.getBoolean("remember", false);
        ed1.setText(user);
        ed2.setText(pass);
        ckb.setChecked(rem);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = ed1.getText().toString();
                String pass = ed2.getText().toString();
                if (user.length() == 0) {
                    ed1.requestFocus();
                    ed1.setError("Vui lòng nhập tên đăng nhập");
                } else if (pass.length() == 0) {
                    ed2.requestFocus();
                    ed2.setError("Vui lòng nhập mật khẩu");
                }

                // Gọi Intent
                Intent intent = new Intent(LoginActivity.this, checkLoginService.class);
                //Gọi Bundle == > Gửi data
                Bundle bundle = new Bundle();
                bundle.putString("user", user);
                bundle.putString("pass", pass);
                intent.putExtras(bundle);
                //goi starService
                startService(intent);

            }
        });

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i1);
//                finish();
            }
        });
    }
    public void rememberUser(String u, String p, boolean status) {
        SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        if (!status) {
            edit.clear();

        } else {
            edit.putString("user", u);
            edit.putString("pass", p);
            edit.putBoolean("remember",status);
        }
        edit.commit();
    }



    @Override
    protected void onResume() {
        super.onResume();
        register_check();
    }
    private void register_check() {
        IntentFilter intentFilter = new IntentFilter(LoginActivity.ACTION_CHECK_LOGIN);
        this.registerReceiver(myBroadcast,intentFilter);
    }

    public BroadcastReceiver myBroadcast=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "Check_Login":
                    Bundle bundle=intent.getExtras();
                    boolean check=bundle.getBoolean("check");
                    if(check==true){
                        Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        rememberUser(ed1.getText().toString(),ed2.getText().toString(),ckb.isChecked());
                        Intent i=new Intent(LoginActivity.this,MainActivity.class);
                        i.putExtra("user",ed1.getText().toString());
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(context, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:
                    break;
            }
        }
    };
}