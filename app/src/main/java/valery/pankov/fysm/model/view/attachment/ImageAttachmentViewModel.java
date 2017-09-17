package valery.pankov.fysm.model.view.attachment;

import android.view.View;

import valery.pankov.fysm.model.view.BaseViewModel;
import valery.pankov.fysm.ui.holder.attachment.ImageAttachmentHolder;

/**
 * Created by Valery on 17.09.2017.
 */

public class ImageAttachmentViewModel  extends BaseViewModel {

    private String mPhotoUrl;
    public boolean needClick = true;

    @Override
    public ImageAttachmentHolder onCreateViewHolder(View view) {
        return new ImageAttachmentHolder(view);
    }

    public ImageAttachmentViewModel(String url) {
        mPhotoUrl = url;

        needClick = false;
    }

    public ImageAttachmentViewModel(Photo photo) {
        mPhotoUrl = photo.getPhoto604();
    }


    @Override
    public LayoutTypes getType() {
        return LayoutTypes.AttachmentImage;
    }




    public String getPhotoUrl() {
        return mPhotoUrl;
    }
}
