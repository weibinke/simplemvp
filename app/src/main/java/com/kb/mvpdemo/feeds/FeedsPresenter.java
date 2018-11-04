package com.kb.mvpdemo.feeds;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kb.mvplibrary.BasePresenter;

/**
 * Created by Weibinke on 2018/11/4.
 */
public class FeedsPresenter extends BasePresenter<Feeds.IFeedsView> implements Feeds.IFeedsPresenter {
    @Override
    public void loadFeeds() {
        getView().showFeeds("Test feeds message");
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
