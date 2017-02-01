package com.api.hrd.nhamey.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.fragments.RestaurantFragment;
import com.api.hrd.nhamey.models.api_respone.RestType;
import com.api.hrd.nhamey.util.DataOptionClick;
import com.api.hrd.nhamey.util.layout.DataAdapterProvider;
import com.api.hrd.nhamey.util.layout.DataProviderMapPage;

import java.util.ArrayList;

import layout.content_listview;
import layout.content_mapview;

/**
 * Created by RATHANA on 21-Jan-17.
 */

public class RestaurantCategoryDiaglogFragment extends DialogFragment {

    private static String cats[] ;
    private DataAdapterProvider<RestType.DATA> dataDataAdapterProvider;
    private DataProviderMapPage<RestType.DATA> dataProviderMapPage;
    private int position;

    static ArrayList<RestType.DATA> restTypes;

    public RestaurantCategoryDiaglogFragment(){};
    public static RestaurantCategoryDiaglogFragment newInstance(String title  ,ArrayList<RestType.DATA> restTypesData){
        RestaurantCategoryDiaglogFragment frag =new RestaurantCategoryDiaglogFragment();
        restTypes=restTypesData;
        if(restTypesData!=null){
            cats =new String[restTypesData.size()];
            for(int i=0;i<restTypesData.size();i++) {
                cats[i]=restTypesData.get(i).getRestype_name() !=null ? restTypesData.get(i).getRestype_name() :"";
            }
        }
        Bundle args=new Bundle();
        args.putString("TITLE",title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.dataDataAdapterProvider = new content_listview();
        this.dataProviderMapPage =new content_mapview();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("TITLE");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setIcon(R.drawable.ic_restaurant_menu_white_24dp);
        alertDialogBuilder.setSingleChoiceItems(cats, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                position=i;
            }
        });

        alertDialogBuilder.setPositiveButton("OK",  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // on success
                //categoryOptionHandler.getRestType(restTypes.get(position));
                dataDataAdapterProvider.setData(restTypes.get(position),getActivity(),true);
                dataProviderMapPage.setData(restTypes.get(position),getActivity(),true);
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        return alertDialogBuilder.create();

    }

    public interface CategoryOptionHandler{
        void getRestType(RestType.DATA restType);
    }
}
