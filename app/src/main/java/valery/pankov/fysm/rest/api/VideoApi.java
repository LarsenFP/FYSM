package valery.pankov.fysm.rest.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import valery.pankov.fysm.rest.model.response.Full;
import valery.pankov.fysm.rest.model.response.VideosResponse;

/**
 * Created by Valery on 17.09.2017.
 */

public interface VideoApi {

    @GET(ApiMethods.VIDEO_GET)
    Observable<Full<VideosResponse>> get(@QueryMap Map<String, String> map);
}
