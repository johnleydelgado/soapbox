package com.robert.soapbox.Adapter;




import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.robert.soapbox.Model.postData;
import com.robert.soapbox.R;
import com.robert.soapbox.View.ContentQue;

import java.util.ArrayList;

public class post_adapter extends RecyclerView.Adapter<post_adapter.MyViewHolder> {

    private ArrayList<postData> dataSet;

    public static Integer[] drawableArray = {};


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewDate;
        TextView textViewContent;
        ImageView imageViewIcon;
        CardView cView;
        Button readMore;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = itemView.findViewById(R.id.textview_title);
            this.imageViewIcon = itemView.findViewById(R.id.imageView);
            this.textViewDate = itemView.findViewById(R.id.textview_date);
            this.textViewContent = itemView.findViewById(R.id.textview_content);
            this.cView = itemView.findViewById(R.id.card_view);
           // this.readMore = itemView.findViewById(R.id.readmoreButton);

        }
    }

    public post_adapter(ArrayList<postData> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);

        view.setOnClickListener(ContentQue.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewDate = holder.textViewDate;
        TextView textViewContent = holder.textViewContent;

        ImageView imageView = holder.imageViewIcon;
        //Button readmoreButton = holder.readMore;
       // int imageArrayNumber = ContentQue.numberDrawable;

        textViewName.setText(dataSet.get(listPosition).getTitle());
        textViewDate.setText(dataSet.get(listPosition).getDate());
        textViewContent.setText(dataSet.get(listPosition).getContent());
        imageView.setImageResource(R.drawable.ic_eighth);
        holder.cView.setCardBackgroundColor(Color.parseColor(dataSet.get(listPosition).getColor()));
//        readmoreButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                int position = listPosition;
//                //Log.d("tag1",""+position);
//                String contentText = dataSet.get(position).getContent();
//                Intent intent = new Intent(v.getContext(),ContentActivity.class);
//                intent.putExtra("content",contentText);
//                v.getContext().startActivity(intent);
//                /// button click event
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

