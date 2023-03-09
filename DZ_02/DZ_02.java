package DZ_02;

import java.io.FileWriter;
import java.util.Scanner;

public class DZ_02 {
    
    public static void main(String[] args) {
        printResult(task1(inputPersonMessage("строку")));
        task2("test.txt");
        // task2(inputPersonMessage(" имя файла"));
    }

    private static String inputPersonMessage(String message) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Введите %s: ", message);
        String str = in.next();
        in.close();
        return str;
    }
    
    private static boolean task1(String st) {
        // Напишите метод, который принимает на вход строку (String) и определяет
        // является ли строка палиндромом (возвращает boolean значение).
        boolean result = false;
        for (int i = 0, j = st.length() - 1; i < st.length() / 2; i++, j--) {
            if (st.charAt(i) != st.charAt(j)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static void printResult(boolean result) {
        if (result) {
            System.out.println("это не полиндром");
        } else {
            System.out.println("это полиндром");
        }

    }


    private static void task2(String path) {
        // 2. Напишите метод, который составит строку, состоящую из 100 повторений слова
        // TEST и метод, который запишет эту строку в простой текстовый файл,
        // обработайте исключения.

        StringBuilder sb = new StringBuilder();
        sb.append("TEST\n".repeat(100));
        try(FileWriter f1 = new FileWriter(path);) {
            f1.append(String.valueOf(sb));
            f1.flush();
        } catch (Exception e) {
            System.out.println("Fail");
        }

    }
}
