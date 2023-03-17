package DZ_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DZ_05 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        task1(inp);
        task2();
        
        inp.close();
    }

    private static void task1(Scanner inp) {
        // 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

        Map<String, ArrayList<String>> telephonBook = new HashMap<>();
        telephonBook.put("Иванов Иван Иванович",new ArrayList<>(Arrays.asList("+7(987)654-32-10", "8(812)746-98-52")));
        telephonBook.put("Иванов Сергей Аркадьевич",new ArrayList<>(Arrays.asList("+7(723)128-94-15")));
        telephonBook.put("Сидорова Анна Николаевна",new ArrayList<>(Arrays.asList("+7(985)457-79-02", "8(812)131-45-12", "+7(912)945-62-12")));
        telephonBook.put("Evgen Popov",new ArrayList<>(Arrays.asList("+7(993)148-64-15", "8(812)256-45-72")));

        telephonBook = startWork(telephonBook, inp);// типо запись в файл)
    }

    private static Map<String, ArrayList<String>> startWork(Map<String, ArrayList<String>> telephonBook, Scanner inp) {
        boolean flag = true;
        while (flag == true) {
            int numOpiration = printMenu(inp);
            switch(numOpiration){
                case 1:
                    printBook(telephonBook);
                    break;
                case 2:
                    findСontact(telephonBook,inp);// неработает если искать рускими символами(
                    break;
                case 3:
                    telephonBook = addContact(telephonBook,inp);
                    break;
                case 4:
                    telephonBook = addTelephon(telephonBook,inp);
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
        return telephonBook;
    }

    private static int printMenu(Scanner inp) {
        System.out.print("\tМеню телефонной книги: \n"
        + "1. Распечатать всю книгу\n"
        + "2. Найти контакт\n"
        + "3. Добавить контакт\n"
        + "4. Добавить номер\n"
        + "5. Выйти\n"
        + "\n"
        + "Введите номер операции: ");
        int numOpiration = 0;
        try {
            numOpiration = inp.nextInt();
        } catch (Exception e) {
            System.out.println("Вводите число!!!");
        }
        System.out.println();
        return numOpiration;
    }

    private static void printBook(Map<String, ArrayList<String>> telephonBook) {
        for (String name : telephonBook.keySet()) {
            System.out.print(name + " :  ");
            for (String telephon : telephonBook.get(name)) {
                System.out.printf(telephon + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void findСontact(Map<String, ArrayList<String>> telephonBook, Scanner inp) {
        System.out.print("Введите имя: ");
        String name = inp.nextLine();
        boolean flag = false;
        for (String kay : telephonBook.keySet()) {
            if (kay.toLowerCase().contains(name.toLowerCase())){
                System.out.print(kay + " :  ");
                for (String telephon : telephonBook.get(kay)) {
                    System.out.printf(telephon + " ");
                }
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Такого имени нет в книге");
        }
        System.out.println();
    }
    
    private static Map<String, ArrayList<String>> addContact(Map<String, ArrayList<String>> telephonBook, Scanner inp) {
        System.out.print("Введите ФИО: ");
        String name = inp.nextLine();

        System.out.print("Введите количество номеров: ");
        int size = inp.nextInt();
        
        ArrayList<String> telephons = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.print("Введите телефон: ");
            String telephon = inp.nextLine();
            telephons.add(telephon);
        }
        boolean flag = true;
        for (String kay : telephonBook.keySet()) {
            if (kay.toLowerCase().contains(name.toLowerCase())){
                flag = false;
                System.out.println("Такой контакт существует, перезаписать? (Y/N)");
                String yesOrNo = inp.next().toUpperCase();
                if (yesOrNo == "Y"){
                    telephonBook.put(name,telephons);
                }
                break;
            }
        }
        if (flag == true){
            telephonBook.put(name, telephons);
        }
        return telephonBook;
    }
    
    private static Map<String, ArrayList<String>> addTelephon(Map<String, ArrayList<String>> telephonBook, Scanner inp) {
        System.out.print("Введите имя: ");
        String name = inp.nextLine();
        boolean flag = false;
        for (String kay : telephonBook.keySet()) {
            if (kay.toLowerCase().contains(name.toLowerCase())){
                System.out.print(kay + " :  ");
                for (String telephon : telephonBook.get(kay)) {
                    System.out.printf(telephon + " ");
                }
                System.out.print("Введите телефон: ");
                String telephon = inp.nextLine();
                telephonBook.get(kay).add(telephon);
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Такого имени нет в книге");
        }
        System.out.println();

        return telephonBook;
    }

    private static void task2() {
        // 2. Пусть дан список сотрудников:
        // Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
        ArrayList<String> workersList = new ArrayList<>();
        workersList.add("Иван Иванов");
        workersList.add("Кристина Белова");
        workersList.add("Светлана Петрова");
        workersList.add("Анна Мусина");
        workersList.add("Анна Крутова");
        workersList.add("Иван Юрин");
        workersList.add("Петр Лыков");
        workersList.add("Павел Чернов");
        workersList.add("Петр Чернышов");
        workersList.add("Мария Федорова");
        workersList.add("Марина Светлова");
        workersList.add("Мария Савина");
        workersList.add("Мария Рыкова");
        workersList.add("Марина Лугова");
        workersList.add("Анна Владимирова");
        workersList.add("Иван Мечников");
        workersList.add("Петр Петин");
        workersList.add("Иван Ежов");

        Map<String, ArrayList<String>> workersMap = new HashMap<>();
        
        for (String string : workersList) {
            String[] worker = string.split(" ");
            if (workersMap.containsKey(worker[0])){
                workersMap.get(worker[0]).add(worker[1]);
            }
            else{
                workersMap.put(worker[0],new ArrayList<>(Arrays.asList(worker[1])));
            }            
        }
        printBook(workersMap);
        printNumberOfRepetitions(workersMap);
    }

    private static void printNumberOfRepetitions(Map<String, ArrayList<String>> workersMap) {
        for (String key : workersMap.keySet()) {
            if (workersMap.get(key).size()>1){
                System.out.println(key + " " + workersMap.get(key).size() );
            }
        }
    }
}
