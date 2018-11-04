package com.kb.mvpdemo.feeds;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.kb.mvplibrary.BasePresenter;

/**
 * Created by Weibinke on 2018/11/4.
 */
public class FeedsPresenter extends BasePresenter<Feeds.IFeedsView> implements Feeds.IFeedsPresenter {
    private String channel;
    public FeedsPresenter(String channel){
        this.channel = channel;
    }
    @Override
    public void loadFeeds() {
        Feeds.IFeedsView view = getView();
        if (view != null){
            getView().showLoading();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Feeds.IFeedsView view = getView();
                if (view != null){
                    getView().showFeeds("chanel result:" + channel);
                }
            }
        },3000);
    }

    @Override
    public void onCreatePresenter(@Nullable Bundle savedInstanceState) {
        super.onCreatePresenter(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
