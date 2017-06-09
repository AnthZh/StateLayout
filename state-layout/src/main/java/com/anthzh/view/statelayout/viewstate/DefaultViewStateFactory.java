package com.anthzh.view.statelayout.viewstate;

import java.util.ArrayList;
import java.util.List;

/**
 * The Default ViewState Factory  <br/>
 * Author : zhongw <br/>
 * CreateDate : 2017/6/7 17:29 <br/>
 */
public class DefaultViewStateFactory implements ViewStateFactory {

    public static final int STATE_LOADING = 1;
    public static final int STATE_EMPTY = 2;
    public static final int STATE_ERROR = 3;
    public static final int STATE_NETWORK_ERROR = 4;

    @Override
    public List<ViewState> buildViewStates() {
        ArrayList<ViewState> viewStates = new ArrayList<>(4);
        viewStates.add(new LoadingViewState(STATE_LOADING));
        viewStates.add(new EmptyViewState(STATE_EMPTY));
        viewStates.add(new ErrorViewState(STATE_ERROR));
        viewStates.add(new NetworkErrorViewState(STATE_NETWORK_ERROR));
        return viewStates;
    }

}
