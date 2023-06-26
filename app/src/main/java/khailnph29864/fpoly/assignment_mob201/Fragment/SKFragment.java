package khailnph29864.fpoly.assignment_mob201.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import khailnph29864.fpoly.assignment_mob201.DownloadTinTuc;
import khailnph29864.fpoly.assignment_mob201.OB.News;
import khailnph29864.fpoly.assignment_mob201.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SKFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SKFragment extends Fragment {
ListView lv;
DownloadTinTuc downloadTinTuc;


    public SKFragment() {
        // Required empty public constructor
    }


    public static SKFragment newInstance() {
        SKFragment fragment = new SKFragment();

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
        return inflater.inflate(R.layout.fragment_s_k, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv=view.findViewById(R.id.lv_sk);
        downloadTinTuc=new DownloadTinTuc(getContext(),lv);
        String urlRss = "https://vnexpress.net/rss/the-thao.rss";
        downloadTinTuc.execute(urlRss );


    }
}