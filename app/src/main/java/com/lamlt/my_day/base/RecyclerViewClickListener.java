package com.lamlt.my_day.base;

import android.view.View;

public interface RecyclerViewClickListener {

    void onClick(View view, int pos);

    void onLongClick(View view, int pos);

}
