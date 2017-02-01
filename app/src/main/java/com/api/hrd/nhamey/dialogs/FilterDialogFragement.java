package com.api.hrd.nhamey.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.api.hrd.nhamey.R;

/**
 * Created by KeeporderGO on 1/24/2017.
 */

public class FilterDialogFragement extends DialogFragment {
    private int selected;
    private FilterDialogFragement.FilterDialogHandler filterDialogHandler;

    public FilterDialogFragement() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Filter Favorite");
        builder.setIcon(R.drawable.sort_black_24);
        builder.setSingleChoiceItems(R.array.filter_items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selected = which;
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                filterDialogHandler = (FilterDialogHandler) getActivity();
                filterDialogHandler.OnOK(selected);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                FilterDialogFragement.this.getDialog().cancel();
            }
        });

        return builder.create();
    }

    public interface FilterDialogHandler {
        public void OnOK(int position);
    }
}
