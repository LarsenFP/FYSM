package valery.pankov.fysm.ui.fragment;

import android.os.Bundle;

import io.reactivex.annotations.Nullable;
import valery.pankov.fysm.R;

/**
 * Created by Valery on 09.09.2017.
 */

public class MyPostsFragment extends NewsFeedFragment {
    public MyPostsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.setEnableIdFiltering(true);
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_my_posts;
    }
}
