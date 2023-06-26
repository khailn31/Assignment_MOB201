package khailnph29864.fpoly.assignment_mob201.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

//import khailnph29864.fpoly.assignment_mob201.DAO.NewsDAO;
import khailnph29864.fpoly.assignment_mob201.OB.News;
import khailnph29864.fpoly.assignment_mob201.R;

public class NewsAdapter extends ArrayAdapter {

    Context context;
    int idLayout;
    List<News> myList;

    public NewsAdapter(Context context, int idLayout,List<News> myList) {
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
            view = inflater.inflate(R.layout.layout_item_news, null);

        }
        News tinTuc = myList.get(position);
        if (tinTuc != null) {
            TextView tv = (TextView) view.findViewById(R.id.tv);
            tv.setText(tinTuc.getTitle());
            ImageView img = (ImageView) view.findViewById(R.id.img);
            Picasso.with(getContext()).load(tinTuc.getImg()).into(img);
        }
        return view;
    }
}
