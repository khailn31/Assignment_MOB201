package khailnph29864.fpoly.assignment_mob201;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import khailnph29864.fpoly.assignment_mob201.Service.RegService;

public class RegActivity extends AppCompatActivity {
EditText ed1,ed2,ed3;
Button btn1;
    public final static String ACTION_REGISTER = "Register";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ed1=findViewById(R.id.ed_name_reg);
        ed2=findViewById(R.id.ed_pass_reg);
        ed3=findViewById(R.id.ed_repass_reg);
        btn1=findViewById(R.id.btn_save_reg);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ed1.getText().toString();
                String password = ed2.getText().toString();
                String repass = ed3.getText().toString();
                if (username.length() == 0 || password.length() == 0 || repass.length() == 0) {
                    Toast.makeText(RegActivity.this, "Vui lòng nhập thông tin", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(repass)){
                    Toast.makeText(RegActivity.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                } else{
                    Intent intent = new Intent(RegActivity.this, RegService.class);
                    //Gọi Bundle == > Gửi data
                    Bundle bundle = new Bundle();
                    bundle.putString("user", username);
                    bundle.putString("pass", password);
//                bundle.putString("repass", repass);
                    intent.putExtras(bundle);
                    //goi starService
                    startService(intent);
                }
                // Gọi Intent

            }
        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        register_user();
    }
    private void register_user() {
        IntentFilter intentFilter = new IntentFilter(RegActivity.ACTION_REGISTER);
        this.registerReceiver(myBroadcast,intentFilter);
    }


    public BroadcastReceiver myBroadcast=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "Register":
                    Bundle bundle=intent.getExtras();
                    int check=bundle.getInt("check");
                    if(check>0){
                        Toast.makeText(context, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(RegActivity.this,LoginActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(context, "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:
                    break;
            }
        }
    };
}