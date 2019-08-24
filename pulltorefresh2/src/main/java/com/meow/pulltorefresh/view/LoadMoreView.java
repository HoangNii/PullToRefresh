package com.meow.pulltorefresh.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.meow.pulltorefresh.R;

public class LoadMoreView extends FrameLayout implements FooterView {

    private TextView tv;
    private ImageView arrow;
    private ProgressBar progressBar;

    public LoadMoreView(Context context) {
        this(context,null);
    }

    public LoadMoreView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LoadMoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_header,null);
        addView(view);
        tv = view.findViewById(R.id.header_tv);
        arrow = view.findViewById(R.id.header_arrow);
        progressBar = view.findViewById(R.id.header_progress);
    }

    @Override
    public void begin() {

    }

    @Override
    public void progress(float progress, float all) {
        float s = progress / all;
        if (s >= 0.9f){
            arrow.setRotation(0);
        }else{
            arrow.setRotation(180);
        }
        if (progress >= all-10){
            tv.setText("Đang cập nhập...");
        }else{
            tv.setText("Kéo lên..");
        }
    }

    @Override
    public void finishing(float progress, float all) {

    }

    @Override
    public void loading() {
        arrow.setVisibility(GONE);
        progressBar.setVisibility(VISIBLE);
        tv.setText("Đang tải...");
    }

    @Override
    public void normal() {
        arrow.setVisibility(VISIBLE);
        progressBar.setVisibility(GONE);
        tv.setText("Kéo lên tải");
    }

    @Override
    public View getView() {
        return this;
    }
}
