package com.example.ni.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private List<News> list;
    RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        initData();
        adapter = new RecyclerViewAdapter(list,MainActivity.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new News(getString(R.string.news_one_title),getString(R.string.news_one_desc),R.mipmap.news_one));
        list.add(new News(getString(R.string.news_two_title),getString(R.string.news_two_desc),R.mipmap.news_two));
    }
}
