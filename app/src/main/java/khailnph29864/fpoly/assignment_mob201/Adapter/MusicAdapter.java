package khailnph29864.fpoly.assignment_mob201.Adapter;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//import khailnph29864.fpoly.assignment_mob201.DAO.MusicDAO;
//import khailnph29864.fpoly.assignment_mob201.DAO.NewsDAO;
import khailnph29864.fpoly.assignment_mob201.Fragment.MUSICFragment;
import khailnph29864.fpoly.assignment_mob201.MainActivity;
import khailnph29864.fpoly.assignment_mob201.OB.Music;
import khailnph29864.fpoly.assignment_mob201.R;
import khailnph29864.fpoly.assignment_mob201.Service.MusicService;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.myViewHolder>  {
    private Context context;
    private ArrayList<Music> list;

    public MusicAdapter(Context context, ArrayList<Music> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(context).inflate(R.layout.layout_item_music,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Music music=list.get(position);
        holder.tv1.setText(music.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MusicService.class);
//                ( MUSICFragment) ge)
                intent.putExtra("file", music.getFile());
               if (((MainActivity) context).isMyServiceRunning(MusicService.class)) {

                    context.stopService(intent);

                }
                context.startService(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(ArrayList<Music> lst){
        this.list=lst;notifyDataSetChanged();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        // Khai báo các View trong File Layout_item
     private TextView tv1;
     private ImageView img;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
        tv1=itemView.findViewById(R.id.tv_name_music);
        img=itemView.findViewById(R.id.img_like);
        }
}}
