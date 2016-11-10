package com.techmighty.rupeeexchangeprocess;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by avaria on 09/11/16.
 */

public class ContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int[] imagesArray = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten, R.drawable.eleven, R.drawable.twelve, R.drawable.thirteen, R.drawable.fourteen, R.drawable.fifteen};
    private Context mContext;

    public ContentAdapter(Context mContext){
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContentView(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ContentView content = (ContentView) holder;
        content.imageView.setImageDrawable(mContext.getResources().getDrawable(imagesArray[position]));
        content.textViewTitle.setText(mContext.getResources().getStringArray(R.array.titles)[position]);
        content.textViewDesc.setText(mContext.getResources().getStringArray(R.array.desc)[position]);
    }

    @Override
    public int getItemCount() {
        return imagesArray.length;
    }

    public class ContentView extends RecyclerView.ViewHolder {

        private TextView textViewTitle, textViewDesc;
        private ImageView imageView;

        public ContentView(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textViewTitle = (TextView) itemView.findViewById(R.id.title);
            textViewDesc = (TextView) itemView.findViewById(R.id.desc);

        }
    }
}
