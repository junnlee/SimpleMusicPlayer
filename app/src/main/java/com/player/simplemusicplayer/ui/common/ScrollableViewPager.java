package com.player.simplemusicplayer.ui.common;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ScrollableViewPager extends ViewPager {

    private boolean scrollable = true;

    private TabLayout tabLayout;

    public ScrollableViewPager(@NonNull Context context) {
        super(context);
    }

    public ScrollableViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollableViewPager(@NonNull Context context, @Nullable AttributeSet attrs, boolean scrollable) {
        super(context, attrs);
        this.scrollable = scrollable;
    }

    /**
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        if (!scrollable){
            return false;
        }

        return super.onTouchEvent(ev);
    }

    /**
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (!scrollable){
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }


    public boolean isScrollable(){
        return this.scrollable;
    }

    public void setScrollable(boolean scrollable){
        this.scrollable = scrollable;
    }



}
