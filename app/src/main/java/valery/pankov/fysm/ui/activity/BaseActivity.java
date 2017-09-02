package valery.pankov.fysm.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

import valery.pankov.fysm.MyApplication;
import valery.pankov.fysm.R;
import valery.pankov.fysm.common.manager.MyFragmentManager;
import valery.pankov.fysm.ui.fragment.BaseFragment;

/**
 * Created by Valery on 27.08.2017.
 */

public abstract class BaseActivity extends MvpAppCompatActivity {

    @Inject
    MyFragmentManager myFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getApplicationComponent().inject(this);
        setContentView(R.layout.activity_base);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FrameLayout parent = (FrameLayout) findViewById(R.id.main_wraper);
        getLayoutInflater().inflate(getMainContentLayout(), parent);
    }

    @LayoutRes
    protected abstract int getMainContentLayout();

    public void fragmentOnScreen(BaseFragment fragment){
        setToolbarTitle(fragment.createToolbarTitle(this));
    }

    public void setToolbarTitle(String title){
        if(getSupportActionBar() !=null){
            getSupportActionBar().setTitle(title);
        }
    }
    public void setContent(BaseFragment fragment){
        myFragmentManager.setFragment(this,fragment,R.id.main_wraper);

    }

    public void addContent (BaseFragment fragment){
        myFragmentManager.addFragment(this,fragment,R.id.main_wraper);
    }

    public boolean removeCurrentFragment (){
        return myFragmentManager.removeCurrentFragment(this);
    }

    public boolean removeFragment (BaseFragment fragment){
        return myFragmentManager.removeFragment(this, fragment);
    }

    @Override
    public void onBackPressed() {
        removeCurrentFragment();
    }
}
