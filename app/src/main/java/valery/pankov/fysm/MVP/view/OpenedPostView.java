package valery.pankov.fysm.MVP.view;

import valery.pankov.fysm.model.view.NewsItemFooterViewModel;

/**
 * Created by Valery on 17.09.2017.
 */

public interface OpenedPostView extends BaseFeedView {
    void setFooter(NewsItemFooterViewModel viewModel);
}
