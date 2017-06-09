package com.anthzh.view.statelayout;

import android.view.View;
import android.view.View.OnClickListener;

import com.anthzh.view.statelayout.viewstate.ViewState;
import com.anthzh.view.statelayout.viewstate.ViewStateFactory;

import java.util.List;

/**
 * The helper to init StateLayout's State View  <br/>
 * Author : zhongw <br/>
 * CreateDate : 2017/6/7 15:06 <br/>
 */
public class BaseStateLayoutHelper {

    protected StateLayout mStateLayout;
    private OnViewStateClickListener mListener;

    public BaseStateLayoutHelper(final StateLayout stateLayout, ViewStateFactory viewStateFactory) {
        if (stateLayout == null) throw new NullPointerException("StateLayout can not be null !");
        stateLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    ViewState showingViewState = stateLayout.getShowingViewState();
                    if (showingViewState != null)
                        mListener.onViewStateClick(BaseStateLayoutHelper.this, showingViewState);
                }
            }
        });
        mStateLayout = stateLayout;
        initViewState(stateLayout, viewStateFactory.buildViewStates());
    }

    /** If you has own ViewState , you should override */
    protected void initViewState(StateLayout stateLayout, List<ViewState> viewStates) {
        for (ViewState viewState : viewStates) {
            stateLayout.register(viewState);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends ViewState> T getViewState(int stateId) {
        return (T) mStateLayout.getViewState(stateId);
    }

    /**
     * Add new ViewState to StateLayout , if the stateId is exists , will replaces.
     *
     * @param viewState The ViewState.
     */
    public void addViewState(ViewState viewState) {
        mStateLayout.register(viewState);
    }

    /**
     * Remove ViewState form StateLayout by stateId.
     *
     * @param stateId The ViewState 's id .
     */
    public void removeViewState(int stateId) {
        mStateLayout.unregister(stateId);
    }

    /**
     * Set ViewState Click　Listener.
     *
     * @param listener The OnViewStateClickListener
     */
    public void setOnViewStateClickListener(OnViewStateClickListener listener) {
        mListener = listener;
    }

    /**
     * Show target State View
     *
     * @param stateId The ViewState 's id .
     */
    public void showState(int stateId) {
        mStateLayout.showState(stateId);
    }

    public interface OnViewStateClickListener {
        void onViewStateClick(BaseStateLayoutHelper helper, ViewState viewState);
    }
}
