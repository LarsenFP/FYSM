package valery.pankov.fysm.model.view;

import android.view.View;

import valery.pankov.fysm.model.WallItem;
import valery.pankov.fysm.model.attachment.Photo;
import valery.pankov.fysm.ui.holder.NewsItemBodyHolder;

/**
 * Created by Valery on 30.08.2017.
 */

public class NewsItemBodyViewModel extends BaseViewModel {

    private int mId;

    private String mText;

    private String mAttachmentString;

    private boolean mIsRepost;

    private String mAttachmentType;



    private Photo photo604i;
    private String photo604;

    public NewsItemBodyViewModel(WallItem wallItem){
        this.mId = wallItem.getId();
        this.mIsRepost = wallItem.haveSharedRepost();
        if(mIsRepost){
            this.mText = wallItem.getSharedRepost().getText();
            this.mAttachmentString = wallItem.getSharedRepost().getAttachmentsString();
        }else {
            this.mText = wallItem.getText();
            this.mAttachmentString = wallItem.getAttachmentsString();

            if(wallItem.getAttachments().get(0).getType().equals("photo")){

                photo604i = wallItem.getAttachments().get(0).getPhoto();
                //photo604i = (Photo) new ApiAttachment().getAttachment(wallItem);
                photo604=photo604i.getPhoto604();

            }

            //this.mAttachmentType = wallItem.getAttachments().get(0).getType();
        }
    }
    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemBody;
    }

    @Override
    protected NewsItemBodyHolder onCreateViewHolder(View view) {
        return new NewsItemBodyHolder(view);
    }

    public int getId() {
        return mId;
    }

    public String getText() {
        return mText;
    }

    public String getAttachmentType() {
        return mAttachmentType;
    }

    public String getAttachmentString() {
        return mAttachmentString;
    }

    public String getPhoto604String() {
        return photo604;
    }

    @Override
    public boolean isItemDecorator() {
        return true;
    }
}
