package app.vocabulary.craftystudio.vocabularymaster;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import utils.Word;

/**
 * Created by Aisha on 7/1/2018.
 */

public class WordTestFragment extends Fragment implements View.OnClickListener {

    private WordTestFragment.OnFragmentInteractionListener mListener;
    static Context wordTestActivity;

    Word word;

    TextView wordName, optionA, optionB, optionC, optionD, wordMeaning, wordExample, wordSynonym, wordAntonym;

    CardView optionACardView, optionBCardView, optionCCardView, optionDCardView, explainationCardview;

    NestedScrollView nestedScrollView;


    public static WordTestFragment newInstance(Word word, Context context) {


        wordTestActivity = context;
        WordTestFragment fragment = new WordTestFragment();
        Bundle args = new Bundle();
        args.putSerializable("Word", word);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.word = (Word) getArguments().getSerializable("Word");

           /* Answers.getInstance().logContentView(new ContentViewEvent()
                    .putContentName(story.getStoryTitle())
                    .putContentId(story.getStoryID())
            );
            */

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word_test, container, false);
        //initializeView

        wordName = (TextView) view.findViewById(R.id.fragment_word_test_wordname_textview);
        wordAntonym = (TextView) view.findViewById(R.id.fragment_word_test_wordAntonym_textview);
        wordSynonym = (TextView) view.findViewById(R.id.fragment_word_test_wordSynonym_textview);
        wordExample = (TextView) view.findViewById(R.id.fragment_word_test_wordExample_textview);
        wordMeaning = (TextView) view.findViewById(R.id.fragment_word_test_wordMeaning_textview);

        optionA = (TextView) view.findViewById(R.id.fragment_word_test_optionA_textview);
        optionB = (TextView) view.findViewById(R.id.fragment_word_test_optionB_textview);
        optionC = (TextView) view.findViewById(R.id.fragment_word_test_optionC_textview);
        optionD = (TextView) view.findViewById(R.id.fragment_word_test_optionD_textview);

        //initializeView

        optionACardView = (CardView) view.findViewById(R.id.fragment_word_test_optionA_cardview);
        optionBCardView = (CardView) view.findViewById(R.id.fragment_word_test_optionB_cardview);
        optionCCardView = (CardView) view.findViewById(R.id.fragment_word_test_optionC_cardview);
        optionDCardView = (CardView) view.findViewById(R.id.fragment_word_test_optionD_cardview);
        explainationCardview = (CardView) view.findViewById(R.id.fragment_word_test_explaination_cardview);

        nestedScrollView = (NestedScrollView) view.findViewById(R.id.fragment_word_test_nested_scrollview);

        //Implementing click listener
        optionACardView.setOnClickListener(this);
        optionBCardView.setOnClickListener(this);
        optionCCardView.setOnClickListener(this);
        optionDCardView.setOnClickListener(this);

        //Set Values
        wordName.setText(word.getWordName());

        optionA.setText(word.getOptionA());
        optionB.setText(word.getOptionB());
        optionC.setText(word.getOptionC());
        optionD.setText(word.getOptionD());

        wordExample.setText(word.getWordExample());
        wordSynonym.setText(word.getWordSynonyms());
        wordAntonym.setText(word.getWordAntonyms());
        wordMeaning.setText(word.getWordMeaning());


