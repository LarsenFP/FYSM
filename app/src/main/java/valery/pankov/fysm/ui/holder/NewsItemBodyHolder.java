package valery.pankov.fysm.ui.holder;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import valery.pankov.fysm.MyApplication;
import valery.pankov.fysm.R;
import valery.pankov.fysm.model.view.NewsItemBodyViewModel;

/**
 * Created by Valery on 30.08.2017.
 */

public class NewsItemBodyHolder extends BaseViewHolder<NewsItemBodyViewModel> {

    @BindView(R.id.tv_text)
    public TextView tvText;

    @BindView(R.id.tv_attachments)
    public TextView tvAttachments;

    @BindView(R.id.iv_attachments)
    public ImageView ivAttachments;

    @Inject
    protected Typeface mFontGoogle;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        MyApplication.getApplicationComponent().inject(this);
        if (tvAttachments !=null){


            tvAttachments.setTypeface(mFontGoogle);
        }
    }

    @Override
    public void bindViewHolder(NewsItemBodyViewModel item) {
        Context context = itemView.getContext();

        tvText.setText(item.getText());
        tvAttachments.setText(item.getAttachmentString());

        if(item.getPhoto604String()!=null){
            Glide.with(context)

                    .load(item.getPhoto604String())
                    .into(ivAttachments);
            Log.d("Attachments", item.getPhoto604String());
        }



    }

    @Override
    public void unbindViewHolder() {
        tvText.setText(null);
        tvAttachments.setText(null);
    }
}
