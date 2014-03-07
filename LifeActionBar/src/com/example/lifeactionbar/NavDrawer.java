package com.example.lifeactionbar;

import android.app.FragmentManager;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class NavDrawer extends SherlockActivity implements OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nav_drawer);
		
		final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout); 
        final ListView drawerList = (ListView) findViewById(R.id.left_drawer);        
        final ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer,R.drawable.ic_launcher, R.string.open_drawer,R.string.hello_world) {
            @Override
            public void onDrawerOpened(View drawerView) {
                // TODO Auto-generated method stub
                super.onDrawerOpened(drawerView);
                drawerList.setOnItemClickListener(this);
                drawer.setDrawerListener(actionBarDrawerToggle);
            }
            
        
        };
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.nav_drawer, menu);
		
		com.actionbarsherlock.view.MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.nav_drawer, (com.actionbarsherlock.view.Menu) menu);
		return super.onCreateOptionsMenu(menu);		
	}

    @Override
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        openFragment(position);
    }
    
    private void openFragment(int position) {
        FragmentManager manager = getSupportFragmentManager();
        switch (position) {
        case 0:
            FragmentOne firstFragment = new FragmentOne();
            manager.beginTransaction()
                    .replace(R.id.content_frame, firstFragment).commit();
            break;
        case 1:
            FragmentTwo otherFragment = new FragmentTwo();
            manager.beginTransaction()
                    .replace(R.id.content_frame, otherFragment).commit();
            break;
        case 2:
            AppPrefsFragment prefsFragment = new AppPrefsFragment();
            manager.beginTransaction()
                    .replace(R.id.content_frame, prefsFragment).commit();
            break;

        default:
            break;
        }
        drawer.closeDrawer(drawerList);

    }    

}