        getUserAnswers();
        return view;
    }


    @Override
    public void onClick(View view) {

        if (WordTestActivity.isTestOn) {

            switch (view.getId()) {

                case R.id.fragment_word_test_optionA_cardview:
                    word.setUserAnswer(word.getOptionA());
                    Toast.makeText(wordTestActivity, "User selected" + word.getUserAnswer(), Toast.LENGTH_SHORT).show();
                    setButtonColorBlue(1);
                    break;
                case R.id.fragment_word_test_optionB_cardview:
                    word.setUserAnswer(word.getOptionB());
                    Toast.makeText(wordTestActivity, "User selected" + word.getUserAnswer(), Toast.LENGTH_SHORT).show();
                    setButtonColorBlue(2);
                    break;
                case R.id.fragment_word_test_optionC_cardview:
                    word.setUserAnswer(word.getOptionC());
                    Toast.makeText(wordTestActivity, "User selected" + word.getUserAnswer(), Toast.LENGTH_SHORT).show();
                    setButtonColorBlue(3);
                    break;
                case R.id.fragment_word_test_optionD_cardview:
                    word.setUserAnswer(word.getOptionD());
                    Toast.makeText(wordTestActivity, "User selected" + word.getUserAnswer(), Toast.LENGTH_SHORT).show();
                    setButtonColorBlue(4);
                    break;
            }
        } else {
            switch (view.getId()) {

                case R.id.fragment_word_test_optionA_cardview:
                    if (word.getOptionA().equalsIgnoreCase(word.getWordMeaning())) {
                        optionACardView.setBackgroundResource(R.drawable.mygreenbutton);
                    } else {
                        optionACardView.setBackgroundResource(R.drawable.myredbutton);
                        showRightAnswer();
                    }
                    break;
                case R.id.fragment_word_test_optionB_cardview:
                    if (word.getOptionB().equalsIgnoreCase(word.getWordMeaning())) {
                        optionBCardView.setBackgroundResource(R.drawable.mygreenbutton);

                    } else {
                        optionBCardView.setBackgroundResource(R.drawable.myredbutton);
                        showRightAnswer();
                    }
                    break;
                case R.id.fragment_word_test_optionC_cardview:
                    if (word.getOptionC().equalsIgnoreCase(word.getWordMeaning())) {
                        optionCCardView.setBackgroundResource(R.drawable.mygreenbutton);

                    } else {
                        optionCCardView.setBackgroundResource(R.drawable.myredbutton);
                        showRightAnswer();
                    }
                    break;
                case R.id.fragment_word_test_optionD_cardview:
                    if (word.getOptionD().equalsIgnoreCase(word.getWordMeaning())) {
                        optionDCardView.setBackgroundResource(R.drawable.mygreenbutton);

                    } else {
                        optionDCardView.setBackgroundResource(R.drawable.myredbutton);
                        showRightAnswer();
                    }
                    break;

            }
            displayWordExplaination();
        }

    }


    private void displayWordExplaination() {

        explainationCardview.setVisibility(View.VISIBLE);
        nestedScrollView.fullScroll(View.FOCUS_DOWN);
    }


    private void showRightAnswer() {

        String correctAnswer = word.getWordMeaning();
        if (word.getOptionA().trim().equalsIgnoreCase(correctAnswer)) {
            optionACardView.setBackgroundResource(R.drawable.mygreenbutton);


        } else if (word.getOptionB().trim().equalsIgnoreCase(correctAnswer)) {
            optionBCardView.setBackgroundResource(R.drawable.mygreenbutton);


        } else if (word.getOptionC().trim().equalsIgnoreCase(correctAnswer)) {
            optionCCardView.setBackgroundResource(R.drawable.mygreenbutton);


        } else if (word.getOptionD().trim().equalsIgnoreCase(correctAnswer)) {
            optionDCardView.setBackgroundResource(R.drawable.mygreenbutton);

        }
    }


    private void getUserAnswers() {

        if (!WordTestActivity.isTestOn) {

            if (word.getUserAnswer() != null) {


                //setExplaination visible
                explainationCardview.setVisibility(View.VISIBLE);
                if (word.getUserAnswer().equalsIgnoreCase(word.getWordMeaning())) {

                    if (word.getOptionA().trim().equalsIgnoreCase(word.getUserAnswer().trim())) {
                        optionACardView.setBackgroundResource(R.drawable.mygreenbutton);


                    } else if (word.getOptionB().trim().equalsIgnoreCase(word.getUserAnswer().trim())) {
                        optionBCardView.setBackgroundResource(R.drawable.mygreenbutton);


                    } else if (word.getOptionC().trim().equalsIgnoreCase(word.getUserAnswer().trim())) {
                        optionCCardView.setBackgroundResource(R.drawable.mygreenbutton);

                    } else if (word.getOptionD().trim().equalsIgnoreCase(word.getUserAnswer().trim())) {
                        optionDCardView.setBackgroundResource(R.drawable.mygreenbutton);

                    }

                } else {
                    if (word.getOptionA().trim().equalsIgnoreCase(word.getUserAnswer().trim())) {
                        optionACardView.setBackgroundResource(R.drawable.myredbutton);
                        showRightAnswer();


                    } else if (word.getOptionB().trim().equalsIgnoreCase(word.getUserAnswer().trim())) {
                        optionBCardView.setBackgroundResource(R.drawable.myredbutton);
                        showRightAnswer();

                    } else if (word.getOptionC().trim().equalsIgnoreCase(word.getUserAnswer().trim())) {
                        optionCCardView.setBackgroundResource(R.drawable.myredbutton);
                        showRightAnswer();

                    } else if (word.getOptionD().trim().equalsIgnoreCase(word.getUserAnswer().trim())) {
                        optionDCardView.setBackgroundResource(R.drawable.myredbutton);
                        showRightAnswer();

                    }


                }

            }
        } else {
        }

    }

    private void setButtonColorBlue(int selectedCardview) {

        switch (selectedCardview) {
            case 1:
                optionACardView.setBackgroundResource(R.drawable.mybluebutton);
                optionBCardView.setBackgroundResource(R.color.colorWhiteBg);
                optionCCardView.setBackgroundResource(R.color.colorWhiteBg);
                optionDCardView.setBackgroundResource(R.color.colorWhiteBg);
                break;
            case 2:
                optionACardView.setBackgroundResource(R.color.colorWhiteBg);
                optionBCardView.setBackgroundResource(R.drawable.mybluebutton);
                optionCCardView.setBackgroundResource(R.color.colorWhiteBg);
                optionDCardView.setBackgroundResource(R.color.colorWhiteBg);
                break;
            case 3:
                optionACardView.setBackgroundResource(R.color.colorWhiteBg);
                optionBCardView.setBackgroundResource(R.color.colorWhiteBg);
                optionCCardView.setBackgroundResource(R.drawable.mybluebutton);
                optionDCardView.setBackgroundResource(R.color.colorWhiteBg);
                break;
            case 4:
                optionACardView.setBackgroundResource(R.color.colorWhiteBg);
                optionBCardView.setBackgroundResource(R.color.colorWhiteBg);
                optionCCardView.setBackgroundResource(R.color.colorWhiteBg);
                optionDCardView.setBackgroundResource(R.drawable.mybluebutton);
                break;
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WordTestFragment.OnFragmentInteractionListener) {
            mListener = (WordTestFragment.OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }
}
