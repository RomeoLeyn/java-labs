package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextChanger {
    private String text;
    private String findWord;
    private String insertWord;
    private int index;

    public TextChanger(String text, String findWord, String insertWord) {
        this.text = text;
        this.findWord = findWord;
        this.insertWord = insertWord;
    }

    public String getText() {
        return text;
    }

    public String getFindWord() {
        return findWord;
    }

    public String getInsertWord() {
        return insertWord;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFindWord(String findWord) {
        this.findWord = findWord;
    }

    public void setInsertWord(String insertWord) {
        this.insertWord = insertWord;
    }

    public StringBuilder insertWordAtIndex() {

        StringBuilder stringBuilder = new StringBuilder(this.text);
        this.index = this.text.indexOf(this.findWord);

        if (!(this.index == 0)) {
            stringBuilder.insert(this.index + this.findWord.length() + 1, this.insertWord);
        }

        return stringBuilder;
    }

    public boolean validPassword(String password) {
        Pattern checkUpperCase = Pattern.compile("[A-Z]+");
        Pattern lowerCasePattern = Pattern.compile("[a-z]+");
        Pattern specialSymbolPattern = Pattern.compile("[\\W]");
        Pattern numbers = Pattern.compile("[\\d]+");

        Matcher lowerCaseMatcher = lowerCasePattern.matcher(password);
        Matcher upperCaseMatcher = checkUpperCase.matcher(password);
        Matcher symbolMatcher = specialSymbolPattern.matcher(password);
        Matcher numberMatcher = numbers.matcher(password);

        boolean isLengthValid = password.length() > 8;
        boolean hasLowerCase = lowerCaseMatcher.find();
        boolean hasUpperCase = upperCaseMatcher.find();
        boolean hasSpecialSymbol = symbolMatcher.find();
        boolean hasNumbers = numberMatcher.find();

        return isLengthValid && hasLowerCase && hasUpperCase && hasSpecialSymbol && hasNumbers;
    }
}