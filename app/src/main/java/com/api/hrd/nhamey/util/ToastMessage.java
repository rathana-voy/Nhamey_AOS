package com.api.hrd.nhamey.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by rathana on 9/1/17.
 */

public class ToastMessage {
    public static void mesageLong(Context context,String sms){
       Toast.makeText(context,sms, Toast.LENGTH_LONG).show();
    }
    public static void mesageShort(Context context,String sms){
        Toast.makeText(context,sms, Toast.LENGTH_SHORT).show();
    }
}
