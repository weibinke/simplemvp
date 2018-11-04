package com.kb.mvplibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Weibinke on 2018/11/4.
 */
public class BasePresenter<V extends BaseView>{
    private static final String TAG = "BasePresenter";
    private V view;

    public void attachView(V view){
        this.view = view;
        Log.i(TAG,"attachView");
    }

    public void detachView(){
        this.view = null;
        Log.i(TAG,"detachView");
    }

    public void onCreatePresenter(@Nullable Bundle savedInstanceState){
        Log.i(TAG,"onCreatePresenter");
    }

    public void onSaveInstanceState(Bundle outState){
        Log.i(TAG,"onSaveInstanceState");
    }

    protected V getView(){
        return view;
    }

    protected boolean isAttach(){
        return view != null;
    }

    public static class ViewNotAttachedException extends RuntimeException{
        public ViewNotAttachedException(){
            super("View not attached");
        }
    }
    protected void checkViewAttach(){
        if (view == null){
            throw new ViewNotAttachedException();
        }
    }
}
