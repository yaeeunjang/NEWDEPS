package com.ldcc.example;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MyRouteRegistrationActivity extends AppCompatActivity implements RouteListViewAdapter.ListBtnClickListener {

    @Override
    public void onListBtnClick(int position) {
        Toast.makeText(this, Integer.toString(position+1) + " Item is selected..", Toast.LENGTH_SHORT).show() ;
    }

    Uri uri;
    ImageView imageView;
    //달력 시작, 종료 일자 확인 플래그
    String currentSelectedBox = "";
    LinearLayout out_address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routeregistration);

        TextView textView13 = (TextView) findViewById(R.id.textView13);
        TextView textView12 = (TextView) findViewById(R.id.textView12);
        ImageButton imagebtn1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton imagebtn2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton imagebtn3 = (ImageButton) findViewById(R.id.imageButton3);
        Button btn1 = (Button) findViewById(R.id.btn4);
        Button add_btn = (Button) findViewById(R.id.add_btn);
        imageView = (ImageView) findViewById(R.id.imageView1) ;
        out_address = (LinearLayout) findViewById(R.id.out_address_layout);


        ListView listview ;
        RouteListViewAdapter adapter;
        ArrayList<ListViewBtnItem> items = new ArrayList<ListViewBtnItem>() ;

        createRouteList(items);

        adapter = new RouteListViewAdapter(this, R.layout.route_listview_item, items, this);

        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);
        // 리스트 뷰 아이템 클릭 시 이벤트
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // TODO : item click
            }
        }) ;


        // 달력 클릭 이벤트
        DatePickerDialog.OnDateSetListener listner = new DatePickerDialog.OnDateSetListener() {
            @Override
            // 날짜 값 받아오기
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                if(currentSelectedBox == "start") {
                    textView13.setText(year + "년" + (monthOfYear + 1) + "월" + dayOfMonth + "일");
                    currentSelectedBox = "";
                } else if(currentSelectedBox == "end") {
                    textView12.setText(year + "년" + (monthOfYear + 1) + "월" + dayOfMonth + "일");
                    currentSelectedBox = "";
                }
            }
        };
        Date dateNow = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy", Locale.getDefault());
        int year = Integer.parseInt(format.format(dateNow));
        format = new SimpleDateFormat("M", Locale.getDefault());
        int month = Integer.parseInt(format.format(dateNow));
        format = new SimpleDateFormat("dd", Locale.getDefault());
        int day = Integer.parseInt(format.format(dateNow));

        DatePickerDialog dialog = new DatePickerDialog(this, listner, year, month-1, day);
        imagebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                currentSelectedBox = "start";
                dialog.show();
            }
        });
        imagebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                currentSelectedBox = "end";
                dialog.show();
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

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                activityResultLauncher.launch(intent);

            }
        });

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createRouteList(items);
                adapter.notifyDataSetChanged();

            }
        });

    }

    public boolean createRouteList(ArrayList<ListViewBtnItem> list) {
        ListViewBtnItem item ;
        int i ;

        if (list == null) {
            list = new ArrayList<ListViewBtnItem>() ;
        }

        // 순서를 위한 i 값을 1로 초기화.
        i = 1 ;

        // 아이템 생성.
        item = new ListViewBtnItem() ;
        item.setText("주소를 입력해 주세요") ;
        list.add(item) ;
        i++ ;
        return true;
    }

    //갤러리에서 사진 불러오기
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Intent intent = result.getData();
                        uri = intent.getData();
                        Bitmap bitmap;

                        try {
                            if(Build.VERSION.SDK_INT>=28){
                                ImageDecoder.Source source = ImageDecoder.createSource(getContentResolver(),uri);
                                bitmap = ImageDecoder.decodeBitmap(source);
                            }
                            else {
                                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                                 }
                            Display display = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
                            DisplayMetrics outMetrics = new DisplayMetrics();
                            display.getMetrics(outMetrics);


                            int dpWidthValue = (int) imageView.getWidth(); // [dp 값 : width]
                            int dpHeightValue = (int) imageView.getHeight(); // [dp 값 : height]

                            bitmap = Bitmap.createScaledBitmap(bitmap, dpWidthValue, dpHeightValue, true);
                            imageView.setImageBitmap(bitmap);
                        }catch (FileNotFoundException e) {
                            e.printStackTrace();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    );

}