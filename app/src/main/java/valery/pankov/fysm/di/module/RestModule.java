package valery.pankov.fysm.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import valery.pankov.fysm.rest.RestClient;
import valery.pankov.fysm.rest.api.WallApi;

/**
 * Created by Valery on 28.08.2017.
 */

@Module
public class RestModule {

    private RestClient mRestClient;

    public RestModule (){
        mRestClient = new RestClient();
    }

    @Singleton
    @Provides
    public RestClient provideRestClient(){
        return mRestClient;
    }

    @Singleton
    @Provides
    public WallApi provideWallApi(){
        return mRestClient.createService(WallApi.class);
    }
}
