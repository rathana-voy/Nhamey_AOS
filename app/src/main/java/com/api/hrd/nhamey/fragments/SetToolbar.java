package com.api.hrd.nhamey.fragments;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by RATHANA on 15-Jan-17.
 */

public interface SetToolbar {
    void getViews(View... views);
    void getViews(TabLayout.Tab tab);
    void DrawerToggleButtonHandle();
}
