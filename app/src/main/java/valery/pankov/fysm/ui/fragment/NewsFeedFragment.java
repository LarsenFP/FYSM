package valery.pankov.fysm.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import valery.pankov.fysm.MyApplication;
import valery.pankov.fysm.R;
import valery.pankov.fysm.common.utils.VkListHelper;
import valery.pankov.fysm.model.WallItem;
import valery.pankov.fysm.model.view.BaseViewModel;
import valery.pankov.fysm.model.view.NewsItemBodyViewModel;
import valery.pankov.fysm.model.view.NewsItemFooterViewModel;
import valery.pankov.fysm.model.view.NewsItemHeaderViewModel;
import valery.pankov.fysm.rest.api.WallApi;
import valery.pankov.fysm.rest.model.request.WallGetRequestModel;
import valery.pankov.fysm.rest.model.response.GetWallResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFeedFragment {

    @Inject
    WallApi mWallApi;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mWallApi.get(new WallGetRequestModel(-23400027).toMap()).enqueue(new Callback<GetWallResponse>() {
            @Override
            public void onResponse(Call<GetWallResponse> call, Response<GetWallResponse> response) {

                Toast.makeText(getActivity(), "Likes: " + response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();

                List<WallItem> wallItems = VkListHelper.getWallList(response.body().response);
                List<BaseViewModel> list = new ArrayList<>();

                for(WallItem item : wallItems){
                    list.add(new NewsItemHeaderViewModel(item));
                    list.add(new NewsItemBodyViewModel(item));
                    list.add(new NewsItemFooterViewModel(item));
                }
                mAdapter.addItems(list);
                //Toast.makeText(getActivity(), "Likes: " + list.get(2).getText(), Toast.LENGTH_LONG).show();
                //Toast.makeText(getActivity(), "Likes: " + response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<GetWallResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }


}
