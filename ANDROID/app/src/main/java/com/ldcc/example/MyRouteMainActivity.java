package com.ldcc.example;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRouteMainActivity extends AppCompatActivity implements RouteRecycleViewAdapter.OnItemClickListener {


    private RecyclerView recyclerview;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routemain);


        Button btn1 = (Button) findViewById(R.id.btn1);
        ImageButton imagebtn1 = (ImageButton) findViewById(R.id.imageButton1);

        recyclerview = (RecyclerView) findViewById(R.id.recycleview1);  /// 리사이클러뷰 초기화
        recyclerview.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL)); ///구분선 넣어주는 옵션
        linearLayoutManager = new LinearLayoutManager(this); // 레이아웃 매니져
        recyclerview.setLayoutManager(linearLayoutManager); // 리사이클러뷰에 set 해준다 .
        ArrayList<RecycleViewItem> dataList = new ArrayList<>(); // 어댑터 선언
        RouteRecycleViewAdapter adapter = new RouteRecycleViewAdapter(dataList); // 어댑터에 어레이리스트 넣어준다.
        recyclerview.setAdapter(adapter);// 리사이클러뷰에 어댑터 set 해준다

        RecycleViewItem item = new RecycleViewItem();
        dataList.add(new RecycleViewItem(R.drawable.seoul_image,"가족과 함께한 제주 여행","2023.07.01 ~ 2023.08.31", false));
        dataList.add(new RecycleViewItem(R.drawable.seoul_image,"처음 갔던 제주 여행","2023.06.01 ~ 2023.06.31", false));


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면전환
                Intent intent = new Intent(MyRouteMainActivity.this, MyRouteRegistrationActivity.class);
                startActivity(intent);
            }
        });

        imagebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }


    @Override
    public void onItemClicked(int position) {

    }


}
