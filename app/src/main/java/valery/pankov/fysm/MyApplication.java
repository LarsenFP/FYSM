package valery.pankov.fysm;

import android.app.Application;

import com.vk.sdk.VKSdk;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import valery.pankov.fysm.di.component.ApplicationComponent;
import valery.pankov.fysm.di.component.DaggerApplicationComponent;
import valery.pankov.fysm.di.module.ApplicationModule;

/**
 * Created by Valery on 26.08.2017.
 */

public class MyApplication extends Application {

    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate(){
        super.onCreate();
        initComponent();
        VKSdk.initialize(this);
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

    }

    private void initComponent() {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }


    public static ApplicationComponent getApplicationComponent(){
        return sApplicationComponent;
    }
}
