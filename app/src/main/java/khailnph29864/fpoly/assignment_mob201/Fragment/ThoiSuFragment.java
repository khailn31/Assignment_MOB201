package khailnph29864.fpoly.assignment_mob201.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import khailnph29864.fpoly.assignment_mob201.DownloadTinTuc;
import khailnph29864.fpoly.assignment_mob201.R;


public class ThoiSuFragment extends Fragment {
    ListView lv;
    DownloadTinTuc downloadTinTuc;
    public ThoiSuFragment() {
        // Required empty public constructor
    }

    public static ThoiSuFragment newInstance() {
        ThoiSuFragment fragment = new ThoiSuFragment();
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
        return inflater.inflate(R.layout.fragment_thoi_su, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv=view.findViewById(R.id.lv_ts);
        downloadTinTuc=new DownloadTinTuc(getContext(),lv);
        String urlRss = "https://vnexpress.net/rss/suc-khoe.rss";
        downloadTinTuc.execute(urlRss );

    }
}