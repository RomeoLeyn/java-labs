package org.example;

public class Main {
    public static void main(String[] args) {

        String text = "Ввести текст, що складається з декількох слів. В тексті після літери Р (або \n" +
                "р), якщо вона не остання в слові, може зустрічатися літера А (або а). У такому \n" +
                "випадку замінити її на літеру О (або о). Вивести початковий та змінений рядок.\n";


        StringBuilder changedText = TextChanger.insertWordAtIndex(text, "що", "!!!!!!!!!!");
        System.out.println("Текст після редагування:  \n" + changedText);

        String password = "PAWSgfgWD2-a";
        boolean check = TextChanger.validPassword(password);

        if (check) {
            System.out.println("Your password validate \n");
        } else {
            System.out.println("Your password does not have 8 characters, the presence of capital letters and\n" +
                    "lowercase letters, numbers and special characters");
        }
    }
}