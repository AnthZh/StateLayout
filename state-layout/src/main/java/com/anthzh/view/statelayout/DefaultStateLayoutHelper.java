package com.anthzh.view.statelayout;

import com.anthzh.view.statelayout.viewstate.DefaultViewStateFactory;
import com.anthzh.view.statelayout.viewstate.EmptyViewState;
import com.anthzh.view.statelayout.viewstate.ErrorViewState;
import com.anthzh.view.statelayout.viewstate.NetworkErrorViewState;

import static com.anthzh.view.statelayout.viewstate.DefaultViewStateFactory.STATE_EMPTY;
import static com.anthzh.view.statelayout.viewstate.DefaultViewStateFactory.STATE_ERROR;
import static com.anthzh.view.statelayout.viewstate.DefaultViewStateFactory.STATE_LOADING;
import static com.anthzh.view.statelayout.viewstate.DefaultViewStateFactory.STATE_NETWORK_ERROR;

/**
 * <pre>
 * The default StateLayoutHelper , it provided some method easy to use .
 * you can extend BaseStateLayoutHelper or DefaultStateLayoutHelper to define your owner StateLayoutHelper.
 * DefaultStateLayoutHelper is an example.
 * </pre>
 * Author zhongw <br/>
 * CreateDate : 2017/6/7 18:17 <br/>
 */
public class DefaultStateLayoutHelper extends BaseStateLayoutHelper {

    public DefaultStateLayoutHelper(StateLayout stateLayout) {
        super(stateLayout, new DefaultViewStateFactory());
    }

    public void showContentState() {
        mStateLayout.showContentState();
    }

    public void showLoadingState() {
        showState(STATE_LOADING);
    }

    public void showEmptyState() {
        showEmptyState(R.string.stl_empty_text);
    }

    public void showEmptyState(int emptyTextId) {
        showState(STATE_EMPTY);
        EmptyViewState viewState = getViewState(STATE_EMPTY);
        viewState.setEmptyText(emptyTextId);
    }

    public void showEmptyState(String emptyText) {
        showState(STATE_EMPTY);
        EmptyViewState viewState = getViewState(STATE_EMPTY);
        viewState.setEmptyText(emptyText);
    }

    public void showErrorState() {
        showErrorState(R.string.stl_error_text);
    }

    public void showErrorState(int errorTextId) {
        showState(STATE_ERROR);
        ErrorViewState viewState = getViewState(STATE_ERROR);
        viewState.setErrorText(errorTextId);
    }

    public void showErrorState(String errorText) {
        showState(STATE_ERROR);
        ErrorViewState viewState = getViewState(STATE_ERROR);
        viewState.setErrorText(errorText);
    }

    public void showNetworkErrorState() {
        showNetworkErrorState(R.string.stl_network_error_text);
    }

    public void showNetworkErrorState(int networkErrorTextId) {
        showState(STATE_NETWORK_ERROR);
        NetworkErrorViewState viewState = getViewState(STATE_NETWORK_ERROR);
        viewState.setErrorText(networkErrorTextId);
    }

    public void showNetworkErrorState(String networkErrorText) {
        showState(STATE_NETWORK_ERROR);
        NetworkErrorViewState viewState = getViewState(STATE_NETWORK_ERROR);
        viewState.setErrorText(networkErrorText);
    }
}
