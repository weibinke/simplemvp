package com.kb.mvplibrary;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Weibinke on 2018/11/4.
 */
public abstract class AbstractMvpActivity <V extends BaseView, P extends BasePresenter<V>>extends Activity implements BaseView{

    private static final String TAG = "AbstractMvpActivity";
    private P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter == null){
            mPresenter = createPresenter();
        }

        if(mPresenter != null){
            mPresenter.attachView((V) this);
            mPresenter.onCreatePresenter(savedInstanceState);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.detachView();
        }
    }

    abstract protected P createPresenter();

    public P getPresenter(){
        return mPresenter;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenter != null){
            mPresenter.onSaveInstanceState(outState);
        }
    }
}
