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


public class KhoaHocFragment extends Fragment {

    ListView lv;
    DownloadTinTuc downloadTinTuc;
    public KhoaHocFragment() {
        // Required empty public constructor
    }

    public static KhoaHocFragment newInstance() {
        KhoaHocFragment fragment = new KhoaHocFragment();

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
        return inflater.inflate(R.layout.fragment_khoa_hoc, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv=view.findViewById(R.id.lv_kh);
        downloadTinTuc=new DownloadTinTuc(getContext(),lv);
        String urlRss = "https://vnexpress.net/rss/khoa-hoc.rss";
        downloadTinTuc.execute(urlRss );
    }
}