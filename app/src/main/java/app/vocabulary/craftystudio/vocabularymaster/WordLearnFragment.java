package app.vocabulary.craftystudio.vocabularymaster;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import utils.Word;

/**
 * Created by Aisha on 6/23/2018.
 */

public class WordLearnFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
    static Context wordlearnActivity;

    Word word;

    TextView wordName, wordMeaning, wordExample, wordSynonym, wordAntonym;

    public static WordLearnFragment newInstance(Word word, Context context) {


        wordlearnActivity = context;
        WordLearnFragment fragment = new WordLearnFragment();
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
        View view = inflater.inflate(R.layout.fragment_word_learn, container, false);
        //initializeView

        wordName = (TextView) view.findViewById(R.id.fragment_word_learn_name);
        wordMeaning = (TextView) view.findViewById(R.id.fragment_word_learn_meaning);
        wordAntonym = (TextView) view.findViewById(R.id.fragment_word_learn_synonym);
        wordSynonym = (TextView) view.findViewById(R.id.fragment_word_learn_antonym);
        wordExample = (TextView) view.findViewById(R.id.fragment_word_learn_example);

        wordName.setText(word.getWordName());
        wordExample.setText(word.getWordExample());
        wordSynonym.setText(word.getWordSynonyms());
        wordAntonym.setText(word.getWordAntonyms());
        wordMeaning.setText(word.getWordMeaning());

        return view;

    }

    @Override
    public void onClick(View view) {

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
