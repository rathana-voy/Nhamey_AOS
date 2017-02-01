package com.api.hrd.nhamey.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.api.hrd.nhamey.R;

/**
 * Created by rathana on 13/1/17.
 */

public class SortDialogFragment extends DialogFragment {
    private int selected;
    private SortDialogHandler sortDialogHandler;

    public SortDialogFragment() {
    }

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Sort Favorite");
        builder.setIcon(R.drawable.sort_black_24);
        builder.setSingleChoiceItems(R.array.sort_items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selected = which;
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                sortDialogHandler = (SortDialogHandler) getActivity();
                sortDialogHandler.OnOK(selected);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                SortDialogFragment.this.getDialog().cancel();
            }
        });

        return builder.create();
    }

    public interface SortDialogHandler {
        public void OnOK(int position);
    }
}
