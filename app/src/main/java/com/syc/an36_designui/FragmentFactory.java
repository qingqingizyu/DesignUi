package com.syc.an36_designui;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

/**
 * 类描述:
 * 创建人:一一哥
 * 创建时间:16/9/26 14:37
 * 备注:
 */

class FragmentFactory {

    private static SparseArray<Fragment> fragments = new SparseArray<>();
    private static final int ARMY_FRAGMENT = 0;
    private static final int SOCINCE_FRAGMENT = 1;
    private static final int ENTERMAIN_FRAGMENT = 2;
    private static final int SOCIETY_FRAGMENT = 3;
    private static final int SPORT_FRAGMENT = 4;

    //创建Fragment的工厂方法
    static Fragment createFragment(int key, String msg) {
        Fragment fragment = fragments.get(key);
        if (fragment == null) {
            switch (key) {
                case ARMY_FRAGMENT:
                case SOCINCE_FRAGMENT:
                case ENTERMAIN_FRAGMENT:
                case SOCIETY_FRAGMENT:
                case SPORT_FRAGMENT:
                    fragment = ContentFragment.createInstance(msg);
                    break;
            }

            fragments.put(key, fragment);
        }

        return fragment;
    }
}
