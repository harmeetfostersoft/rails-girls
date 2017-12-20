package com.example.fostersoftsol01.luvoffers;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.fostersoftsol01.luvoffers.Animation.Accordion;
import com.example.fostersoftsol01.luvoffers.ClintionCards.ClintionHome;
import com.example.fostersoftsol01.luvoffers.Costa.CostaHome;
import com.example.fostersoftsol01.luvoffers.Debenhams.DebenhamsHome;
import com.example.fostersoftsol01.luvoffers.GreggsBakery.GreggsHome;
import com.example.fostersoftsol01.luvoffers.MS.MsHome;
import com.example.fostersoftsol01.luvoffers.McDonalds.McDonaldsHome;
import com.example.fostersoftsol01.luvoffers.Next.NextHome;
import com.example.fostersoftsol01.luvoffers.SelectProduct.SelectProduct;
import com.example.fostersoftsol01.luvoffers.Tesco.TescoHome;
import com.example.fostersoftsol01.luvoffers.Testnavigation.BaseActivity;
import com.example.fostersoftsol01.luvoffers.Util.HelperView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements View.OnClickListener,GestureDetector.OnGestureListener {

//    private LinearLayoutManager lLayout;
    private LinearLayout tilesContainer;
    private ImageView imgMenu;
    LinearLayout navigationMenu;
    RelativeLayout relativeViewMain;
    private  List<ItemObject> rowListItem;
    CoordinatorLayout coordinateLayout;
    RecyclerView recycler_view;

    protected ListView mDrawerList;
    DrawerLayout mDrawerLayout;

    SharedPreferences sharedpreferences;

    public static boolean isOnHome = false;
    private long lastPressedTime;
    private static final int PERIOD = 2000;


    private static final int TIME_TO_AUTOMATICALLY_DISMISS_ITEM = 3000;

//    private static final String LOG_TAG = Accordion.class.getSimpleName();
//
    public static Accordion accordion;
//    Animation animSlideUp;
//
//    RecycleViewAdapter recycleViewAdapter;


    Context mContext = MainActivity.this;

//    private LinearLayout tilesContainer;
    private ScrollView mainScrollView;

    private int[] colors = new int[8];

    private int ANIMATION_DURATION = 300; //in milliseconds
    private int firstChildHeight;
    private int defaultChildHeight;

    private boolean toAnimate = true;
    private boolean toFantasticScroll = true;

    private GestureDetectorCompat detector;
    private Toolbar appBar;
    private Intent intent;

    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        // init((RecyclerView) findViewById(R.id.recycler_view))

        setTitle(null);

        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);

        accordion = new Accordion(MainActivity.this);
        accordion.updateChildViews();

        getLayoutInflater().inflate(R.layout.activity_main, frameLayout);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        tilesContainer = (LinearLayout) findViewById(R.id.tilesContainer);

//        accordion = new Accordion(MainActivity.this);

        //  ArrayList<Integer> imageList =  (ArrayList<Integer>)getIntent().getSerializableExtra("arry_send");
        navigationMenu = (LinearLayout)findViewById(R.id.navigationMenu);
        relativeViewMain = (RelativeLayout)findViewById(R.id.relativeViewMain);


        imgMenu = (ImageView)findViewById(R.id.imgMenu);



//        lLayout = new LinearLayoutManager(MainActivity.this);


//        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
//        rView.setLayoutManager(lLayout);
//
//        RecycleViewAdapter rcAdapter = new RecycleViewAdapter(MainActivity.this, rowListItem);
//        rView.setAdapter(rcAdapter);



