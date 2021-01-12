package com.ly.myandroidapp.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomViewTest extends View {
    public CustomViewTest(Context context) {
        super(context);
    }

    public CustomViewTest(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomViewTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
