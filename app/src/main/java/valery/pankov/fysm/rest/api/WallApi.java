package valery.pankov.fysm.rest.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import valery.pankov.fysm.rest.model.response.GetWallResponse;

/**
 * Created by Valery on 28.08.2017.
 */

public interface WallApi {

    @GET(ApiMethods.WALL_GET)
    Call<GetWallResponse> get(@QueryMap Map<String, String> map);
}
