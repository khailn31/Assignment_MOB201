package khailnph29864.fpoly.assignment_mob201.Fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import khailnph29864.fpoly.assignment_mob201.Adapter.FragAdapter;
//import khailnph29864.fpoly.assignment_mob201.Adapter.NewsAdapter;
//import khailnph29864.fpoly.assignment_mob201.DAO.NewsDAO;
import khailnph29864.fpoly.assignment_mob201.OB.News;
import khailnph29864.fpoly.assignment_mob201.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NEWSFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NEWSFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private FragAdapter fragAdapter;
    public NEWSFragment() {
        // Required empty public constructor
    }


    public static NEWSFragment newInstance() {
        NEWSFragment fragment = new NEWSFragment();

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
        return inflater.inflate(R.layout.fragment_n_e_w_s, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout=view.findViewById(R.id.id_tablayout);
        viewPager=view.findViewById(R.id.viewpaper);
        fragAdapter=new FragAdapter((FragmentActivity) getContext());
        viewPager.setAdapter(fragAdapter);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Thể Thao");
                        break;
                    case 1:
                        tab.setText("Thời sự ");
                        break;
                    case 2:
                        tab.setText("Khoa học");
                        break;
                }
            }
        }).attach();


    }
}