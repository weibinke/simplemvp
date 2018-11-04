package com.kb.mvpdemo.feeds;

/**
 * Created by Weibinke on 2018/11/4.
 */
public class Feeds {
    public interface IFeedsView{
        void showFeeds(String msg);
    }

    public interface IFeedsPresenter{
        void loadFeeds();
    }
}
