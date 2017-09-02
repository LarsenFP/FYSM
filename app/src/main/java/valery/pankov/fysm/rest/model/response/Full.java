package valery.pankov.fysm.rest.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Valery on 28.08.2017.
 */

public class Full<T> {

    @SerializedName("response")
    @Expose
    public T response;
}
