package com.kb.mvplibrary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by Weibinke on 2018/11/4.
 */
public abstract class AbstractMvpFragment <V extends BaseView, P extends BasePresenter<V>> extends Fragment implements BaseView {
    private P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter == null){
            mPresenter = createPresenter();
        }

        if (mPresenter != null) {
            mPresenter.attachView((V) this);
            mPresenter.onCreatePresenter(savedInstanceState);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.detachView();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenter != null){
            mPresenter.onSaveInstanceState(outState);
        }
    }

    protected P getPresenter(){
        return mPresenter;
    }

    protected abstract P createPresenter();
}
