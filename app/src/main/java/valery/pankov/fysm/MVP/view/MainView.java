package valery.pankov.fysm.MVP.view;

import com.arellomobile.mvp.MvpView;

import valery.pankov.fysm.model.Profile;
import valery.pankov.fysm.ui.fragment.BaseFragment;

/**
 * Created by Valery on 26.08.2017.
 */

public interface MainView extends MvpView {
    void startSignIn();

    void signedId();

    void showCurrentUser(Profile profile);

    void showFragmentFromDrawer(BaseFragment baseFragment);
}
