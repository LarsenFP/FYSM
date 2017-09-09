package valery.pankov.fysm.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import valery.pankov.fysm.MVP.presenter.BaseFeedPresenter;
import valery.pankov.fysm.MVP.view.BaseFeedView;
import valery.pankov.fysm.R;
import valery.pankov.fysm.common.BaseAdapter;
import valery.pankov.fysm.common.manager.MyLinearLayoutManager;
import valery.pankov.fysm.model.view.BaseViewModel;

/**
 * Created by Valery on 02.09.2017.
 */

public abstract class BaseFeedFragment extends BaseFragment implements BaseFeedView {


    protected BaseFeedPresenter mBaseFeedPresenter;

    @BindView(R.id.rv_list)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipe_refresh)
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    protected ProgressBar mProgressBar;
    BaseAdapter mAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ButterKnife.bind(this, view);
        setUpSwipeToRefreshLayout(view);
        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);

        mBaseFeedPresenter = onCreateFeedPresenter();
        mBaseFeedPresenter.loadStart();
    }

    private void setUpRecyclerView(View rootView) {

        MyLinearLayoutManager mLinearLayoutManager = new MyLinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                if (mLinearLayoutManager.isOnNextPagePosition()) {
                    mBaseFeedPresenter.loadNext(mAdapter.getRealItemCount());
                }
            }
        });

        ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    protected void setUpAdapter(RecyclerView rv) {
        mAdapter = new BaseAdapter();
        rv.setAdapter(mAdapter);
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }



    @Override
    public int onCreateToolbarTitle() {
        return 0;
    }

    private void setUpSwipeToRefreshLayout(View rootView) {

        mSwipeRefreshLayout.setOnRefreshListener(() -> onCreateFeedPresenter().loadRefresh());
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mProgressBar = getBaseActivity().getProgressBar();

    }

    protected abstract BaseFeedPresenter onCreateFeedPresenter();

    @Override
    public void showRefreshing() {
    }

    @Override
    public void hideRefreshing() {
        mSwipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void showListProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideListProgress() {
        mProgressBar.setVisibility(View.GONE);
    }


    @Override
    public void showError(String message) {
        Toast.makeText(getBaseActivity(), message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void setItems(List<BaseViewModel> items) {
        mAdapter.setItems(items);
    }

    @Override
    public void addItems(List<BaseViewModel> items) {
        mAdapter.addItems(items);
    }
}
