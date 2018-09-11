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

public class WordReviseActivity extends AppCompatActivity {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    ArrayList<Word> mWordList = new ArrayList<>();

    private Word word;

    private String levelName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_revise);
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

        mPager = (ViewPager) findViewById(R.id.wordReviseActivity_viewpager);
        initializeViewPager();

        downloadWords();
    }

    private void downloadWords() {

        Word word = new Word();
        word.setWordMeaning("meaning");
        word.setWordExample("example is this");
        word.setWordSynonyms("synonyms");
        word.setWordAntonyms("antonym is this");
        word.setWordName("word");
        word.setOptionA("m");
        word.setOptionB("b");
        word.setOptionC("meaning");
        word.setOptionD("d");
        word.setWordLevel(1);

        mWordList.add(word);
        mWordList.add(word);
        mWordList.add(word);
        mWordList.add(word);
        mWordList.add(word);

        mPagerAdapter.notifyDataSetChanged();


    }

    private void initializeViewPager() {

        // Instantiate a ViewPager and a PagerAdapter.

        mPagerAdapter = new WordReviseActivity.ScreenSlidePagerAdapter(getSupportFragmentManager());
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
            return WordReviseFragment.newInstance(mWordList.get(position), WordReviseActivity.this);
        }

        @Override
        public int getCount() {
            return mWordList.size();
        }

    }


}
