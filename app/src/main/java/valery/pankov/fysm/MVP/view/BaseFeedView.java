package valery.pankov.fysm.MVP.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import valery.pankov.fysm.model.view.BaseViewModel;

/**
 * Created by Valery on 03.09.2017.
 */

public interface BaseFeedView extends MvpView {
    void showRefreshing();

    void hideRefreshing();


    void showListProgress();

    void hideListProgress();


    void showError(String message);


    void setItems(List<BaseViewModel> items);

    void addItems(List<BaseViewModel> items);
}
