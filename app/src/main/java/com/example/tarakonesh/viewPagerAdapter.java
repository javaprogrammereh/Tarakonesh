package com.example.tarakonesh;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class viewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> frgList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();


    public viewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return frgList.get(position);
    }

    @Override
    public int getCount() {
        return titleList.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);

    }

    public void addFrg(Fragment frg, String title) {
        frgList.add(frg);
        titleList.add(title);
    }

}
