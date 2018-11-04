package com.kb.mvpdemo.feeds;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.kb.mvpdemo.R;
import com.kb.mvplibrary.BaseActivity;

/**
 * Created by Weibinke on 2018/11/4.
 */
public class FeedsActivity extends BaseActivity<Feeds.IFeedsView,FeedsPresenter> implements Feeds.IFeedsView {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.feeds_activity);
        getPresenter().loadFeeds();
    }

    @Override
    public void showFeeds(String msg) {
        TextView textView = findViewById(R.id.R_id_text_feeds_msg);
        textView.setText(msg);
    }

    @Override
    protected FeedsPresenter createPresenter() {
        return new FeedsPresenter();
    }
}
