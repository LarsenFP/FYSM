package valery.pankov.fysm.rest.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import valery.pankov.fysm.model.Member;
import valery.pankov.fysm.rest.model.response.BaseItemResponse;
import valery.pankov.fysm.rest.model.response.Full;

/**
 * Created by Valery on 09.09.2017.
 */

public interface GroupsApi {

    @GET(ApiMethods.GROUPS_GET_MEMBERS)
    Observable<Full<BaseItemResponse<Member>>> getMembers(@QueryMap Map<String, String> map);

}
