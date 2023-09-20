package org.example;

public class Main {
    public static void main(String[] args) {

        Text insertWord = new Text();

        String text = "Ввести текст, що складається з декількох слів. В тексті після літери Р (або \n" +
                "р), якщо вона не остання в слові, може зустрічатися літера А (або а). У такому \n" +
                "випадку замінити її на літеру О (або о). Вивести початковий та змінений рядок.\n";

        insertWord.addWordByIndex(text, "що", "!!!!!!!");
    }
}