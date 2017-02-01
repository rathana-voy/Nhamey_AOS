package com.api.hrd.nhamey.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.api.hrd.nhamey.R;

/**
 * Created by rathana on 10/1/17.
 */

public class FavoriteFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.from(container.getContext()).inflate(R.layout.favorite_fragment_layout,container,false);
    }

    public interface FavoriteFragmentHandler extends SetToolbar{


    }
}
