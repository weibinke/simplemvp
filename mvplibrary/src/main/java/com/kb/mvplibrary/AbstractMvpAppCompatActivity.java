package com.kb.mvplibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Weibinke on 2018/11/5.
 */
public abstract class AbstractMvpAppCompatActivity <V extends BaseView, P extends BasePresenter<V>> extends AppCompatActivity implements BaseView{
    private static final String TAG = "AbstractMvpAppCompatActivity";
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
