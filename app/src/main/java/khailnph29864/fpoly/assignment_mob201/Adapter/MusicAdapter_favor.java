package khailnph29864.fpoly.assignment_mob201.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import khailnph29864.fpoly.assignment_mob201.OB.Music;
import khailnph29864.fpoly.assignment_mob201.R;

public class MusicAdapter_favor extends ArrayAdapter {
    Context context;
    int idLayout;
    List<Music> myList;

    public MusicAdapter_favor(Context context, int idLayout, List<Music> myList) {
        super(context, idLayout, myList);
        this.context = context;
        this.idLayout = idLayout;
        this.myList = myList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.layout_item_music, null);

        }
      Music music=myList.get(position);
        if ( music != null) {
       TextView tv=(TextView) view.findViewById(R.id.tv_name_music);
       tv.setText(music.getTitle());
        }
        return view;
    }

}
