package com.ldcc.example;
import android.graphics.drawable.Drawable;

//데이터 변경 할 때 쓰는 클래스
public class ListViewBtnItem {
    private Drawable iconDrawable ;
    private String textStr ;

    public void setText(String text) {
        textStr = text ;
    }

    public String getText() {
        return this.textStr ;
    }
}
