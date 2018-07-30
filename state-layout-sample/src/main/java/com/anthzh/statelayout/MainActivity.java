package com.anthzh.statelayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.anthzh.view.statelayout.BaseStateLayoutHelper;
import com.anthzh.view.statelayout.BaseStateLayoutHelper.OnViewStateClickListener;
import com.anthzh.view.statelayout.DefaultStateLayoutHelper;
import com.anthzh.view.statelayout.StateLayout;
import com.anthzh.view.statelayout.viewstate.ViewState;

import static com.anthzh.view.statelayout.viewstate.DefaultViewStateFactory.STATE_EMPTY;
import static com.anthzh.view.statelayout.viewstate.DefaultViewStateFactory.STATE_ERROR;
import static com.anthzh.view.statelayout.viewstate.DefaultViewStateFactory.STATE_LOADING;
import static com.anthzh.view.statelayout.viewstate.DefaultViewStateFactory.STATE_NETWORK_ERROR;


public class MainActivity extends Activity {

    private StateLayout mStateLayout;
    private DefaultStateLayoutHelper mStateLayoutHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStateLayout = ((StateLayout) findViewById(R.id.stl_state_layout));

        mStateLayoutHelper = new DefaultStateLayoutHelper(mStateLayout);
        mStateLayoutHelper.setOnViewStateClickListener(new OnViewStateClickListener() {
            @Override
            public void onViewStateClick(BaseStateLayoutHelper baseHelper, ViewState viewState) {
                DefaultStateLayoutHelper helper = (DefaultStateLayoutHelper) baseHelper;
                switch (viewState.getStateId()) {
                    case STATE_LOADING:
                        helper.showContentState();
                        break;
                    case STATE_EMPTY:
                        helper.showErrorState();
                        break;
                    case STATE_ERROR:
                        helper.showNetworkErrorState();
                        break;
                    case STATE_NETWORK_ERROR:
                        helper.showContentState();
                        break;
                }
            }
        });
    }

    public void onSwitchState(View view) {
        switch (view.getId()) {
            case R.id.content_btn:
                mStateLayoutHelper.showContentState();
                break;
            case R.id.loading_btn:
                mStateLayoutHelper.showLoadingState();
                break;
            case R.id.empty_btn:
                mStateLayoutHelper.showEmptyState();
                break;
            case R.id.error_btn:
                mStateLayoutHelper.showErrorState();
                break;
            case R.id.networkerror_btn:
                mStateLayoutHelper.showNetworkErrorState();
                break;
        }
    }
}
