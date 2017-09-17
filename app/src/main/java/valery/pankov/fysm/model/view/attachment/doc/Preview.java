package valery.pankov.fysm.model.view.attachment.doc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import valery.pankov.fysm.model.view.attachment.video.Video;

/**
 * Created by Valery on 17.09.2017.
 */

public class Preview extends RealmObject {
    @SerializedName("photo")
    @Expose
    public PhotoPreview photo;
    @SerializedName("video")
    @Expose
    public Video video;


    public PhotoPreview getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoPreview photo) {
        this.photo = photo;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
