package com.codepath.apps.mytwitterapp.activities;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.codepath.apps.mytwitterapp.R;
import com.codepath.apps.mytwitterapp.databinding.ActivityFriendsBinding;
import com.codepath.apps.mytwitterapp.fragments.FollowersFragment;
import com.codepath.apps.mytwitterapp.fragments.FollowingFragment;

public class FriendsActivity extends AppCompatActivity {

    public static final int FOLLOW = 1;
    public static final int FOLLOWING = 2;
    public static final String FOLLOWITEM = "follow_item";
    public static final String USERID = "id";

    ActivityFriendsBinding binding;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_friends);
        toolbar = binding.appBar.toolbar;
        toolbar.setBackgroundColor(getResources().getColor(R.color.twitter_logo_blue));
        toolbar.setLogo(R.drawable.ic_twittericon);


        long ID = getIntent().getExtras().getLong(USERID);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if(getIntent().getExtras().getInt(FOLLOWITEM)==FOLLOW){
            toolbar.setTitle("   Followers");
            FollowersFragment frag = FollowersFragment.newInstance(ID);
            ft.replace(R.id.friendFrameContainer,frag).commit();

        }
        else if(getIntent().getExtras().getInt(FOLLOWITEM)==FOLLOWING){
            toolbar.setTitle("   Following");
            FollowingFragment frag = FollowingFragment.newInstance(ID);
            ft.replace(R.id.friendFrameContainer,frag).commit();

        }
        else
            toolbar.setTitle("   Followers");

        setSupportActionBar(toolbar);
    }
}
