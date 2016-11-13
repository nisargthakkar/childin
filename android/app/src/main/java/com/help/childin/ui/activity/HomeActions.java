package com.help.childin.ui.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.help.childin.R;
import com.help.childin.models.UserModel;
import com.help.childin.ui.fragment.ChildrenFragment;
import com.help.childin.ui.fragment.HomeFragment;
import com.help.childin.ui.fragment.MyDonationFragment;
import com.help.childin.ui.fragment.NotificationFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActions extends AppCompatActivity implements
        NotificationFragment.OnFragmentInteractionListener, MyDonationFragment.OnFragmentInteractionListener{

    public static final String KEY_ACTION_NOTE = "notifications";
    public static final String KEY_ACTION_DON = "donations";
    public static final String KEY_ACTION_CH = "childrens";


    List<UserModel> userModels = new ArrayList<>();


    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    String CURRENT_TAG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_actions);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);

        Fragment fragment ;
        if(getIntent().hasExtra(KEY_ACTION_NOTE)){
            CURRENT_TAG = "Notifications";
            fragment  = getFragment(0);
        }else if(getIntent().hasExtra(KEY_ACTION_DON)){
            CURRENT_TAG = "Donations";
            fragment  = getFragment(1);
        }else{
            CURRENT_TAG = "My Children";
            fragment  = getFragment(2);
        }

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(CURRENT_TAG);
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        fragmentTransaction.replace(R.id.frame_layout, fragment, CURRENT_TAG);
        fragmentTransaction.commitAllowingStateLoss();

    }

    private Fragment getFragment(int navItemIndex) {
        switch (navItemIndex) {
            case 0:
                NotificationFragment notificationFragment = new NotificationFragment();
                return notificationFragment;
            case 1:
                MyDonationFragment myDonationFragment = new MyDonationFragment();
                return myDonationFragment;
            case 2:
                ChildrenFragment childrenFragment = new ChildrenFragment();
                return childrenFragment;
            default:
                return new ChildrenFragment();
        }
    }
}
