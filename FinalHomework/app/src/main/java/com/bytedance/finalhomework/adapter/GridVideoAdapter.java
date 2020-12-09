package com.bytedance.finalhomework.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bytedance.finalhomework.R;
import com.bytedance.finalhomework.activity.PlayListActivity;
import com.bytedance.finalhomework.base.BaseRvAdapter;
import com.bytedance.finalhomework.base.BaseRvViewHolder;
import com.bytedance.finalhomework.base.VideoBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridVideoAdapter extends BaseRvAdapter<VideoBean, GridVideoAdapter.GridVideoViewHolder> {

    public GridVideoAdapter(Context context, List<VideoBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(GridVideoViewHolder holder, VideoBean videoBean, int position) {
        holder.ivCover.setBackgroundResource(videoBean.getCoverRes());//封面
        holder.tvContent.setText("#" +videoBean.getUserBean().getNickName()+ "#" + videoBean.getContent());//作者名字+附加信息

        holder.itemView.setOnClickListener(v -> {
            //点击播放事件
            PlayListActivity.initPos = position;
            context.startActivity(new Intent(context, PlayListActivity.class));
        });
    }

    @NonNull
    @Override
    public GridVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //绑定一个LinearLayout，包含视频封面，附加内容，可以在附加内容里添加一下用户名
        View view = LayoutInflater.from(context).inflate(R.layout.item_gridvideo, parent, false);
        return new GridVideoViewHolder(view);
    }

    public class GridVideoViewHolder extends BaseRvViewHolder {
        @BindView(R.id.iv_cover)
        ImageView ivCover;
        @BindView(R.id.tv_content)
        TextView tvContent;

        public GridVideoViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}

