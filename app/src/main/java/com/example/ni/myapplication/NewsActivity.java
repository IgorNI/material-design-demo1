package com.example.ni.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ni on 2017/1/22.
 */
public class NewsActivity extends Activity{
//    @BindView(R.id.cardview)
     CardView cardView;

//    @BindView(R.id.news_photo)
     ImageView news_photo;

//    @BindView(R.id.news_title)
     TextView news_title;

//    @BindView(R.id.news_desc)
     TextView news_Desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

//        ButterKnife.bind(this);
        news_photo = (ImageView) findViewById(R.id.news_info_photo);
        news_title = (TextView) findViewById(R.id.news_info_title);
        news_Desc = (TextView) findViewById(R.id.news_info_desc);
        Intent intent = getIntent();
        News item = (News) intent.getSerializableExtra("News");
//        int photo = item.getPhotoId();
        news_photo.setImageResource(item.getPhotoId());
        news_title.setText(item.getTitle());
        news_Desc.setText(item.getDescription());

    }
}
