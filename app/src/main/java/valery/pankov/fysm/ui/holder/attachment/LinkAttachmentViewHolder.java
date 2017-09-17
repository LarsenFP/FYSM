package valery.pankov.fysm.ui.holder.attachment;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import valery.pankov.fysm.R;
import valery.pankov.fysm.common.utils.Utils;
import valery.pankov.fysm.model.view.attachment.LinkAttachmentViewModel;
import valery.pankov.fysm.ui.holder.BaseViewHolder;

/**
 * Created by Valery on 17.09.2017.
 */

public class LinkAttachmentViewHolder extends BaseViewHolder<LinkAttachmentViewModel> {

    @BindView(R.id.tv_title)
    public TextView title;

    @BindView(R.id.tv_attachment_url)
    public TextView url;

    public LinkAttachmentViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(LinkAttachmentViewModel linkAttachmentViewModel) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.openUrlInActionView(linkAttachmentViewModel.getUrl(), view.getContext());
            }
        });
        title.setText(linkAttachmentViewModel.getTitle());
        url.setText(linkAttachmentViewModel.getUrl());
    }

    @Override
    public void unbindViewHolder() {
        itemView.setOnClickListener(null);
        title.setText(null);
        title.setText(null);
    }
}
