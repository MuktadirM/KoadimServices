package com.muktadir.koadimservices.Modules.Adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> ListFragmnet = new ArrayList<>();
    private final List<String> FragmentTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public Fragment getItem(int position) {
        return ListFragmnet.get(position);
    }

    @Override
    public int getCount() {
        return FragmentTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentTitles.get(position);
    }

    public void AddFragment(Fragment fragment,String title){
        ListFragmnet.add(fragment);
        FragmentTitles.add(title);
    }
}
