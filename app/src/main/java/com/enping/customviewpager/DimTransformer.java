package com.enping.customviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

/**
 * Created by hsiehenping on 2017/7/29.
 */

class DimTransformer implements ViewPager.PageTransformer {
    private static final float DIM_ALPHA = 0.5f;
    private static final float MAX_ALPHA = 1f;
    private static final float SLIP_FACTOR = 0.2f;


    public void transformPage(View view, float position) {
        TextView tv = view.findViewById(R.id.tv);

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(MAX_ALPHA - DIM_ALPHA);
            tv.setTranslationX(-view.getWidth()*SLIP_FACTOR);


        } else if (position <= 1) { // [-1,1]
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.abs(position);
            tv.setTranslationX(position*view.getWidth()*SLIP_FACTOR);

            // Fade the page relative to its size.
            view.setAlpha(MAX_ALPHA - DIM_ALPHA*(scaleFactor));

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            tv.setTranslationX(view.getWidth()*SLIP_FACTOR);
            view.setAlpha(MAX_ALPHA - DIM_ALPHA);
        }
    }
}
