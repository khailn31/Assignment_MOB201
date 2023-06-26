package khailnph29864.fpoly.assignment_mob201.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import khailnph29864.fpoly.assignment_mob201.DAO.UserDAO;
import khailnph29864.fpoly.assignment_mob201.OB.User;
import khailnph29864.fpoly.assignment_mob201.R;


public class USERFragment extends Fragment {
//UserDAO dao;
TextView tv1;

    public USERFragment() {
        // Required empty public constructor
    }


    public static USERFragment newInstance() {
        USERFragment fragment = new USERFragment();

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

        return inflater.inflate(R.layout.fragment_u_s_e_r, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        dao=new UserDAO(getContext());
        tv1=view.findViewById(R.id.tv_user);

//        User user1=dao.getByID("user");
//        String user_name=user1.getName_user();
//        tv1.setText(user_name);



    }
}