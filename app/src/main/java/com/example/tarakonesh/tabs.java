package com.example.tarakonesh;

/*support telgram id =@javaprogrammer_eh
 * 24/03/1398
 * creted by elmira hossein zadeh*/

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class tabs extends AppCompatActivity {
    public static Toolbar toolbar;
    public static ViewPager viewPager;
    public static TabLayout tabLayout;
    TextView title;
    public static String Transaction_type;
    public static boolean flagTab, flagtabGzaresh;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        title = findViewById(R.id.txt_title);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
        adapter.addFrg(new daramad(), "درآمد ها");
        adapter.addFrg(new hazine(), "هزینه ها");
        adapter.addFrg(new gozaresh(), "گزارش ها");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.deposit);
        tabLayout.getTabAt(1).setIcon(R.drawable.withdrawal);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_description);
/////////////////////////////
        if (flagTab == true) {
            viewPager.setCurrentItem(1);
            flagtabGzaresh=false;
            flagTab=false;
        }
        if (flagtabGzaresh == true) {
            viewPager.setCurrentItem(3);
            flagtabGzaresh=false;
            flagTab=false;
        }

        ///////////////////////////


        if (tabLayout.getSelectedTabPosition() == 0) {
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                Window window = this.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(this.getResources().getColor(R.color.lightPurple));
            }
            toolbar.setBackgroundColor(ContextCompat.getColor(tabs.this,
                    R.color.lightPurple));
            tabLayout.setBackgroundColor(ContextCompat.getColor(tabs.this,
                    R.color.lightPurple));
            ChosoeTabs.setChooseTabDaramad("درآمد");
//            Log.i("taaaaaaaaabbbbbbbb", ChosoeTabs.getChooseTabDaramad());
            Transaction_type = ChosoeTabs.getChooseTabDaramad();
            title.setText(Transaction_type);
            title.setTextColor(this.getResources().getColor(R.color.withe));
//            Log.i(" تب اولییییییییییییییی", Transaction_type);
        } else if (tabLayout.getSelectedTabPosition() == 2) {
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                Window window = this.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(this.getResources().getColor(R.color.tab3dark));
            }
            toolbar.setBackgroundColor(ContextCompat.getColor(tabs.this,
                    R.color.tab3dark));
            tabLayout.setBackgroundColor(ContextCompat.getColor(tabs.this,
                    R.color.tab3dark));
            ChosoeTabs.setChooseTabGozaresh("گزارش");
//            Log.i("taaaaaaaaabbbbbbbb", ChosoeTabs.getChooseTabGozaresh());
            Transaction_type = ChosoeTabs.getChooseTabGozaresh();
//            Log.i("تب سومیییییییییییی", Transaction_type);
            title.setText(Transaction_type);
            title.setTextColor(this.getResources().getColor(R.color.withe));
        } else if (tabLayout.getSelectedTabPosition() == 1) {
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                Window window = this.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(this.getResources().getColor(R.color.tab1));
            }
            toolbar.setBackgroundColor(ContextCompat.getColor(tabs.this, R.color.tab1));
            tabLayout.setBackgroundColor(ContextCompat.getColor(tabs.this, R.color.tab1));
            ChosoeTabs.setChooseTabHazineh("هزینه");
//            Log.i("taaaaaaaaabbbbbbbb", ChosoeTabs.getChooseTabHazineh());
            Transaction_type = ChosoeTabs.getChooseTabHazineh();
//            Log.i("تب دوممممممممممممممم", Transaction_type);
            title.setText(Transaction_type);
            title.setTextColor(this.getResources().getColor(R.color.withe));
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 2) {
                    if (android.os.Build.VERSION.SDK_INT >= 21) {
                        Window window = tabs.this.getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        window.setStatusBarColor(tabs.this.getResources().getColor(R.color.tab3dark));
                    }
                    toolbar.setBackgroundColor(ContextCompat.getColor(tabs.this,
                            R.color.tab3dark));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(tabs.this,
                            R.color.tab3dark));
                    ChosoeTabs.setChooseTabGozaresh("گزارش");
//                    Log.i("taaaaaaaaabbbbbbbb", ChosoeTabs.getChooseTabGozaresh());
                    Transaction_type = ChosoeTabs.getChooseTabGozaresh();
//                    Log.i("تب سومیییییییییییی", Transaction_type);
                    title.setText(Transaction_type);
                    title.setTextColor(tabs.this.getResources().getColor(R.color.withe));
                } else if (tab.getPosition() == 1) {
                    if (android.os.Build.VERSION.SDK_INT >= 21) {
                        Window window = tabs.this.getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        window.setStatusBarColor(tabs.this.getResources().getColor(R.color.tab1));
                    }
                    toolbar.setBackgroundColor(ContextCompat.getColor(tabs.this, R.color.tab1));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(tabs.this, R.color.tab1));
                    ChosoeTabs.setChooseTabHazineh("هزینه");
//                    Log.i("taaaaaaaaabbbbbbbb", ChosoeTabs.getChooseTabHazineh());
                    Transaction_type = ChosoeTabs.getChooseTabHazineh();
//                    Log.i("تب دوممممممممممممممم", Transaction_type);
                    title.setText(Transaction_type);
                    title.setTextColor(tabs.this.getResources().getColor(R.color.withe));
                } else if (tab.getPosition() == 0) {
                    if (android.os.Build.VERSION.SDK_INT >= 21) {
                        Window window = tabs.this.getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        window.setStatusBarColor(tabs.this.getResources().getColor(R.color.lightPurple));
                    }
                    toolbar.setBackgroundColor(ContextCompat.getColor(tabs.this,
                            R.color.lightPurple));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(tabs.this,
                            R.color.lightPurple));
                    ChosoeTabs.setChooseTabDaramad("درآمد");
//                    Log.i("taaaaaaaaabbbbbbbb", ChosoeTabs.getChooseTabDaramad());
                    Transaction_type = ChosoeTabs.getChooseTabDaramad();
//                    Log.i(" تب اولییییییییییییییی", Transaction_type);
                    title.setText(Transaction_type);
                    title.setTextColor(tabs.this.getResources().getColor(R.color.withe));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
