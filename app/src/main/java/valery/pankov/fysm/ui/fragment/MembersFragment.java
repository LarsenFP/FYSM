package valery.pankov.fysm.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.ButterKnife;
import io.reactivex.annotations.Nullable;
import valery.pankov.fysm.MVP.presenter.BaseFeedPresenter;
import valery.pankov.fysm.MVP.presenter.MembersPresenter;
import valery.pankov.fysm.R;

/**
 * Created by Valery on 09.09.2017.
 */

public class MembersFragment extends BaseFeedFragment {
    @InjectPresenter
    MembersPresenter mPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }


    @Override
    protected BaseFeedPresenter onCreateFeedPresenter() {
        return mPresenter;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_members;
    }
}
