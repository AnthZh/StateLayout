package com.anthzh.view.statelayout.viewstate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anthzh.view.statelayout.R;

/**
 * The Error State View   <br/>
 * Author : zhongw <br/>
 * CreateDate : 2017/6/7 15:29 <br/>
 */
public class ErrorViewState extends ViewState {

    private TextView tvError;

    public ErrorViewState(int stateId) {
        super(stateId);
    }

    @Override
    protected View generateView(ViewGroup parent) {
        return inflateView(parent, R.layout.stl_error_layout);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        tvError = (TextView) view.findViewById(R.id.view_state_error_tv);
    }

    public void setErrorText(String errorText) {
        tvError.setText(errorText);
    }

    public void setErrorText(int errorTextId) {
        tvError.setText(errorTextId);
    }
}