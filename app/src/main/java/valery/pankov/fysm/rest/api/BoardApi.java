package valery.pankov.fysm.rest.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import valery.pankov.fysm.model.CommentItem;
import valery.pankov.fysm.model.Topic;
import valery.pankov.fysm.rest.model.response.BaseItemResponse;
import valery.pankov.fysm.rest.model.response.Full;
import valery.pankov.fysm.rest.model.response.ItemWithSendersResponse;

/**
 * Created by Valery on 13.09.2017.
 */

public interface BoardApi {
    @GET(ApiMethods.BOARD_GET_TOPICS)
    Observable<Full<BaseItemResponse<Topic>>> getTopics(@QueryMap Map<String, String> map);

    @GET(ApiMethods.BOARD_GET_COMMENTS)
    Observable<Full<ItemWithSendersResponse<CommentItem>>> getComments(@QueryMap Map<String, String> map);

}
