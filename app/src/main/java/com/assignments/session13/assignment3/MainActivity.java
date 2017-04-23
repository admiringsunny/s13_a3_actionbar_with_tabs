package com.assignments.session13.assignment3;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity
        implements ActionBar.TabListener, ViewPager.OnPageChangeListener {

//    Requirements:
//    No of tabs = 2 => Audio and video
//    Click Tab (using-> ActionBar.TabListener)
//    Swipe (Using -> ViewPager.OnPageChangeListener)

//         declare variables as per requirements
    static String[] tabNames;
    static int noOfTabs;
    ActionBar actionBar;
    ViewPager viewPager;
    TabsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//         implement tab_names array: in strings.xml
//         call tab_names array to initialize -> tabNames and noOfTabs
        tabNames = getResources().getStringArray(R.array.tab_names);
        noOfTabs = tabNames.length;

//         initialize actionBar and viewPager
        actionBar = getActionBar();
        viewPager = (ViewPager) findViewById(R.id.view_pager);

//         set up action bar
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

//         add tabs -> set name -> set listener
        for (String tabName : tabNames) {
            actionBar.addTab(actionBar.newTab().setText(tabName).setTabListener(this));
        }

//         attach Fragments
        adapter = new TabsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

//         set up view pager
//         on swiping the viewpager make respective tab selected
        viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
//         on changing the page
//         make respected tab selected
        actionBar.setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
//         on tab selected
//         show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
