package project.pb.petbuddy.activities;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import project.pb.petbuddy.base.BaseActivity;
import project.pb.petbuddy.R;
import project.pb.petbuddy.fragment.DrawerFragment;
import project.pb.petbuddy.fragment.MainFragment;

/**
 * Created by meme on 15. 5. 17..
 */
public class MainActivity extends BaseActivity implements DrawerFragment.OnFragmentInteractionListener{

    private Toolbar toolbar;
    private DrawerLayout dlDrawer;
    private ActionBarDrawerToggle dtToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, MainFragment.newInstance()).commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Log.d("meme", " setNavigationOnClickListener ");
            }
        });

        dlDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        dtToggle = new ActionBarDrawerToggle(this, dlDrawer, toolbar,  R.string.app_name, R.string.app_name);
        dlDrawer.setDrawerListener(dtToggle);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);



       dtToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        dtToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
