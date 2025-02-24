package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextChanger {
    public static StringBuilder insertWordAtIndex(String text, String findWord, String insertWord) {

        int index;

        StringBuilder stringBuilder = new StringBuilder(text);
        index = text.indexOf(findWord);

        if (!(index == 0)) {
            stringBuilder.insert(index + findWord.length() + 1, insertWord);
        }

        return stringBuilder;
    }

    public static boolean validPassword(String password) {
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