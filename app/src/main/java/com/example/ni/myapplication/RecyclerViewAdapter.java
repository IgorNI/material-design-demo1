package com.example.ni.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindBitmap;
import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ni on 2017/1/22.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.NewsViewHolder> {

    private List<News> newsList;
    private Context context;

    public RecyclerViewAdapter(List newsList, Context context){
        this.newsList = newsList;
        this.context = context;
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;

//        @BindView(R.id.news_photo)
        ImageView news_photo;

        TextView news_title;

        TextView news_desc;

        Button btn_share;

        Button btn_more;

        public NewsViewHolder(View itemView) {
            super(itemView);
//            ButterKnife.bind(this,itemView);
            cardView= (CardView) itemView.findViewById(R.id.cardview);
            news_photo= (ImageView) itemView.findViewById(R.id.news_photo);
            news_title= (TextView) itemView.findViewById(R.id.news_title);
            news_desc= (TextView) itemView.findViewById(R.id.news_desc);
            btn_share= (Button) itemView.findViewById(R.id.btn_share);
            btn_more= (Button) itemView.findViewById(R.id.btn_more);
            //设置TextView背景为半透明
            news_title.setBackgroundColor(Color.argb(20, 0, 0, 0));
        }
    }

    @Override
    public RecyclerViewAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);
        NewsViewHolder viewHolder = new NewsViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

        final int j = position;
        holder.news_photo.setImageResource(newsList.get(position).getPhotoId());
        holder.news_title.setText(newsList.get(position).getTitle());
        holder.news_desc.setText(newsList.get(position).getDescription());

        //为cardView设置点击事件
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,NewsActivity.class);
                intent.putExtra("News",newsList.get(j));
                context.startActivity(intent);
            }
        });

        // 为share设置点击事件
        holder.btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
                intent.putExtra(Intent.EXTRA_TEXT, newsList.get(j).getDescription());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Intent.createChooser(intent, newsList.get(j).getTitle()));

            }
        });

        // 为more设置点击事件
        holder.btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,NewsActivity.class);
                intent.putExtra("News",newsList.get(j));
                context.startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return newsList.size();
    }

}
