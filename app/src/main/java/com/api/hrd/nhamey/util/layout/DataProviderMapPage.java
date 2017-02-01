package com.api.hrd.nhamey.util.layout;

import android.content.Context;

/**
 * Created by rathana on 27/1/17.
 */

public interface DataProviderMapPage<E> {

    void setData(E data , Context context,boolean isChange);
}
