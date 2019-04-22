package com.player.simplemusicplayer.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class BaseActivity extends FragmentActivity {

    protected String TAG = this.getClass().getName();






    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