//        recycler_view = (RecyclerView)findViewById(R.id.recycler_view);
//        coordinateLayout = (CoordinatorLayout) findViewById(R.id.coordinateLayout);
//
//
//        coordinateLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                return true;
//            }
//        });


        tilesContainer = (LinearLayout) findViewById(R.id.tilesContainer);

        mainScrollView = (ScrollView) findViewById(R.id.mainScrollView);
        mainScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        /**
         * Animation work start
         */
        detector = new GestureDetectorCompat(this, this);
        int displayHeight = getWindowManager().getDefaultDisplay().getHeight();
        firstChildHeight = (displayHeight * 60) / 100; //first tile should cover 60% of height
        defaultChildHeight = displayHeight / 6;


        /**
         * animation work end
         */
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mDrawerLayout.isDrawerOpen(mDrawerList)){
                    mDrawerLayout.closeDrawer(mDrawerList);
                }else {
                    mDrawerLayout.openDrawer(mDrawerList);
                }

            }
        });

        rowListItem = new ArrayList<>();

        if(SelectProduct.is_skip || SelectProduct.is_all)
        {
            rowListItem.add(new ItemObject("10 SAUSAGE ROLLS FOR 50P","GREGGS BAKERY","", R.drawable.greggs_main_new));
            rowListItem.add(new ItemObject("1 COFFE = 1 FREE MUFFIN","COSTA COFFEE","",  R.drawable.costa_new));
            rowListItem.add(new ItemObject("50% OFF ALL MEANSWEAR ","NEXT","",  R.drawable.next));
            rowListItem.add(new ItemObject("FREE BIG MAC BURGERS","MCDONALDS","",  R.drawable.mc_d_new));
            rowListItem.add(new ItemObject("FRUIT SALADS 75% OFF","MARK & SPENCER","",  R.drawable.ms_new));
            rowListItem.add(new ItemObject("50% OFF ALL CLOTHES","DEBENHAMS","",  R.drawable.debehans_new));
            rowListItem.add(new ItemObject("FREE WRAPPING PAPER","CLINTON CARDS","",  R.drawable.clintion_new));
            rowListItem.add(new ItemObject("BANANAS FOR £1 ","TESCO EXTRA","",  R.drawable.tesco));
        }
        else
        {
            rowListItem =  getAllItemList();
        }
        addTilesToContainer();
    }

