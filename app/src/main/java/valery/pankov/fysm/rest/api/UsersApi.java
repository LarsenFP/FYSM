package valery.pankov.fysm.rest.api;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import valery.pankov.fysm.model.Profile;
import valery.pankov.fysm.rest.model.response.Full;

/**
 * Created by Valery on 09.09.2017.
 */

public interface UsersApi {
    @GET(ApiMethods.USERS_GET)
    Observable<Full<List<Profile>>> get(@QueryMap Map<String, String> map);
}
