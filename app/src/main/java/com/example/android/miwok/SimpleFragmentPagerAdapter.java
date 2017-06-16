package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by luisp on 05/06/2017.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // Definition of constat for total number of pages
    final int PAGE_COUNT = 4;

    // Definition of Tab Tittles
    private String tabTitles[] = new String[] {
            "Numbers", "Family", "Colors", "Phrases"
    };

    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1){
            return new FamilyFragment();
        } else if (position ==2) {
            return new ColorsFragment();
        } else {
            return new PhrasesFragment();
        }
    }

    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}
