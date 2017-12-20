package com.example.fostersoftsol01.luvoffers.Testnavigation;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.fostersoftsol01.luvoffers.MainActivity;
import com.example.fostersoftsol01.luvoffers.Offers.ContactUs;
import com.example.fostersoftsol01.luvoffers.Offers.HowItWork;
import com.example.fostersoftsol01.luvoffers.R;
import com.example.fostersoftsol01.luvoffers.SignIn;
import com.example.fostersoftsol01.luvoffers.Testnavigation.Adapter.NavigationDrawerListAdapter;
import com.example.fostersoftsol01.luvoffers.Testnavigation.Model.Items;
import com.example.fostersoftsol01.luvoffers.Userprofile;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {

    private AlertDialog dialogShare;
    /**
     *  Frame layout: Which is going to be used as parent layout for child activity layout.
     *  This layout is protected so that child activity can access this
     *  */
    protected FrameLayout frameLayout;

    /**
     * ListView to add navigation drawer item in it.
     * We have made it protected to access it in child class. We will just use it in child class to make item selected according to activity opened.
     */

    protected ListView mDrawerList;

    /**
     * List item array for navigation drawer items.
     * */
    protected String[] listArray = { "Home", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
    protected ArrayList<Items> _items;

    /**
     * Static variable for selected item position. Which can be used in child activity to know which item is selected from the list.
     * */
    protected static int position;

    /**
     *  This flag is used just to check that launcher activity is called first time
     *  so that we can open appropriate Activity on launch and make list item position selected accordingly.
     * */
    private static boolean isLaunch = true;

    /**
     *  Base layout node of this Activity.
     * */
    private DrawerLayout mDrawerLayout;

    /**
     * Drawer listner class for drawer open, close etc.
     */
    private ActionBarDrawerToggle actionBarDrawerToggle;


    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer_base_layout);

        frameLayout = (FrameLayout)findViewById(R.id.content_frame);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // set a custom shadow that overlays the main content when the drawer opens
        //mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        _items = new ArrayList<Items>();

        _items.add(new Items("Offers", "", R.drawable.offer));
        _items.add(new Items("profile", "", R.drawable.offer));
        _items.add(new Items("Contact Us", "", R.drawable.contact_us_new));
        _items.add(new Items("Share", "", R.drawable.share_new));
        _items.add(new Items("How It Works", "", R.drawable.work_new));
        _items.add(new Items("Logout", "", R.drawable.work_new));

        //_items.add(new Items("Item Five", "Item Five Description", R.drawable.menu_2));

        //Adding header on list view
        View header = (View)getLayoutInflater().inflate(R.layout.list_view_header_layout, null);
        mDrawerList.addHeaderView(header);

        // set up the drawer's list view with items and click listener
        mDrawerList.setAdapter(new NavigationDrawerListAdapter(BaseActivity.this, _items));
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                openActivity(position);
            }
        });

        // enable ActionBar app icon to behave as action to toggle nav drawer
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        getActionBar().setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions between the sliding drawer and the action bar app icon
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,						/* host Activity */
                mDrawerLayout, 				/* DrawerLayout object */
                R.mipmap.ic_launcher,     /* nav drawer image to replace 'Up' caret */
                R.string.open_drawer,       /* "open drawer" description for accessibility */
                R.string.close_drawer)      /* "close drawer" description for accessibility */
        {
            @Override
            public void onDrawerClosed(View drawerView) {
                //getActionBar().setTitle(listArray[position]);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                //getActionBar().setTitle(getString(R.string.app_name));
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
            }
        };
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);


        /**
         * As we are calling BaseActivity from manifest file and this base activity is intended just to add navigation drawer in our app.
         * We have to open some activity with layout on launch. So we are checking if this BaseActivity is called first time then we are opening our first activity.
         * */
        if(isLaunch){
            /**
             *Setting this flag false so that next time it will not open our first activity.
             *We have to use this flag because we are using this BaseActivity as parent activity to our other activity.
             *In this case this base activity will always be call when any child activity will launch.
             */
            isLaunch = false;
            openActivity(0);
        }
    }

    /**
     * @param position
     *
     * Launching activity when any list item is clicked.
     */
    protected void openActivity(int position) {

//		mDrawerList.setItemChecked(position, true);
//		setTitle(listArray[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
        BaseActivity.position = position; //Setting currently selected position in this field so that it will be available in our child activities.

        switch (position) {
            case 1:
                if (!MainActivity.isOnHome)
                   finish();
//                Toast.makeText(this, ""+MainActivity.isOnHome, Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(this, MainActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, Userprofile.class));
                break;
            case 3:
                startActivity(new Intent(this, ContactUs.class));
                break;
            case 4:
//                AlertDialog.Builder builder ;
//                builder = new AlertDialog.Builder(BaseActivity.this);
//                LayoutInflater inflater = ((Activity) BaseActivity.this).getLayoutInflater();
//
//
//                View v = inflater.inflate(R.layout.share_app, null);
//                builder.setView(v);
//
//
//                dialogShare= builder.create();
//                dialogShare.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//
//                dialogShare.show();

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String sAux = "\nLet me recommend you this application\n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=Orion.Soft \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "choose one"));

                break;
            case 5:
                startActivity(new Intent(this, HowItWork.class));
                break;
            case 6:
                startActivity(new Intent(this, SignIn.class));
                break;
//            case 5:
//                startActivity(new Intent(this, Item1Activity.class));
//                break;

        }

//		Toast.makeText(this, "Selected Item Position::"+position, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        // menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    /* We can override onBackPressed method to toggle navigation drawer*/
//    @Override
//    public void onBackPressed() {
//        if(mDrawerLayout.isDrawerOpen(mDrawerList)){
//            mDrawerLayout.closeDrawer(mDrawerList);
//        }else {
//            mDrawerLayout.openDrawer(mDrawerList);
//        }
//    }
}

