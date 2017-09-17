package valery.pankov.fysm.ui.holder.attachment;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import valery.pankov.fysm.R;
import valery.pankov.fysm.common.utils.Utils;
import valery.pankov.fysm.model.view.attachment.PageAttachmentViewModel;
import valery.pankov.fysm.ui.holder.BaseViewHolder;

/**
 * Created by Valery on 17.09.2017.
 */

public class PageAttachmentHolder extends BaseViewHolder<PageAttachmentViewModel> {
    @BindView(R.id.tv_title)
    public TextView title;

    public PageAttachmentHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(PageAttachmentViewModel pageAttachmentViewModel) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.openUrlInActionView(pageAttachmentViewModel.getmUrl(), view.getContext());
            }
        });
        title.setText(pageAttachmentViewModel.getTitle());
    }

    @Override
    public void unbindViewHolder() {
        itemView.setOnClickListener(null);
        title.setText(null);
    }
}
