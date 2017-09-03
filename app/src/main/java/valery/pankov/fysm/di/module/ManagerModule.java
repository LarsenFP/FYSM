package valery.pankov.fysm.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import valery.pankov.fysm.common.manager.MyFragmentManager;
import valery.pankov.fysm.common.manager.NetworkManager;

/**
 * Created by Valery on 28.08.2017.
 */
@Module
public class ManagerModule {

    @Singleton
    @Provides
    MyFragmentManager provideMyFragmentManager(){
        return new MyFragmentManager();
    }

    @Provides
    @Singleton
    NetworkManager provideNetworkManager() {
        return new NetworkManager();
    }

}
