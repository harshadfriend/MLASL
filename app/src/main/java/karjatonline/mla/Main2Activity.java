package karjatonline.mla;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        setTitle("MLA Mr. Sureshbhau Lad");
        setTitle(R.string.titlemarathi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main2, container, false);

            LinearLayout ll=rootView.findViewById(R.id.ll);


            ListView lv=rootView.findViewById(R.id.lv);
            LinearLayout llIntro=rootView.findViewById(R.id.llIntro);


/*            WebView wv1=rootView.findViewById(R.id.wv1);
            wv1.getSettings().setJavaScriptEnabled(true);
            wv1.getSettings().setDomStorageEnabled(true);
            wv1.setWebViewClient(new WebViewClient());
            wv1.loadUrl("https://www.facebook.com/pg/udaybhai.ncp/posts/");
            wv1.loadUrl("file:///android_asset/index - Copy.html");
*/

            if(getArguments().getInt(ARG_SECTION_NUMBER)==1) {
                rootView = inflater.inflate(R.layout.home, container, false);
                TextView tvHome = (TextView) rootView.findViewById(R.id.tvHome);
                //textView.setVisibility(View.VISIBLE);
                tvHome.setBackgroundColor(Color.parseColor("#55ffffff"));
                llIntro.setVisibility(View.GONE);
            }
            if(getArguments().getInt(ARG_SECTION_NUMBER)==2) {

//                wv.setVisibility(View.GONE);
                llIntro.setVisibility(View.VISIBLE);
            }

            if(getArguments().getInt(ARG_SECTION_NUMBER)==3) {
                rootView = inflater.inflate(R.layout.vikaskarya, container, false);
                WebView wv=rootView.findViewById(R.id.wvVikaskarya);
                wv.getSettings().setJavaScriptEnabled(true);

                wv.setWebViewClient(new WebViewClient());

                wv.getSettings().setDisplayZoomControls(false);
                wv.getSettings().setBuiltInZoomControls(true);
                wv.loadUrl("https://wwwkarjatonlinecom.000webhostapp.com/mla/vikaskarya.html");
//                 wv.loadUrl("file:///android_asset/index - Copy.html");
//            wv.loadUrl("file:///android_asset/test.html");


                //lv.setVisibility(View.VISIBLE);

//                ImageListAdapter adp=new ImageListAdapter(getContext(),R.layout.imagelistlayout,getData());
//                lv.setAdapter(adp);
            }
            if(getArguments().getInt(ARG_SECTION_NUMBER)==4) {

                rootView = inflater.inflate(R.layout.socialmedia, container, false);
                WebView wvsm=rootView.findViewById(R.id.wvSM);
                wvsm.getSettings().setJavaScriptEnabled(true);
                wvsm.setWebViewClient(new WebViewClient());
                wvsm.getSettings().setDisplayZoomControls(false);
                wvsm.getSettings().setBuiltInZoomControls(true);
                wvsm.loadUrl("https://www.facebook.com/pg/udaybhai.ncp/posts/");
                //lv.setVisibility(View.VISIBLE);

//                ImageListAdapter adp=new ImageListAdapter(getContext(),R.layout.imagelistlayout,getData());
//                lv.setAdapter(adp);
            }
            return rootView;
        }

        /*private ArrayList<ImageItem> getData() {
            final ArrayList<ImageItem> imageItems = new ArrayList<>();
            TypedArray imgs = getResources().obtainTypedArray(R.array.imgs);
//            for (int i = 0; i < imgs.length(); i++) {
            for (int i = 0; i < 15; i++) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
                imageItems.add(new ImageItem(bitmap, "Image#" + i));
            }
            return imageItems;
        }*/
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }
    }
}
