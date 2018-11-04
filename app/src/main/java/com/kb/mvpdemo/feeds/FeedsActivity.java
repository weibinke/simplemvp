package com.kb.mvpdemo.feeds;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.kb.mvpdemo.R;
import com.kb.mvplibrary.AbstractMvpActivity;

/**
 * Created by Weibinke on 2018/11/4.
 */
public class FeedsActivity extends AbstractMvpActivity<Feeds.IFeedsView,FeedsPresenter> implements Feeds.IFeedsView {
    public static final String KEY_MSG = "key_msg";
    private static final String TAG = "FeedsActivity";
    private TextView mTextMsg;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.feeds_activity);
        mTextMsg = findViewById(R.id.R_id_text_feeds_msg);
        getPresenter().loadFeeds();
    }

    @Override
    public void showLoading() {
        mTextMsg.setText("Loading...");
    }

    @Override
    public void showFeeds(String msg) {
        mTextMsg.setText(msg);
    }

    @Override
    protected FeedsPresenter createPresenter() {
        String channel = getIntent().getStringExtra(KEY_MSG);
        Log.i(TAG,"onCreate msg=" + channel);
        return new FeedsPresenter(channel);
    }
}
