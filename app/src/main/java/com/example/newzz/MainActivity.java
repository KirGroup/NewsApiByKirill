package com.example.newzz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.newzz.adapter.CategoryAdapter;
import com.example.newzz.adapter.NewsAdapter;
import com.example.newzz.database.News;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

import okhttp3.OkHttpClient;

//  LoaderManager.LoaderCallbacks<List<News>>
public class MainActivity extends AppCompatActivity {

//    private List<News> mNewsList;
//    private NewsAdapter mNewsAdapter;
//    private static final int LOADER_ID = 0;
//    private String mjson;
//
//    private final OkHttpClient client = new OkHttpClient();
//
//    private static final String JSON_RESPONSE = "https://newsapi.org/v2/top-headlines?country=in&apiKey=c3a342cc6d394cb19fc3db635741e77f";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager2 viewPager = (ViewPager2) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(this);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                if (position == 0)
                    tab.setText("News");
                else
                    tab.setText("Favorite");
            }
        }).attach();

    }
}
