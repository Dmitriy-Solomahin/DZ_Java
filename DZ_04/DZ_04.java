package DZ_04;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class DZ_04 {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        // 1. Реализовать консольное приложение, которое:
        // Принимает от пользователя и “запоминает” строки.
        // Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
        // Если введено revert, удаляет предыдущую введенную строку из памяти.

        Scanner in = new Scanner(System.in);
        LinkedList<String> wordsList = new LinkedList<>();
        
        while (true) {
            System.out.println();
            System.out.print("Введите строку: ");
            String inputString = in.nextLine();
        
            

            if (inputString.isBlank()){
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            else if (inputString.equalsIgnoreCase("exit")) {
                break;
            }
            else if (inputString.equalsIgnoreCase("print")) {
                System.out.println(Arrays.toString(wordsList.toArray()));
            }
            /* вариант 2
            else if (inputString.equalsIgnoreCase("print")) {
                for (int i = 0; i < wordsList.size(); i++) {
                    System.out.println(wordsList.get(i));
                }
            }*/
            else if (inputString.equalsIgnoreCase("revert")) {
                String str = wordsList.removeFirst();
                System.out.printf("строка %s была удалена\n", str);
            }
            else {
                wordsList.addFirst(inputString);
            }
        }
        in.close();
    }

    private static void task2() {
        // 2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
        
        LinkedList<String> wordsList = new LinkedList<>();
        Collections.addAll(wordsList, "apple", "orange", "banana", "tomato", "strawberry", "melon");
        System.out.println(Arrays.toString(wordsList.toArray()));

        wordsList = revers(wordsList);

        System.out.println(Arrays.toString(wordsList.toArray()));
    }

    private static LinkedList<String> revers(LinkedList<String> wordsList) {
        for (int i = 0; i < wordsList.size(); i++) {
            String bufer = wordsList.removeLast();
            wordsList.add(i, bufer);
        }
        return wordsList;
    }
}
