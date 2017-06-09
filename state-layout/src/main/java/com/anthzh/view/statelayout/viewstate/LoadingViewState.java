package com.anthzh.view.statelayout.viewstate;

import android.view.View;
import android.view.ViewGroup;

import com.anthzh.view.statelayout.R;

/**
 * The Loading State View   <br/>
 * Author : zhongw <br/>
 * CreateDate : 2017/6/7 15:29 <br/>
 */
public class LoadingViewState extends ViewState {
    public LoadingViewState(int stateId) {
        super(stateId);
    }

    @Override
    protected View generateView(ViewGroup parent) {
        return inflateView(parent, R.layout.stl_loading_layout);
    }
}