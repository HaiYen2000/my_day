package com.lamlt.my_day.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lamlt.my_day.R;

public class NoteHolder extends RecyclerView.ViewHolder {

    public TextView tvTitle;
    public TextView tvContent;

    public NoteHolder(@NonNull View itemView) {
        super(itemView);
        this.tvTitle = itemView.findViewById(R.id.tvTitle);
        this.tvContent = itemView.findViewById(R.id.tvContent);
    }
}
