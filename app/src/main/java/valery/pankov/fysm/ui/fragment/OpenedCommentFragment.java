package valery.pankov.fysm.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.ButterKnife;
import io.reactivex.annotations.Nullable;
import valery.pankov.fysm.MVP.presenter.BaseFeedPresenter;
import valery.pankov.fysm.MVP.presenter.OpenedCommentPresenter;
import valery.pankov.fysm.MyApplication;
import valery.pankov.fysm.R;

/**
 * Created by Valery on 25.09.2017.
 */

public class OpenedCommentFragment extends BaseFeedFragment {

    @InjectPresenter
    OpenedCommentPresenter mPresenter;

    int id;

    public static OpenedCommentFragment newInstance(int id) {
        Bundle args = new Bundle();
        args.putInt("id", id);
        OpenedCommentFragment fragment = new OpenedCommentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);

        setWithEndlessList(false);

        if (getArguments() != null) {
            this.id = getArguments().getInt("id");
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_opened_wall_item;
    }



    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_opened_comment;
    }

    @Override
    protected BaseFeedPresenter onCreateFeedPresenter() {
        mPresenter.setId(id);
        return mPresenter;
    }
}
