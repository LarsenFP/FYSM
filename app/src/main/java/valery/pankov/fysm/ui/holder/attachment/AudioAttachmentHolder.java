package valery.pankov.fysm.ui.holder.attachment;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import valery.pankov.fysm.R;
import valery.pankov.fysm.model.view.attachment.AudioAttachmentViewModel;
import valery.pankov.fysm.ui.holder.BaseViewHolder;

/**
 * Created by Valery on 17.09.2017.
 */

public class AudioAttachmentHolder extends BaseViewHolder<AudioAttachmentViewModel> {

    @BindView(R.id.tv_audio_name)
    public TextView name;

    @BindView(R.id.tv_audio_artist)
    public TextView artist;

    @BindView(R.id.tv_audio_duration)
    public TextView duration;


    public AudioAttachmentHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(AudioAttachmentViewModel audioAttachmentViewModel) {
        name.setText(audioAttachmentViewModel.getTitle());
        artist.setText(audioAttachmentViewModel.getArtist());

        duration.setText(audioAttachmentViewModel.getDuration());
    }

    @Override
    public void unbindViewHolder() {
        name.setText(null);
        artist.setText(null);

        duration.setText(null);
    }
}
