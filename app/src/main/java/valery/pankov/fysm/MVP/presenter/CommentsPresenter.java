package valery.pankov.fysm.MVP.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import valery.pankov.fysm.MVP.view.BaseFeedView;
import valery.pankov.fysm.MyApplication;
import valery.pankov.fysm.common.utils.VkListHelper;
import valery.pankov.fysm.model.CommentItem;
import valery.pankov.fysm.model.Place;
import valery.pankov.fysm.model.view.BaseViewModel;
import valery.pankov.fysm.model.view.CommentBodyViewModel;
import valery.pankov.fysm.model.view.CommentFooterViewModel;
import valery.pankov.fysm.model.view.CommentHeaderViewModel;
import valery.pankov.fysm.rest.api.WallApi;
import valery.pankov.fysm.rest.model.request.WallGetCommentsRequestModel;

/**
 * Created by Valery on 25.09.2017.
 */

@InjectViewState
public class CommentsPresenter extends BaseFeedPresenter<BaseFeedView> {

    private Place mPlace;

    @Inject
    WallApi mWallApi;


    public CommentsPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return mWallApi.getComments(new WallGetCommentsRequestModel(
                Integer.parseInt(mPlace.getOwnerId()), Integer.parseInt(mPlace.getPostId()), offset).toMap())
                .flatMap(full -> Observable.fromIterable(VkListHelper.getCommentsList(full.response, true)))
                .doOnNext(commentItem -> commentItem.setPlace(mPlace))
                .doOnNext(this::saveToDb)
                .flatMap(commentItem -> Observable.fromIterable(parsePojoModel(commentItem)));
    }

    @Override
    public Observable<BaseViewModel> onCreateRestoreDataObservable() {
        return Observable.fromCallable(getListFromRealmCallable())
                .flatMap(Observable::fromIterable)
                .filter(commentItem -> commentItem.getPlace().equals(this.mPlace) && !commentItem.isFromTopic)
                .flatMap(commentItem -> Observable.fromIterable(parsePojoModel(commentItem)));
    }


    private List<BaseViewModel> parsePojoModel(CommentItem commentItem) {
        List<BaseViewModel> baseItems = new ArrayList<>();
        baseItems.add(new CommentHeaderViewModel(commentItem));
        baseItems.add(new CommentBodyViewModel(commentItem));
        baseItems.add(new CommentFooterViewModel(commentItem));
        return baseItems;
    }


    public Callable<List<CommentItem>> getListFromRealmCallable() {
        return () -> {
            String[] sortFields = {"id"};
            Sort[] sortOrder = {Sort.ASCENDING};

            Realm realm = Realm.getDefaultInstance();
            RealmResults<CommentItem> results = realm.where(CommentItem.class)
                    .findAllSorted(sortFields, sortOrder);
            return realm.copyFromRealm(results);
        };
    }


    public void setPlace(Place place) {
        this.mPlace = place;
    }
}
