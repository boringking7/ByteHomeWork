package com.bytedance.finalhomework.base;

import com.bytedance.finalhomework.R;

import java.util.ArrayList;
/*
* 从接口出接收数据*/
public class DataCreate {
    public static ArrayList<VideoBean> datas = new ArrayList<>();
    public static ArrayList<VideoBean.UserBean> userList = new ArrayList<>();

    public void initData() {

        VideoBean videoBeanOne = new VideoBean();
        videoBeanOne.setCoverRes(R.mipmap.cover1);//这里传封面
        videoBeanOne.setContent("#街坊 #颜值打分 给自己颜值打100分的女生集合");//这里传其他信息
        videoBeanOne.setVideoRes(R.raw.video1);
        videoBeanOne.setLiked(true);

        VideoBean.UserBean userBeanOne = new VideoBean.UserBean();
        userBeanOne.setUid(1);
        userBeanOne.setNickName("南京街坊");


        userList.add(userBeanOne);
        videoBeanOne.setUserBean(userBeanOne);

        VideoBean videoBeanTwo = new VideoBean();
        videoBeanTwo.setCoverRes(R.mipmap.cover2);
        videoBeanTwo.setContent("400 户摊主开进济南环联夜市，你们要的烟火气终于来了！");
        videoBeanTwo.setVideoRes(R.raw.video2);
        videoBeanTwo.setLiked(false);

        VideoBean.UserBean userBeanTwo = new VideoBean.UserBean();
        userBeanTwo.setUid(2);
        userBeanTwo.setNickName("民生直通车");

        userList.add(userBeanTwo);
        videoBeanTwo.setUserBean(userBeanTwo);

        VideoBean videoBeanThree = new VideoBean();
        videoBeanThree.setCoverRes(R.mipmap.cover3);
        videoBeanThree.setContent("科比生涯霸气庆祝动作，最后动作诠释了一生荣耀 #科比 @路人王篮球 ");
        videoBeanThree.setVideoRes(R.raw.video3);
        videoBeanThree.setLiked(false);

        VideoBean.UserBean userBeanThree = new VideoBean.UserBean();
        userBeanThree.setUid(3);
        userBeanThree.setNickName("七叶篮球");

        userList.add(userBeanThree);
        videoBeanThree.setUserBean(userBeanThree);

        VideoBean videoBeanFour = new VideoBean();
        videoBeanFour.setCoverRes(R.mipmap.cover4);
        videoBeanFour.setContent("美好的一天，从发现美开始 #莉莉柯林斯 ");
        videoBeanFour.setVideoRes(R.raw.video4);
        videoBeanFour.setLiked(false);

        VideoBean.UserBean userBeanFour = new VideoBean.UserBean();
        userBeanFour.setUid(4);
        userBeanFour.setNickName("一只爱修图的剪辑师");

        userList.add(userBeanFour);
        videoBeanFour.setUserBean(userBeanFour);

        VideoBean videoBeanFive = new VideoBean();
        videoBeanFive.setCoverRes(R.mipmap.cover5);
        videoBeanFive.setContent("有梦就去追吧，我说到做到。 #网球  #网球小威 ");
        videoBeanFive.setVideoRes(R.raw.video5);
        videoBeanFive.setLiked(false);

        VideoBean.UserBean userBeanFive = new VideoBean.UserBean();
        userBeanFive.setUid(5);
        userBeanFive.setNickName("国际网球联合会");

        userList.add(userBeanFive);
        videoBeanFive.setUserBean(userBeanFive);

        VideoBean videoBeanSix = new VideoBean();
        videoBeanSix.setCoverRes(R.mipmap.cover6);
        videoBeanSix.setContent("能力越大，责任越大，英雄可能会迟到，但永远不会缺席  #蜘蛛侠 ");
        videoBeanSix.setVideoRes(R.raw.video6);
        videoBeanSix.setLiked(true);

        VideoBean.UserBean userBeanSix = new VideoBean.UserBean();
        userBeanSix.setUid(6);
        userBeanSix.setNickName("罗鑫颖");

        userList.add(userBeanSix);
        videoBeanSix.setUserBean(userBeanSix);

        VideoBean videoBeanSeven = new VideoBean();
        videoBeanSeven.setCoverRes(R.mipmap.cover7);
        videoBeanSeven.setContent("真的拍不出来你的神颜！现场看大屏帅疯！#陈情令南京演唱会 #王一博 😭");
        videoBeanSeven.setVideoRes(R.raw.video7);
        videoBeanSeven.setLiked(false);

        VideoBean.UserBean userBeanSeven = new VideoBean.UserBean();
        userBeanSeven.setUid(7);
        userBeanSeven.setNickName("Sean");

        userList.add(userBeanSeven);
        videoBeanSeven.setUserBean(userBeanSeven);

        VideoBean videoBeanEight = new VideoBean();
        videoBeanEight.setCoverRes(R.mipmap.cover8);
        videoBeanEight.setContent("逆序只是想告诉大家，学了舞蹈的她气质开了挂！");
        videoBeanEight.setVideoRes(R.raw.video8);
        videoBeanEight.setLiked(false);

        VideoBean.UserBean userBeanEight = new VideoBean.UserBean();
        userBeanEight.setUid(8);
        userBeanEight.setNickName("曹小宝");

        userList.add(userBeanEight);
        videoBeanEight.setUserBean(userBeanEight);

        datas.add(videoBeanOne);
        datas.add(videoBeanTwo);
        datas.add(videoBeanThree);
        datas.add(videoBeanFour);
        datas.add(videoBeanFive);
        datas.add(videoBeanSix);
        datas.add(videoBeanSeven);
        datas.add(videoBeanEight);


        datas.add(videoBeanOne);
        datas.add(videoBeanTwo);
        datas.add(videoBeanThree);
        datas.add(videoBeanFour);
        datas.add(videoBeanFive);
        datas.add(videoBeanSix);
        datas.add(videoBeanSeven);
        datas.add(videoBeanEight);

    }
}
