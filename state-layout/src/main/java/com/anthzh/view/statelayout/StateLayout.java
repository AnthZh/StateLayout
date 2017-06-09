package com.anthzh.view.statelayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION_CODES;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.anthzh.view.statelayout.viewstate.ViewState;

/**
 * To Handle State View .  <br/>
 * Author : zhongw <br/>
 * CreateDate : 2017/6/7 11:30 <br/>
 */
public class StateLayout extends FrameLayout {
    private static final int STATE_CONTENT = 9999;

    private SparseArray<ViewState> mViewStates = new SparseArray<>();
    private ViewState mShowingViewState;
    private View mContentView;

    public StateLayout(Context context) {
        super(context, null);
        init();
    }

    public StateLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        init();
    }

    @TargetApi(VERSION_CODES.LOLLIPOP)
    public StateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(VERSION_CODES.LOLLIPOP)
    public StateLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        ContentViewState contentViewState = new ContentViewState(STATE_CONTENT);
        mViewStates.append(contentViewState.getStateId(), contentViewState);
    }

    public void register(ViewState viewState) {
        if (viewState == null) throw new NullPointerException("ViewState can not be null!");
        if (viewState.getStateId() == STATE_CONTENT) return;
        mViewStates.append(viewState.getStateId(), viewState);
    }

    public void unregister(int stateId) {
        if (stateId == STATE_CONTENT) return;
        unregister(mViewStates.get(stateId));
    }

    public void unregister(ViewState viewState) {
        if (viewState == null) return;
        int indexViewState = mViewStates.indexOfValue(viewState);
        if (indexViewState != -1) {
            mViewStates.removeAt(indexViewState);
            if (viewState.getGeneratedView() != null) {
                removeView(viewState.getGeneratedView());
            }
        }
    }

    public ViewState getViewState(int stateId) {
        return mViewStates.get(stateId);
    }

    public ViewState getShowingViewState() {
        return mShowingViewState;
    }

    public void showContentState() {
        showState(STATE_CONTENT);
    }

    public void showState(int stateId) {
        ViewState viewState = mViewStates.get(stateId);
        if (viewState == null) {
            throw new RuntimeException("StateId " + stateId + " was not registered !");
        }
        mShowingViewState = viewState;
        View stateView = viewState.getView(this);

        int childIndex = indexOfChild(stateView);
        if (childIndex == -1) {
            super.addView(stateView, -1,
                    new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            childIndex = getChildCount() - 1;
        }
        showOnly(childIndex);
    }

    private void showOnly(int childIndex) {
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (i == childIndex) {
                child.setVisibility(View.VISIBLE);
            } else {
                child.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void addView(View child) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("StateLayout can host only one direct child");
        }
        mContentView = child;
        super.addView(child);
    }

    @Override
    public void addView(View child, int index) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("StateLayout can host only one direct child");
        }
        mContentView = child;
        super.addView(child, index);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("StateLayout can host only one direct child");
        }
        mContentView = child;
        super.addView(child, params);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("StateLayout can host only one direct child");
        }
        mContentView = child;
        super.addView(child, index, params);
    }

    private class ContentViewState extends ViewState {

        private ContentViewState(int stateId) {
            super(stateId);
        }

        @Override
        protected View generateView(ViewGroup parent) {
            return mContentView;
        }
    }
}
