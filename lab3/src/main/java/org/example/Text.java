package org.example;

public class Text {

    public void addWordByIndex(String text, String searchWord, String wordInput) {

        int index = text.indexOf(searchWord);

        int lengthWord = searchWord.length();

        StringBuilder stringBuilder = new StringBuilder(text);

        System.out.println("Текст до додавання \n" + text + '\n');

        if (!(index == 0)) {
            stringBuilder.insert(index + lengthWord, wordInput);
            System.out.println("Після додавання \n" + stringBuilder);
        }
    }
}
