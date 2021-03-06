package com.bytedance.tiktok.fragment;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.bytedance.tiktok.R;
import com.bytedance.tiktok.base.BaseFragment;
import com.bytedance.tiktok.base.CommPagerAdapter;
import com.bytedance.tiktok.bean.PauseVideoEvent;
import com.bytedance.tiktok.utils.RxBus;
import java.util.ArrayList;

import butterknife.BindView;

/**
 * create by libo
 * create on 2020-05-19
 * description 主页fragment（）
 */
public class MainFragment extends BaseFragment {
    private CurrentLocationFragment currentLocationFragment;
    private RecommendFragment recommendFragment;//自动播放页面可以去掉
    private BlankFragment blankFragment;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tab_title)
    XTabLayout tabTitle;//顶部的海淀和推荐选项
    @BindView(R.id.tab_mainmenu)
    XTabLayout tabMainMenu;//底部的四个选项
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private CommPagerAdapter pagerAdapter;
    /** 默认显示第一页推荐页 */
    public static int curPage = 0;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void init() {
        setFragments();

        setMainMenu();
    }

    private void setFragments() {
        currentLocationFragment = new CurrentLocationFragment();
        recommendFragment = new RecommendFragment();
        blankFragment = new BlankFragment();
        fragments.add(currentLocationFragment);
        fragments.add(recommendFragment);
        fragments.add(blankFragment);

        tabTitle.addTab(tabTitle.newTab().setText("交大"));
        tabTitle.addTab(tabTitle.newTab().setText("推荐"));
        tabTitle.addTab(tabTitle.newTab().setText("关注"));

        pagerAdapter = new CommPagerAdapter(getChildFragmentManager(), fragments, new String[] {"交大", "推荐","关注"});
        viewPager.setAdapter(pagerAdapter);
        tabTitle.setupWithViewPager(viewPager);

        tabTitle.getTabAt(0).select();//默认推荐

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
/*
* 屏幕滚动过程中不断被调用
* 当用手指滑动时，如果手指按在页面上不动，position和当前页面index是一致的；如果手指向左拖动（相应页面向右翻动），
* 这时候position大部分时间和当前页面是一致的，只有翻页成功的情况下最后一次调用才会变为目标页面；如果手指向右拖动（相应页面向左翻动），
* 这时候position大部分时间和目标页面是一致的，只有翻页不成功的情况下最后一次调用才会变为原页面。*/
            }

            @Override
            /*
            * 这个方法有一个参数position，代表哪个页面被选中。当用手指滑动翻页的时候，如果翻动成功了（滑动的距离够长），
            * 手指抬起来就会立即执行这个方法，position就是当前滑动到的页面。
            * 如果直接setCurrentItem翻页，那position就和setCurrentItem的参数一致，这种情况在onPageScrolled执行方法前就会立即执行。*/
            public void onPageSelected(int position) {

                curPage = position;

                if (position == 1) {
                    //继续播放
                    RxBus.getDefault().post(new PauseVideoEvent(true));
                } else {
                    //切换到其他页面，需要暂停视频
                    RxBus.getDefault().post(new PauseVideoEvent(false));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                /*
                * 这个方法在手指操作屏幕的时候发生变化。有三个值：0（END）,1(PRESS) , 2(UP) 。
                * 当用手指滑动翻页时，手指按下去的时候会触发这个方法，state值为1，手指抬起时，
                * 如果发生了滑动（即使很小），这个值会变为2，然后最后变为0 。总共执行这个方法三次。
                * 一种特殊情况是手指按下去以后一点滑动也没有发生，这个时候只会调用这个方法两次，state值分别是1,0 。*/
            }
        });
    }

    private void setMainMenu() {
        tabMainMenu.addTab(tabMainMenu.newTab().setText("首页"));
        tabMainMenu.addTab(tabMainMenu.newTab().setText("朋友"));
        tabMainMenu.addTab(tabMainMenu.newTab().setText(""));
        tabMainMenu.addTab(tabMainMenu.newTab().setText("消息"));
        tabMainMenu.addTab(tabMainMenu.newTab().setText("我"));
    }

}
