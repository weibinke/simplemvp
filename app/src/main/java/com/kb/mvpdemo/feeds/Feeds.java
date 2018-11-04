package com.kb.mvpdemo.feeds;

import com.kb.mvplibrary.BaseView;

/**
 * Created by Weibinke on 2018/11/4.
 */
public class Feeds {
    public interface IFeedsView extends BaseView{
        void showLoading();
        void showFeeds(String msg);
    }

    public interface IFeedsPresenter{
        void loadFeeds();
    }
}
