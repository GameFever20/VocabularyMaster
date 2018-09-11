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
import android.widget.Toast;

import java.util.ArrayList;

import utils.Word;
import utils.ZoomOutPageTransformer;

public class WordTestActivity extends AppCompatActivity {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    ArrayList<Word> mWordList = new ArrayList<>();

    private Word word;

    public static boolean isTestOn = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WordTestActivity.isTestOn = false;
                //initializeViewPager();
                mPager.setCurrentItem(0);
            }
        });

        mPager = (ViewPager) findViewById(R.id.wordTestActivity_viewpager);
        initializeViewPager();

        isTestOn = true;
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

        Word word1 = new Word();
        word1.setWordMeaning("meaning");
        word1.setWordExample("example is this");
        word1.setWordSynonyms("synonyms");
        word1.setWordAntonyms("antonym is this");
        word1.setWordName("word");
        word1.setOptionA("m");
        word1.setOptionB("b");
        word1.setOptionC("meaning");
        word1.setOptionD("d");
        word1.setWordLevel(1);

        Word word2 = new Word();
        word2.setWordMeaning("meaning");
        word2.setWordExample("example is this");
        word2.setWordSynonyms("synonyms");
        word2.setWordAntonyms("antonym is this");
        word2.setWordName("word");
        word2.setOptionA("m");
        word2.setOptionB("b");
        word2.setOptionC("meaning");
        word2.setOptionD("d");
        word2.setWordLevel(1);

        Word word3 = new Word();
        word3.setWordMeaning("meaning");
        word3.setWordExample("example is this");
        word3.setWordSynonyms("synonyms");
        word3.setWordAntonyms("antonym is this");
        word3.setWordName("word");
        word3.setOptionA("m");
        word3.setOptionB("b");
        word3.setOptionC("meaning");
        word3.setOptionD("d");
        word3.setWordLevel(1);


        mWordList.add(word);
        mWordList.add(word1);
        mWordList.add(word2);
        mWordList.add(word3);

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
            return WordTestFragment.newInstance(mWordList.get(position), WordTestActivity.this);
        }

        @Override
        public int getCount() {
            return mWordList.size();
        }

    }


}
