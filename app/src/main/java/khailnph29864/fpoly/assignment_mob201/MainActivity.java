package khailnph29864.fpoly.assignment_mob201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import khailnph29864.fpoly.assignment_mob201.Fragment.MUSICFragment;
import khailnph29864.fpoly.assignment_mob201.Fragment.NEWSFragment;
import khailnph29864.fpoly.assignment_mob201.Fragment.USERFragment;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nav=findViewById(R.id.nav);
//        Intent i=getIntent();
//        String uer=i.getStringExtra("user")

    nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id=item.getItemId();
            switch (id){
                case R.id.music:
                    replaceFrag(MUSICFragment.newInstance());
                    break;
                case R.id.news:
                    replaceFrag(NEWSFragment.newInstance());
                    break;
                case R.id.user:
                    replaceFrag(USERFragment.newInstance());
                    break;
            }
            return true;
        }
    });
        replaceFrag(NEWSFragment.newInstance());
    }

    public void replaceFrag(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flContent, fragment);
        transaction.commit();

    }
    public  boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}