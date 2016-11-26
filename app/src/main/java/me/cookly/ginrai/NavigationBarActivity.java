package me.cookly.ginrai;

import android.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class NavigationBarActivity extends AppCompatActivity {


    private ShareFragment shareFragment = null;
    private LiveFeedFragment liveFeedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar);


        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_share) {
                    // The tab with id R.id.tab_favorites was selected,
                    // change your content accordingly.
                    System.out.println("share");
                    if(shareFragment == null) {
                        shareFragment = new ShareFragment();
                        System.out.println("New Fragment");
                    }
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.homepageContentContainer, shareFragment).commit();
                }
                if (tabId == R.id.tab_live_feed) {
                    // The tab with id R.id.tab_favorites was selected,
                    // change your content accordingly.
                    System.out.println("live feed");
                    if(liveFeedFragment == null) {
                        liveFeedFragment = new LiveFeedFragment();
                        System.out.println("New Fragment");
                    }
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.homepageContentContainer, liveFeedFragment).commit();
                }
            }
        });
    }
}
