package khailnph29864.fpoly.assignment_mob201;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

//import khailnph29864.fpoly.assignment_mob201.Adapter.MusicAdapter;
//import khailnph29864.fpoly.assignment_mob201.DAO.MusicDAO;
import khailnph29864.fpoly.assignment_mob201.Adapter.MusicAdapter;
import khailnph29864.fpoly.assignment_mob201.Adapter.MusicAdapter_favor;
import khailnph29864.fpoly.assignment_mob201.OB.Music;

public class MyListActivity extends AppCompatActivity {
ListView lv;
//private MusicDAO dao;
private ArrayList<Music> list;
MusicAdapter_favor adapter1;
MusicAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_m_u_s_i_c_fa_vor);
        lv=findViewById(R.id.lv_music);
//        list = (ArrayList<Music>) adapter.lst_favor();
        adapter1=new MusicAdapter_favor(getApplicationContext(),android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter1);


    }
}