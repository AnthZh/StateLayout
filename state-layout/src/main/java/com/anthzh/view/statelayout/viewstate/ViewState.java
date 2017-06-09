package com.anthzh.view.statelayout.viewstate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anthzh.view.statelayout.StateLayout;

/**
 * The ViewState template  <br/>
 * Author : zhongw <br/>
 * CreateDate : 2017/6/7 11:31 <br/>
 */
public abstract class ViewState {

    /**
     * generate State View
     *
     * @param parent the parent layout {@link StateLayout StateLayout}
     * @return State View
     */
    protected abstract View generateView(ViewGroup parent);

    private int stateId;
    private View mView;

    public ViewState(int stateId) {
        this.stateId = stateId;
    }

    public View getView(ViewGroup parent) {
        if (parent != null && mView == null) {
            View view = generateView(parent);
            initView(view);
            mView = view;
        }
        return mView;
    }

    protected void initView(View view) {
    }

    protected View inflateView(ViewGroup parent, int layoutResId) {
        return LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
    }

    public int getStateId() {
        return stateId;
    }

    public View getGeneratedView() {
        return mView;
    }
}
