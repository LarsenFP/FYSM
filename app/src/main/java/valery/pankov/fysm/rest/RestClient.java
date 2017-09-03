package valery.pankov.fysm.rest;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Valery on 28.08.2017.
 */

public class RestClient {

    private static final String VK_BASE_URL = "https://api.vk.com/method/";

    private Retrofit mRetofit;

    public RestClient(){
        mRetofit=new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(VK_BASE_URL)
                .build();
    }

    public <S> S createService(Class<S> serviceClass){
        return mRetofit.create(serviceClass);
    }
}