//    /////////// navigation \\\\\\\\\\\\
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if (toFantasticScroll) {
//            detector.onTouchEvent(ev);
//        }
//        return super.dispatchTouchEvent(ev);
//    }




        View tileView;

        int[] images = {
                R.drawable.greggs_main_new,
                R.drawable.costa_new,
                R.drawable.next,
                R.drawable.mc_d_new,
                R.drawable.ms_new,
                R.drawable.debehans_new,
                R.drawable.clintion_new,
                R.drawable.tesco
        };


    @Override
    protected void onResume() {
        super.onResume();
        isOnHome = true;

    }

    @Override
    protected void onStop() {
        super.onStop();
        isOnHome = false;
    }

    @Override
    public void onClick(View v) {
        if (v.getTag().toString().contains("tile")) {
            if (v.getLayoutParams().height != firstChildHeight) {
                expandView(v);
            } else {
                switch (tilesContainer.indexOfChild(v)) {
                    case 0:
                        if (tilesContainer.getChildAt(0).getLayoutParams().height != firstChildHeight) {
                            downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                        } else {
//                            isFragmentOpened = true;
//                            fragment = (SampleFragment) Fragment.instantiate(this, SampleFragment.class.getName());
//                            addFragmentToScreen(fragment);
                        }
                        break;

                    case 1:
                        if (tilesContainer.getChildAt(1).getLayoutParams().height != firstChildHeight) {
                            downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                        }
                        break;

                    case 2:
                        if (tilesContainer.getChildAt(2).getLayoutParams().height != firstChildHeight) {
                            downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                        }
                        break;

                    case 3:
                        break;

                    case 4:
                        break;
                }
            }
        }
        switch (v.getTag().toString()) {
            case "tile - DEBENHAMS":
                intent = new Intent(MainActivity.this,DebenhamsHome.class);
                startActivity(intent);
                break;
            case "tile - CLINTON CARDS":
                intent = new Intent(MainActivity.this,ClintionHome.class);
                startActivity(intent);
                break;
            case "tile - TESCO EXTRA":
                intent = new Intent(MainActivity.this,TescoHome.class);
                startActivity(intent);
                break;
            case "tile - GREGGS BAKERY":
                intent = new Intent(MainActivity.this,GreggsHome.class);
                startActivity(intent);
                break;
            case "tile - COSTA COFFEE":
                intent = new Intent(MainActivity.this,CostaHome.class);
                startActivity(intent);
                break;
            case "tile - NEXT":
                intent = new Intent(MainActivity.this,NextHome.class);
                startActivity(intent);
                break;
            case "tile - MCDONALDS":
                intent = new Intent(MainActivity.this,McDonaldsHome.class);
                startActivity(intent);
                break;
            case "tile - MARK & SPENCER":
                intent = new Intent(MainActivity.this,MsHome.class);
                startActivity(intent);
                break;
                default:
//                    Toast.makeText(mContext, v.getTag()+"", Toast.LENGTH_SHORT).show();
                    break;
        }
//        switch (v.getTag().toString()) {
//            case "0":
//                Toast.makeText(this, "Open Categories", Toast.LENGTH_SHORT).show();
//                break;
//
//            case "1":
//                if (tilesContainer.getChildAt(1).getLayoutParams().height != firstChildHeight) {
//                    downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
//                }
//                break;
//
//            case "2":
//                if (tilesContainer.getChildAt(2).getLayoutParams().height != firstChildHeight) {
//                    downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
//                }
//                break;
//
//            case "3":
//                break;
//
//            case "4":
//                break;
//
//        }
    }

    public void expandView(final View view) {

        int currentScrollPosition = mainScrollView.getScrollY();
        int finalScrollPosition = view.getTop();

        ValueAnimator scrollAnimator = ValueAnimator.ofInt(currentScrollPosition, finalScrollPosition);
        scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int amount = (int) animation.getAnimatedValue();
                mainScrollView.scrollTo(0, amount);
            }
        });
        scrollAnimator.setDuration(ANIMATION_DURATION);

        ValueAnimator heightAnimator = ValueAnimator.ofInt(view.getHeight(), firstChildHeight);
        heightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int height = (int) animation.getAnimatedValue();
                view.getLayoutParams().height = height;
                view.requestLayout();
            }
        });
        heightAnimator.setDuration(ANIMATION_DURATION);

        scrollAnimator.start();
        heightAnimator.start();

        if (tilesContainer.indexOfChild(view) == 0) {
            //do nothing
        } else {
            HelperView.setPrecedingView(tilesContainer.getChildAt(tilesContainer.indexOfChild(view) - 1));
        }
        HelperView.setCurrentView(view);
        HelperView.setFollowingView(tilesContainer.getChildAt(tilesContainer.indexOfChild(view) + 1));
//        HelperView.getCurrentView().findViewById(R.id.tvHeaderTitle).setVisibility(View.VISIBLE);
//        if (tilesContainer.indexOfChild(view) < 4) {
//            HelperView.getFollowingView().findViewById(R.id.tvHeaderTitle).setVisibility(View.INVISIBLE);
//        }
    }





    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();

        accordion = new Accordion(this);

        for(int i = 0; i < SelectProduct.al_intrested_images.size(); i++ )
        {
            if(SelectProduct.al_intrested_images.get(i).equals(R.drawable.greggs_main_new))
            {
                allItems.add(new ItemObject("10 SAUSAGE ROLLS FOR 50P","GREGGS BAKERY","", R.drawable.greggs_main_new));
            }
            else if(SelectProduct.al_intrested_images.get(i).equals(R.drawable.costa_new))
            {
                allItems.add(new ItemObject("1 COFFE = 1 FREE MUFFIN","COSTA COFFEE","",  R.drawable.costa_new));
            }
            else if(SelectProduct.al_intrested_images.get(i).equals(R.drawable.next))
            {
                allItems.add(new ItemObject("50% OFF ALL MEANSWEAR ","NEXT","",  R.drawable.next));
            }
            else if(SelectProduct.al_intrested_images.get(i).equals(R.drawable.mc_d_new))
            {
                allItems.add(new ItemObject("FREE BIG MAC BURGERS","MCDONALDS","",  R.drawable.mc_d_new));
            }
            else if(SelectProduct.al_intrested_images.get(i).equals(R.drawable.ms_new))
            {
                allItems.add(new ItemObject("FRUIT SALADS 75% OFF","MARK & SPENCER","",  R.drawable.ms_new));
            }
            else if(SelectProduct.al_intrested_images.get(i).equals(R.drawable.debehans_new))
            {
                allItems.add(new ItemObject("50% OFF ALL CLOTHES","DEBENHAMS","",  R.drawable.debehans_new));
            }
            else if(SelectProduct.al_intrested_images.get(i).equals(R.drawable.clintion_new))
            {
                allItems.add(new ItemObject("FREE WRAPPING PAPER","CLINTON CARDS","",  R.drawable.clintion_new));
            }
            else if(SelectProduct.al_intrested_images.get(i).equals(R.drawable.tesco))
            {
                allItems.add(new ItemObject("BANANAS FOR £1 ","TESCO EXTRA","",  R.drawable.tesco));
            }

        }

