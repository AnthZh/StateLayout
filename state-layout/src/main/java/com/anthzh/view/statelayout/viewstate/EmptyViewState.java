package com.anthzh.view.statelayout.viewstate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anthzh.view.statelayout.R;


/**
 * The Empty State View   <br/>
 * Author : zhongw <br/>
 * CreateDate : 2017/6/7 15:29 <br/>
 */
public class EmptyViewState extends ViewState {

    private TextView tvEmpty;

    public EmptyViewState(int stateId) {
        super(stateId);
    }

    @Override
    protected View generateView(ViewGroup parent) {
        return inflateView(parent, R.layout.stl_empty_layout);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        tvEmpty = (TextView) view.findViewById(R.id.view_state_empty_tv);
    }

    public void setEmptyText(String errorText) {
        tvEmpty.setText(errorText);
    }

    public void setEmptyText(int errorTextId) {
        tvEmpty.setText(errorTextId);
    }
}