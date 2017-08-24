package com.example.administrator.psalms.Util;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.psalms.R;

/**
 * Created by Administrator on 2017-08-03.
 */

public class CustomEditBox extends LinearLayout {


    public CustomEditBox(Context context) {
        super(context);
        init(context);
    }

    public CustomEditBox(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.custom_edit, this, false);
        addView(view);
    }

}
