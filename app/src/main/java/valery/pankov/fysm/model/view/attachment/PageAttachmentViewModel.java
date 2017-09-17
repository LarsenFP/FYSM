package valery.pankov.fysm.model.view.attachment;

import android.view.View;

import valery.pankov.fysm.model.view.BaseViewModel;
import valery.pankov.fysm.ui.holder.attachment.PageAttachmentHolder;

/**
 * Created by Valery on 17.09.2017.
 */

public class PageAttachmentViewModel extends BaseViewModel {

    private String mTitle;
    private String mUrl;

    public PageAttachmentViewModel(Page page) {
        mUrl = page.getUrl();
        mTitle = page.getTitle();
    }

    public String getTitle() {
        return mTitle;
    }


    @Override
    public LayoutTypes getType() {
        return LayoutTypes.AttachmentPage;
    }

    @Override
    public PageAttachmentHolder onCreateViewHolder(View view) {
        return new PageAttachmentHolder(view);
    }


    public String getmUrl() {
        return mUrl;
    }
}
