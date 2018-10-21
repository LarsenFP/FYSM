package valery.pankov.fysm.rest.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import valery.pankov.fysm.model.CommentItem;
import valery.pankov.fysm.rest.model.response.Full;
import valery.pankov.fysm.rest.model.response.GetWallByIdResponse;
import valery.pankov.fysm.rest.model.response.GetWallResponse;
import valery.pankov.fysm.rest.model.response.ItemWithSendersResponse;

/**
 * Created by Valery on 28.08.2017.
 */

public interface WallApi {

    @GET(ApiMethods.WALL_GET)
    Observable<GetWallResponse> get(@QueryMap Map<String, String> map);

    @GET(ApiMethods.WALL_GET_BY_ID)
    Observable<GetWallByIdResponse> getById(@QueryMap Map<String, String> map);

    @GET(ApiMethods.WALL_GET_COMMENTS)
    Observable<Full<ItemWithSendersResponse<CommentItem>>> getComments(@QueryMap Map<String, String> map);
}
