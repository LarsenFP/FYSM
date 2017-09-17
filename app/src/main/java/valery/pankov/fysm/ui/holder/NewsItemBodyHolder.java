package valery.pankov.fysm.ui.holder;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import valery.pankov.fysm.MyApplication;
import valery.pankov.fysm.R;
import valery.pankov.fysm.common.manager.MyFragmentManager;
import valery.pankov.fysm.common.utils.UiHelper;
import valery.pankov.fysm.model.view.NewsItemBodyViewModel;
import valery.pankov.fysm.ui.activity.BaseActivity;
import valery.pankov.fysm.ui.fragment.OpenedPostFragment;

/**
 * Created by Valery on 30.08.2017.
 */

public class NewsItemBodyHolder extends BaseViewHolder<NewsItemBodyViewModel> {

    @BindView(R.id.tv_text)
    public TextView tvText;

    @BindView(R.id.tv_attachments)
    public TextView tvAttachments;

    @Inject
    protected Typeface mFontGoogle;

    @Inject
    MyFragmentManager myFragmentManager;

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
        //Context context = itemView.getContext();

        tvText.setText(item.getText());
        tvAttachments.setText(item.getAttachmentString());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myFragmentManager.addFragment((BaseActivity) view.getContext(),
                        OpenedPostFragment.newInstance(item.getId()),
                        R.id.main_wrapper);

            }
        });
        UiHelper.getInstance().setUpTextViewWithVisibility(tvText, item.getText());
        UiHelper.getInstance().setUpTextViewWithVisibility(tvAttachments, item.getAttachmentString());


//        if(item.getPhoto604String()!=null){
//            Glide.with(context)
//
//                    .load(item.getPhoto604String())
//                    .into(ivAttachments);
//            Log.d("Attachments", item.getPhoto604String());
//        }



    }

    @Override
    public void unbindViewHolder() {
        tvText.setText(null);
        tvAttachments.setText(null);
        itemView.setOnClickListener(null);
    }
}
