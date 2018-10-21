package valery.pankov.fysm.MVP.view;

import com.arellomobile.mvp.MvpView;

import valery.pankov.fysm.model.WallItem;
import valery.pankov.fysm.model.view.counter.LikeCounterViewModel;

/**
 * Created by Valery on 25.09.2017.
 */

public interface PostFooterView extends MvpView {
    void like(LikeCounterViewModel likes);

    void openComments(WallItem wallItem);
}