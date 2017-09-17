package valery.pankov.fysm.rest.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import valery.pankov.fysm.model.view.attachment.video.Video;

/**
 * Created by Valery on 17.09.2017.
 */

public class VideosResponse {
    public int count;
    @SerializedName("items")
    @Expose
    public List<Video> items;
}
