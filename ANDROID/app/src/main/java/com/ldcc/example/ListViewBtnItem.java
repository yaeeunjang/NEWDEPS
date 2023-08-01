package com.ldcc.example;
import android.graphics.drawable.Drawable;

//데이터 변경 할 때 쓰는 클래스
public class ListViewBtnItem {
    private Drawable iconDrawable ;
    private String textStr ;
    private int selectedIndex;

    public void setText(String text) {
        textStr = text ;
    }

    public void setSelectedIndex(int index) {selectedIndex = index; }
    public String getText() {
        return this.textStr ;
    }

    public int getSelectedIndex() { return this.selectedIndex; }
}
