package org.example;

public class Main {
    public static void main(String[] args) {

        String str = "Ввести текст, що складається з декількох слів. В тексті після літери Р (або \n" +
                "р), якщо вона не остання в слові, може зустрічатися літера А (або а). У такому \n" +
                "випадку замінити її на літеру О (або о). Вивести початковий та змінений рядок.\n";

        TextChanger textChanger = new TextChanger(str, "якщо", "!!!");

        StringBuilder changedText = textChanger.insertWordAtIndex();
        System.out.println(changedText);

        boolean check = textChanger.validPassword("PAWSgfgWD-a");
        if (check) {
            System.out.println("your password validate");
        } else {
            System.out.println("Your password does not have 8 characters, the presence of capital letters and\n" +
                    "lowercase letters, numbers and special characters");
        }
        System.out.println(check);
    }
}