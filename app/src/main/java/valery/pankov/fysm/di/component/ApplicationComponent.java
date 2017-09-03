package valery.pankov.fysm.di.component;

import javax.inject.Singleton;

import dagger.Component;
import valery.pankov.fysm.MVP.presenter.NewsFeedPresenter;
import valery.pankov.fysm.common.manager.NetworkManager;
import valery.pankov.fysm.di.module.ApplicationModule;
import valery.pankov.fysm.di.module.ManagerModule;
import valery.pankov.fysm.di.module.RestModule;
import valery.pankov.fysm.ui.activity.BaseActivity;
import valery.pankov.fysm.ui.activity.MainActivity;
import valery.pankov.fysm.ui.fragment.NewsFeedFragment;
import valery.pankov.fysm.ui.holder.NewsItemBodyHolder;
import valery.pankov.fysm.ui.holder.NewsItemFooterHolder;

/**
 * Created by Valery on 28.08.2017.
 */

@Singleton
@Component(modules={ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    //activities
    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    //fragments
    void inject(NewsFeedFragment fragment);

    //holders
    void inject(NewsItemBodyHolder holder);
    void inject(NewsItemFooterHolder holder);

    //presenters
    void inject(NewsFeedPresenter presenter);

    //managers
    void inject(NetworkManager manager);

}
