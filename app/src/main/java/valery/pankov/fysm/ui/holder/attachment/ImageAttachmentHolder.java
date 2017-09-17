package valery.pankov.fysm.ui.holder.attachment;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import valery.pankov.fysm.MyApplication;
import valery.pankov.fysm.R;
import valery.pankov.fysm.common.manager.MyFragmentManager;
import valery.pankov.fysm.model.view.attachment.ImageAttachmentViewModel;
import valery.pankov.fysm.ui.holder.BaseViewHolder;

/**
 * Created by Valery on 17.09.2017.
 */

public class ImageAttachmentHolder extends BaseViewHolder<ImageAttachmentViewModel> {


    @BindView(R.id.iv_attachment_image)
    public ImageView image;

    @Inject
    MyFragmentManager mFragmentManager;


    public ImageAttachmentHolder(View itemView) {
        super(itemView);

        MyApplication.getApplicationComponent().inject(this);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(ImageAttachmentViewModel imageAttachmentViewModel) {


        Glide.with(itemView.getContext()).load(imageAttachmentViewModel.getPhotoUrl()).into(image);


    }

    @Override
    public void unbindViewHolder() {

        itemView.setOnClickListener(null);
        image.setImageBitmap(null);
    }

}
