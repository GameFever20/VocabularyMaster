package utils;

import java.io.Serializable;

/**
 * Created by Aisha on 6/23/2018.
 */

public class Word implements Serializable {

    private String wordName;
    private String wordMeaning;
    private String wordSynonyms;
    private String wordAntonyms;

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    private String userAnswer;

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;


    public int getWordLevel() {
        return wordLevel;
    }

    public void setWordLevel(int wordLevel) {
        this.wordLevel = wordLevel;
    }

    private int wordLevel;

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public String getWordMeaning() {
        return wordMeaning;
    }

    public void setWordMeaning(String wordMeaning) {
        this.wordMeaning = wordMeaning;
    }

    public String getWordSynonyms() {
        return wordSynonyms;
    }

    public void setWordSynonyms(String wordSynonyms) {
        this.wordSynonyms = wordSynonyms;
    }

    public String getWordAntonyms() {
        return wordAntonyms;
    }

    public void setWordAntonyms(String wordAntonyms) {
        this.wordAntonyms = wordAntonyms;
    }

    public String getWordExample() {
        return wordExample;
    }

    public void setWordExample(String wordExample) {
        this.wordExample = wordExample;
    }

    private String wordExample;

}
