package valery.pankov.fysm.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import valery.pankov.fysm.rest.RestClient;
import valery.pankov.fysm.rest.api.BoardApi;
import valery.pankov.fysm.rest.api.GroupsApi;
import valery.pankov.fysm.rest.api.UsersApi;
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

    @Provides
    @Singleton
    public UsersApi provideUsersApi() {
        return mRestClient.createService(UsersApi.class);
    }

    @Provides
    @Singleton
    public GroupsApi provideGroupsApi() {
        return mRestClient.createService(GroupsApi.class);
    }

    @Provides
    @Singleton
    public BoardApi provideBoardApi() {
        return mRestClient.createService(BoardApi.class);
    }
}