//        allItems.add(new ItemObject("BANANAS HALF PRICE FOR 1 HOUR","TESCO EXTER","Jackson Street 5",  R.drawable.tesco));
//        allItems.add(new ItemObject("1 COFFE = 1 FREE MUFFIN","COSTA COFFEE","Jackson Street 5",  R.drawable.costa_new));
//        allItems.add(new ItemObject("50% OFF ALL CLOTHES","DEBENHAMS","Jackson Street 5",  R.drawable.debehans_new));
//        allItems.add(new ItemObject("WRAPPING PAPER FREE = ALL CARDS","CLINTON CARDS","Jackson Street 5",  R.drawable.clintion_new));
//        allItems.add(new ItemObject("50% OF MENSWEAR FOR THE NEXT HOUR","NEXT","Jackson Street 5",  R.drawable.next));
//        allItems.add(new ItemObject("FRUIT SALADS FOR 50P","MARK & SPENCER","Jackson Street 5",  R.drawable.ms_new));
//        allItems.add(new ItemObject("FREE BIG MAC BURGERS","MCDONALDS","Jackson Street 5",  R.drawable.mc_d_new));

        return allItems;
    }



    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Intent a = new Intent(Intent.ACTION_MAIN);
                        a.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        a.addCategory(Intent.CATEGORY_HOME);
                        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(a);
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    /**
     *  Add views start
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (toFantasticScroll) {
            detector.onTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void addTilesToContainer() {
        View tileView;
        int numberOfTiles = rowListItem.size();
        for (int i = 0; i < numberOfTiles; i++) {

            if (i == 0) {
                    tileView = LayoutInflater.from(MainActivity.this).inflate(R.layout.chanel_layout, null);
                tileView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        firstChildHeight));
                tileView.setTag("tile - " + rowListItem.get(i).getSubValue());
                tileView.setOnClickListener(this);

                ImageView imageView = (ImageView) tileView.findViewById(R.id.imgHeader);
                imageView.setImageResource(rowListItem.get(i).getPhoto());
                tileView.setOnClickListener(this);


                TextView tagLine = (TextView) tileView.findViewById(R.id.tvHeaderTitle);
                tagLine.setText(rowListItem.get(i).getName());
                TextView tvSubTitle = (TextView) tileView.findViewById(R.id.tvHeaderSubTitle);
                tvSubTitle.setText(rowListItem.get(i).getSubValue());

                tilesContainer.addView(tileView);
            } else {
                tileView = LayoutInflater.from(mContext).inflate(R.layout.chanel_layout, null);
                tileView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        defaultChildHeight));
                tileView.setTag("tile - " + rowListItem.get(i).getSubValue());
                tileView.setOnClickListener(this);

                ImageView imageView = (ImageView) tileView.findViewById(R.id.imgHeader);
                imageView.setImageResource(rowListItem.get(i).getPhoto());
                tileView.setOnClickListener(this);
                TextView tagLine = (TextView) tileView.findViewById(R.id.tvHeaderTitle);
                tagLine.setText(rowListItem.get(i).getName());
//                tagLine.setVisibility(View.INVISIBLE);
                TextView tvSubTitle = (TextView) tileView.findViewById(R.id.tvHeaderSubTitle);
                tvSubTitle.setText(rowListItem.get(i).getSubValue());

                tilesContainer.addView(tileView);
            }
        }

        HelperView.setPrecedingView(null);
        HelperView.setCurrentView(tilesContainer.getChildAt(0));
//        HelperView.getCurrentView().findViewById(R.id.tvHeaderTitle).setVisibility(View.VISIBLE);
        HelperView.setFollowingView(tilesContainer.getChildAt(1));
    }

    /**
     * Add views end
     */


    /**
     * Gesture methods start
     * @param e
     * @return
     */
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        final int SWIPE_MIN_DISTANCE = 50;
        final int SWIPE_THRESHOLD_VELOCITY = 200;

        if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE &&
                Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
            //Toast.makeText(this, "Bottom to top", Toast.LENGTH_SHORT).show();
            if (HelperView.getFollowingView() != null) {
                downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
            }
            //From Bottom to top
            return true;
        } else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE &&
                Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
            //Toast.makeText(this, "top to Bottom", Toast.LENGTH_SHORT).show();
            if (HelperView.getPrecedingView() != null) {
                upToDownScroll(HelperView.getPrecedingView(), HelperView.getCurrentView());
            }
            //From top to Bottom
            return true;
        }
        return true;
    }
    public void upToDownScroll(final View precedingView, final View currentView) {

        if (toAnimate) {

            toAnimate = false;

            if (tilesContainer.indexOfChild(currentView) == 0) {
                //do-nothing
            } else {
                int currentScrollPosition = mainScrollView.getScrollY();
                int toScrollPosition = precedingView.getTop();

                ValueAnimator scrollAnimator = ValueAnimator.ofInt(currentScrollPosition, toScrollPosition);
                scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int amount = (int) animation.getAnimatedValue();
                        mainScrollView.scrollTo(0, amount);
                    }
                });
                scrollAnimator.setDuration(ANIMATION_DURATION);

                ValueAnimator heightAnimator = ValueAnimator.ofInt(currentView.getLayoutParams().height, defaultChildHeight);
                heightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int height = (int) animation.getAnimatedValue();
                        currentView.getLayoutParams().height = height;
                        currentView.requestLayout();
                    }
                });
                heightAnimator.setDuration(ANIMATION_DURATION);

                scrollAnimator.start();
                heightAnimator.start();

                HelperView.setCurrentView(precedingView);
                HelperView.setPrecedingView(tilesContainer.getChildAt(tilesContainer.indexOfChild(precedingView) - 1));
                HelperView.setFollowingView(currentView);
