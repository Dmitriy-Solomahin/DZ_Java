package DZ_06;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создать множество ноутбуков (ArrayList).
        // Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
        // Например, спросить у пользователя минимальный размер оперативной памяти или конкретный цвет. 
        // Выводить только те ноутбуки, что соответствуют условию
        List<Laptop> listLaptops = new ArrayList<>();
        listLaptops.add(new Laptop("HP", "hp12.43", "black", "NVIDIA GeForce 3060", 12, 16, 1024, 74990));
        listLaptops.add(new Laptop("iRU", "Home 520B5GP", "white", "AMD Radeon Graphics", 4, 8, 1024, 52990));
        listLaptops.add(new Laptop("iRU", "Home 520B5GP", "black", "AMD Radeon Graphics", 4, 8, 1024, 52990));
        listLaptops.add(new Laptop("MSI", "13SI - 16X", "White", "NVIDIA GeForce GTX 1660", 6, 16, 512, 72000));
        listLaptops.add(new Laptop("MSI", "11TH - 16X", "gray", "NVIDIA GeForce 3050", 8, 16, 1024, 83000));
    
        filterListLaptopsColor(listLaptops, "black");
        System.out.println();
        filterListLaptopsRAM(listLaptops, 16);
    }

    private static void filterListLaptopsRAM(List<Laptop> listLaptops, int filterValue) {
        for (Laptop laptop : listLaptops) {
            if (laptop.ram == filterValue){
                System.out.println(laptop.toString());
            }
        }
    }

    private static void filterListLaptopsColor(List<Laptop> listLaptops, String filterValue) {
        for (Laptop laptop : listLaptops) {
            if (laptop.color == filterValue){
                System.out.println(laptop.toString());
            }
        }
    }
}