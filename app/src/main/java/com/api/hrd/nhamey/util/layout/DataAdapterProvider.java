package com.api.hrd.nhamey.util.layout;

import android.content.Context;

import java.util.List;

/**
 * Created by RATHANA on 22-Jan-17.
 */

public interface DataAdapterProvider<E> {

  void setData(List<E> data);
  void setData(E data, Context context, boolean isChange);
  void setString(String s);

}
