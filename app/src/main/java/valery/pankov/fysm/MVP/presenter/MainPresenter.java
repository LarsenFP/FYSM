package valery.pankov.fysm.MVP.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmObject;
import valery.pankov.fysm.CurrentUser;
import valery.pankov.fysm.MVP.view.MainView;
import valery.pankov.fysm.MyApplication;
import valery.pankov.fysm.common.manager.MyFragmentManager;
import valery.pankov.fysm.common.manager.NetworkManager;
import valery.pankov.fysm.model.Profile;
import valery.pankov.fysm.rest.api.UsersApi;
import valery.pankov.fysm.rest.model.request.UsersGetRequestModel;
import valery.pankov.fysm.ui.fragment.BaseFragment;
import valery.pankov.fysm.ui.fragment.BoardFragment;
import valery.pankov.fysm.ui.fragment.InfoFragment;
import valery.pankov.fysm.ui.fragment.MembersFragment;
import valery.pankov.fysm.ui.fragment.MyPostsFragment;
import valery.pankov.fysm.ui.fragment.NewsFeedFragment;

/**
 * Created by Valery on 26.08.2017.
 */
@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    UsersApi mUserApi;

    @Inject
    NetworkManager mNetworkManager;

    @Inject
    MyFragmentManager myFragmentManager;

    public MainPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }

    public void checkAuth(){
        if(!CurrentUser.isAuthorized()){
            getViewState().startSignIn();
        }else {
            getCurrentUser();
            getViewState().signedId();
        }
    }

    public Observable<Profile> getProfileFromNetwork() {
        return mUserApi.get(new UsersGetRequestModel(CurrentUser.getId()).toMap())
                .flatMap(listFull -> Observable.fromIterable(listFull.response))
                .doOnNext(this::saveToDb);
    }

    private Observable<Profile> getProfileFromDb() {
        return Observable.fromCallable(getListFromRealmCallable());
    }

    public void saveToDb(RealmObject item) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(item));
    }

    public Callable<Profile> getListFromRealmCallable() {
        return () -> {
            Realm realm = Realm.getDefaultInstance();
            Profile realmResults = realm.where(Profile.class)
                    .equalTo("id", Integer.parseInt(CurrentUser.getId()))
                    .findFirst();
            return realm.copyFromRealm(realmResults);
        };
    }

    private void getCurrentUser() {
        mNetworkManager.getNetworkObservable()
                .flatMap(aBoolean -> {
                    if (!CurrentUser.isAuthorized()) {
                        getViewState().startSignIn();
                    }

                    return aBoolean
                            ? getProfileFromNetwork()
                            : getProfileFromDb();
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(profile -> {
                    getViewState().showCurrentUser(profile);
                }, error -> {
                    error.printStackTrace();
                });
    }

    public void drawerItemClick(int id) {
        BaseFragment fragment = null;

        switch (id) {
            case 1:
                fragment = new NewsFeedFragment();
                break;
            case 2:
                fragment = new MyPostsFragment();
                break;
            case 4:
                fragment = new MembersFragment();
                break;
            case 5:
                fragment = new BoardFragment();
                break;
            case 6:
                fragment = new InfoFragment();
                break;
        }

        if (fragment != null && !myFragmentManager.isAlreadyContains(fragment)) {
            getViewState().showFragmentFromDrawer(fragment);
        }
    }
}
