package app.vocabulary.craftystudio.vocabularymaster;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import utils.Word;
import utils.ZoomOutPageTransformer;

public class WordLearnActivity extends AppCompatActivity {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    ArrayList<Word> mWordList = new ArrayList<>();

    private Word word;

    private String levelName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_learn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        levelName = getIntent().getStringExtra("Level").toString();

        mPager = (ViewPager) findViewById(R.id.wordLearnActivity_viewpager);
        initializeViewPager();

        downloadWordByLevel(levelName);


    }

    private void downloadWordByLevel(String levelName) {

        Word word = new Word();
        word.setWordName("Hey!");
        word.setWordAntonyms("hejhk");
        word.setWordSynonyms("jkola");
        word.setWordExample("hjaoldj");
        word.setWordMeaning("jola");

        mWordList.add(word);
        mWordList.add(word);
        mWordList.add(word);
        mWordList.add(word);
        mWordList.add(word);

        mPagerAdapter.notifyDataSetChanged();


    }

    private void initializeViewPager() {

        // Instantiate a ViewPager and a PagerAdapter.

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        //change to zoom
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });

    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {


            //  adsCount++;
            return WordLearnFragment.newInstance(mWordList.get(position), WordLearnActivity.this);
        }

        @Override
        public int getCount() {
            return mWordList.size();
        }

    }


}
