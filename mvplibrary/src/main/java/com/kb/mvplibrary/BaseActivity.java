package com.kb.mvplibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Weibinke on 2018/11/4.
 */
public abstract class BaseActivity <V, P extends BasePresenter<V>>extends AppCompatActivity implements BaseView{

    private static final String TAG = "BaseActivity";
    private P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter == null){
            presenter = createPresenter();
        }

        if (presenter == null){
            Log.e(TAG,"onCreate presenter failed");

            finish();
            return;
        }
        presenter.attachView((V) this);
        presenter.onCreatePresenter(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.detachView();
        }
    }

    abstract protected P createPresenter();

    public P getPresenter(){
        return presenter;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (presenter != null){
            presenter.onSaveInstanceState(outState);
        }
    }
}
