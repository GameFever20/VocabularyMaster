package app.vocabulary.craftystudio.vocabularymaster;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import utils.Word;

/**
 * Created by Aisha on 6/25/2018.
 */

public class WordReviseFragment extends Fragment implements View.OnClickListener {

    private WordReviseFragment.OnFragmentInteractionListener mListener;
    static Context wordReviseActivity;

    Word word;

    TextView wordName, optionA, optionB, optionC, optionD, wordMeaning, wordExample, wordSynonym, wordAntonym;

    CardView optionACardView, optionBCardView, optionCCardView, optionDCardView, explainationCardview;

    NestedScrollView nestedScrollView;

    public static WordReviseFragment newInstance(Word word, Context context) {


        wordReviseActivity = context;
        WordReviseFragment fragment = new WordReviseFragment();
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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word_revise, container, false);
        //initializeView

        wordName = (TextView) view.findViewById(R.id.fragment_word_revise_wordname_textview);
        wordAntonym = (TextView) view.findViewById(R.id.fragment_word_revise_wordAntonym_textview);
        wordSynonym = (TextView) view.findViewById(R.id.fragment_word_revise_wordSynonym_textview);
        wordExample = (TextView) view.findViewById(R.id.fragment_word_revise_wordExample_textview);
        wordMeaning = (TextView) view.findViewById(R.id.fragment_word_revise_wordMeaning_textview);

        optionA = (TextView) view.findViewById(R.id.fragment_word_revise_optionA_textview);
        optionB = (TextView) view.findViewById(R.id.fragment_word_revise_optionB_textview);
        optionC = (TextView) view.findViewById(R.id.fragment_word_revise_optionC_textview);
        optionD = (TextView) view.findViewById(R.id.fragment_word_revise_optionD_textview);

        //initializeView

        optionACardView = (CardView) view.findViewById(R.id.fragment_word_revise_optionA_cardview);
        optionBCardView = (CardView) view.findViewById(R.id.fragment_word_revise_optionB_cardview);
        optionCCardView = (CardView) view.findViewById(R.id.fragment_word_revise_optionC_cardview);
        optionDCardView = (CardView) view.findViewById(R.id.fragment_word_revise_optionD_cardview);
        explainationCardview = (CardView) view.findViewById(R.id.fragment_word_revise_explaination_cardview);

        nestedScrollView = (NestedScrollView) view.findViewById(R.id.fragment_word_revise_nested_scrollview);

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


        return view;

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.fragment_word_revise_optionA_cardview:
                if (word.getOptionA().equalsIgnoreCase(word.getWordMeaning())) {
                    optionACardView.setBackgroundResource(R.drawable.mygreenbutton);
                } else {
                    optionACardView.setBackgroundResource(R.drawable.myredbutton);
                    showRightAnswer();
                }
                break;
            case R.id.fragment_word_revise_optionB_cardview:
                if (word.getOptionB().equalsIgnoreCase(word.getWordMeaning())) {
                    optionBCardView.setBackgroundResource(R.drawable.mygreenbutton);

                } else {
                    optionBCardView.setBackgroundResource(R.drawable.myredbutton);
                    showRightAnswer();
                }
                break;
            case R.id.fragment_word_revise_optionC_cardview:
                if (word.getOptionC().equalsIgnoreCase(word.getWordMeaning())) {
                    optionCCardView.setBackgroundResource(R.drawable.mygreenbutton);

                } else {
                    optionCCardView.setBackgroundResource(R.drawable.myredbutton);
                    showRightAnswer();
                }
                break;
            case R.id.fragment_word_revise_optionD_cardview:
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WordReviseFragment.OnFragmentInteractionListener) {
            mListener = (WordReviseFragment.OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