//                HelperView.getCurrentView().findViewById(R.id.tvHeaderTitle).setVisibility(View.VISIBLE);
//                HelperView.getFollowingView().findViewById(R.id.tvHeaderTitle).setVisibility(View.INVISIBLE);

                scrollAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                        toAnimate = false;
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        toAnimate = true;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        }
    }

    public void downToUpScroll(View currentView, final View followingView) {

        if (toAnimate) {

            toAnimate = false;

            int currentScrollPosition = mainScrollView.getScrollY();
            int toScrollPosition = followingView.getTop();

            ValueAnimator scrollAnimator = ValueAnimator.ofInt(currentScrollPosition, toScrollPosition);
            scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int amount = (int) animation.getAnimatedValue();
                    mainScrollView.scrollTo(0, amount);
                }
            });
            scrollAnimator.setDuration(ANIMATION_DURATION);

            ValueAnimator heightAnimator = ValueAnimator.ofInt(followingView.getHeight(), firstChildHeight);
            heightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int height = (int) animation.getAnimatedValue();
                    followingView.getLayoutParams().height = height;
                    followingView.requestLayout();
                }
            });
            heightAnimator.setDuration(ANIMATION_DURATION);

            scrollAnimator.start();
            heightAnimator.start();

            scrollAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    toAnimate = true;
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            HelperView.setPrecedingView(currentView);
            HelperView.setCurrentView(followingView);
            HelperView.setFollowingView(tilesContainer.getChildAt(tilesContainer.indexOfChild(followingView) + 1));
//            HelperView.getCurrentView().findViewById(R.id.tvHeaderTitle).setVisibility(View.VISIBLE);
        }
    }

    /**
     * Gesture methods end
     */
}
