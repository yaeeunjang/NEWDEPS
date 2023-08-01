package com.ldcc.example;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class CheckableLinearLayout extends LinearLayout implements Checkable {


    public CheckableLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        // mIsChecked = false ;
    }

    @Override
    public boolean isChecked() {
        RadioButton rb = (RadioButton) findViewById(R.id.listViewRadioButton) ;

        return rb.isChecked() ;

    }

    @Override
    public void toggle() {
        RadioButton rb = (RadioButton) findViewById(R.id.listViewRadioButton) ;

        setChecked(rb.isChecked() ? false : true) ;

    }

    @Override
    public void setChecked(boolean checked) {
        RadioButton rb = (RadioButton) findViewById(R.id.listViewRadioButton) ;

        if (rb.isChecked() != checked) {
            rb.setChecked(checked) ;
        }


    }
}
