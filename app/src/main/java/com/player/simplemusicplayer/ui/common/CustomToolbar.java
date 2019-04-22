package com.player.simplemusicplayer.ui.common;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.player.simplemusicplayer.R;

public class CustomToolbar extends Toolbar {

    public CustomToolbar(Context context) {
        this(context, null);
    }

    public CustomToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init(){

    }

    public void setCustomTitle(String title){
        setTitleCenter(title);
    }


    public void setTitleCenter(String title) {
        for (int i = 0; i < this.getChildCount(); i++) {
            View view = this.getChildAt(i);
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                if (title.equals(textView.getText())) {
                    textView.setGravity(Gravity.CENTER);
                    Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.MATCH_PARENT);
                    params.gravity = Gravity.CENTER;
                    textView.setLayoutParams(params);
                }
            }
        }
        this.setTitle(title);
    }

    public void setToolbarBackBtn(OnClickListener onClickListener){
        setToolbarBackBtn(R.drawable.ic_back, onClickListener);
    }

    public void setToolbarBackBtn(int iconId, OnClickListener onClickListener){
        this.setNavigationIcon(iconId);
        this.setNavigationOnClickListener(onClickListener);
    }

}
