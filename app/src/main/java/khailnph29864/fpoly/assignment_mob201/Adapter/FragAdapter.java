package khailnph29864.fpoly.assignment_mob201.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import khailnph29864.fpoly.assignment_mob201.Fragment.KhoaHocFragment;
import khailnph29864.fpoly.assignment_mob201.Fragment.SKFragment;
import khailnph29864.fpoly.assignment_mob201.Fragment.ThoiSuFragment;

public class FragAdapter extends FragmentStateAdapter {
    public FragAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
               return new SKFragment();

            case 1:
               return new ThoiSuFragment();

            default:
                return new KhoaHocFragment();



        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
