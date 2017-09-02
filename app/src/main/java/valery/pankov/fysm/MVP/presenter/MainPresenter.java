package valery.pankov.fysm.MVP.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import valery.pankov.fysm.CurrentUser;
import valery.pankov.fysm.MVP.view.MainView;

/**
 * Created by Valery on 26.08.2017.
 */
@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public void checkAuth(){
        if(!CurrentUser.isAuthorized()){
            getViewState().startSignIn();
        }else {
            getViewState().signedId();
        }
    }
}
