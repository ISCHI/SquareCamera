package com.desmond.squarecamera.helper;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Linda Werner on 02.05.17.
 */

public class CustomSquareImageView extends AppCompatImageView {

    public CustomSquareImageView(Context context) {
        super(context);
    }

    public CustomSquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSquareImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }
}
