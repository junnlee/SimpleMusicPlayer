package com.player.simplemusicplayer.ui.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.player.simplemusicplayer.R;
import com.player.simplemusicplayer.ui.base.BaseActivity;
import com.player.simplemusicplayer.ui.base.BaseFragment;
import com.player.simplemusicplayer.ui.common.CustomToolbar;
import com.player.simplemusicplayer.ui.common.ScrollableViewPager;
import com.player.simplemusicplayer.ui.find.FindFragment;
import com.player.simplemusicplayer.ui.music.MusicFragment;
import com.player.simplemusicplayer.ui.setting.SettingFragment;
import com.player.simplemusicplayer.ui.user.UserFragment;
import com.player.simplemusicplayer.ui.video.VideoFragment;


public class MainActivity extends BaseActivity {

    private String[] tabTitles;

    private int[] tabImgs = {R.drawable.selector_main_tab_find,
            R.drawable.selector_main_tab_music,
            R.drawable.selector_main_tab_video,
            R.drawable.selector_main_tab_user,
            R.drawable.selector_main_tab_setting};

    CustomToolbar mainToolbar;
    ScrollableViewPager mainViewpager;
    TabLayout mainTabbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTabbar = findViewById(R.id.main_tabbar);
        mainViewpager = findViewById(R.id.main_viewpager);
        mainToolbar = findViewById(R.id.main_toolbar);

        init();
    }


    private void init() {

        tabTitles = getResources().getStringArray(R.array.fragment_titles);

        for (int i = 0; i < 5; i++) {
            TabLayout.Tab tab = mainTabbar.newTab();
            tab.setCustomView(getTabView(tabTitles[i], tabImgs[i]));
            mainTabbar.addTab(tab);
        }

        BaseFragment[] fragments = new BaseFragment[tabTitles.length];

        fragments[0] = new FindFragment();
        fragments[1] = new MusicFragment();
        fragments[2] = new VideoFragment();
        fragments[3] = new UserFragment();
        fragments[4] = new SettingFragment();

        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), tabTitles, fragments);
        mainViewpager.setAdapter(mainPagerAdapter);

        onTabChecked();
        onViewPagerChanged();

        mainToolbar.setToolbarBackBtn(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private View getTabView(String title, int imgSrc){
        View tabView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_tab_layout, null);

        TextView itemTextView = tabView.findViewById(R.id.item_tab_textview);
        ImageView itemImageView = tabView.findViewById(R.id.item_tab_imageview);

        itemTextView.setText(title);
        itemImageView.setBackgroundResource(imgSrc);

        return tabView;
    }


    private void onViewPagerChanged(){
        mainViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                mainTabbar.setScrollPosition(i, 0f, true);
                mainToolbar.setCustomTitle(tabTitles[i]);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }


    private void onTabChecked(){

        mainTabbar.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mainViewpager.setCurrentItem(tab.getPosition(), false);
                mainToolbar.setCustomTitle(tabTitles[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }





}
