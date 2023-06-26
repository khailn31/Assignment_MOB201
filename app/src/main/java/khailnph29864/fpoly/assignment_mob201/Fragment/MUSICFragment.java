package khailnph29864.fpoly.assignment_mob201.Fragment;

import static androidx.core.content.ContextCompat.createDeviceProtectedStorageContext;
import static androidx.core.content.ContextCompat.getSystemService;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

//import khailnph29864.fpoly.assignment_mob201.Adapter.MusicAdapter;
//import khailnph29864.fpoly.assignment_mob201.DAO.MusicDAO;
import khailnph29864.fpoly.assignment_mob201.Adapter.MusicAdapter;
//import khailnph29864.fpoly.assignment_mob201.DAO.MusicDAO;
import khailnph29864.fpoly.assignment_mob201.MainActivity;
import khailnph29864.fpoly.assignment_mob201.MyListActivity;
import khailnph29864.fpoly.assignment_mob201.OB.Music;
import khailnph29864.fpoly.assignment_mob201.R;
import khailnph29864.fpoly.assignment_mob201.Service.MusicService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MUSICFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MUSICFragment extends Fragment {
    RecyclerView recy;
    MusicAdapter adapter;
    private FloatingActionButton flb;

    ImageView img1, btn_prev, btn_play, btn_next, btn_stop;
    //        private MusicDAO dao;
    private ArrayList<Music> arr_music;
    ListView lv;

    TextView tv_name;
    int potion = 0;
    boolean isPlaying = false;

    public MUSICFragment() {
        // Required empty public constructor
    }

    public static MUSICFragment newInstance() {
        MUSICFragment fragment = new MUSICFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        arr_music = new ArrayList<>();
        addSong();

        return inflater.inflate(R.layout.fragment_m_u_s_i_c, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        flb = view.findViewById(R.id.flAdd_music);
//        recy = view.findViewById(R.id.recy_music);
//        dao=new MusicDAO(getContext());
//        arr_music=dao.getAllData();

        btn_prev = view.findViewById(R.id.btn_prev);
        btn_play = view.findViewById(R.id.btn_play);
        btn_next = view.findViewById(R.id.btn_next);
        btn_stop = view.findViewById(R.id.btn_stop);
        tv_name = view.findViewById(R.id.tv_ten_music);


        Intent intent = new Intent(getContext(), MusicService.class);
        adapter = new MusicAdapter(getContext(),arr_music);
        recy=view.findViewById(R.id.recy);
        RecyclerView   rc =view.findViewById(R.id.recy);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rc.setLayoutManager(linearLayoutManager);
        recy.setAdapter(adapter);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Music music = arr_music.get(i);
//                tv_name.setText(music.getTitle());
//                intent.putExtra("file", music.getFile());
//                potion = i;
//                if (((MainActivity) getContext()).isMyServiceRunning(MusicService.class)) {
////                    text.setText("Stoped");
//                    getContext().stopService(intent);
//                    isPlaying = false;
//                }
//                getContext().startService(intent);
//                isPlaying = true;
//            }
//        });
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((MainActivity) getContext()).isMyServiceRunning(MusicService.class) == false) {
                    getContext().startService(intent);
                    isPlaying = true;
                } else {
                    if (isPlaying) {
//                    btn1.setImageResource(R.drawable.ic_baseline_pause_circle_24);
                        getContext().sendBroadcast(new Intent(MusicService.ACTION_PAUSE));
                        isPlaying = false;

                        btn_play.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                    } else {
//                    btn1.setImageResource(R.drawable.ic_baseline_play_circle_24);
                        getContext().sendBroadcast(new Intent(MusicService.ACTION_RESUME));
                        isPlaying = true;
                        btn_play.setImageResource(R.drawable.ic_baseline_pause_24);
                    }
                }

            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isPlaying = false;
                getContext().stopService(intent);
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                potion++;
                if (potion > arr_music.size() - 1) {
                    potion = 0;
                }
                Music music = arr_music.get(potion);
                tv_name.setText(music.getTitle());
                intent.putExtra("file", music.getFile());
                if (((MainActivity) getContext()).isMyServiceRunning(MusicService.class)) {
                    getContext().stopService(intent);
                }
                isPlaying = true;
                getContext().startService(intent);

            }
        });
 btn_prev.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         potion--;
         if (potion <0) {
             potion =  arr_music.size() - 1;
         }
         Music music = arr_music.get(potion);
         tv_name.setText(music.getTitle());
         intent.putExtra("file", music.getFile());
         if (((MainActivity) getContext()).isMyServiceRunning(MusicService.class)) {
             getContext().stopService(intent);
         }
         isPlaying = true;
         getContext().startService(intent);
     }
 });

//        img1 = view.findViewById(R.id.mylist);
//        Intent i = new Intent(getContext(), MyListActivity.class);
//        img1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(i);
//            }
//        });
    }

    private void addSong() {
        arr_music.add(new Music("Chúng ta của hiện tại", R.raw.bai1));
        arr_music.add(new Music("Tại vì sao", R.raw.bai2));
        arr_music.add(new Music("Anh không muốn bất công", R.raw.bai3));
        arr_music.add(new Music("Muộn rồi mà sao còn", R.raw.bai4));
        arr_music.add(new Music("Nấu ăn cho em", R.raw.bai5));
        arr_music.add(new Music("2h", R.raw.twoh));
        arr_music.add(new Music("Con trai cưng", R.raw.contraicung));
        arr_music.add(new Music("Con gái rượu", R.raw.congairuou));
        arr_music.add(new Music("Bao giờ lấy vợ", R.raw.baogiolayvo));
    }


}