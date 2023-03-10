package DZ_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DZ_03 {
    public static void main(String[] args) {
        task1(newArrayList(20, 20));
        task2(newArrayList(20, 20));
        task3();
    }
    
    private static ArrayList<Integer> newArrayList (int size, int maxValue) {
        ArrayList<Integer> nums = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            nums.add(random.nextInt(maxValue));
        }
        System.out.println(nums.toString());
        return nums;
    }

    private static void task1(ArrayList<Integer> nums){
        // 1. Пусть дан произвольный список целых чисел, удалить из него четные числа (в языке уже есть что-то готовое для этого)
        nums.removeIf(s -> s%2 == 0 && s!=0);
        System.out.println(nums.toString());
    }

    private static void task2(ArrayList<Integer> nums) {
        // 2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
        int maxValue = Collections.max(nums);
        int minValue = Collections.min(nums);
        double averageValue = average(nums) ;
        System.out.printf("максимальное значение %d минемальное %d среднее арефметическое %.2f\n", maxValue, minValue, averageValue);
    }


    private static double average(ArrayList<Integer> nums) {
        double average = 0;
        double sum = 0;
        for (Integer i : nums) {
            sum += i;
        }
        average = sum/nums.size();
        return average;
    }

    private static void task3() {
        // 3. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа. Пройти по списку, найти и удалить целые числа.
        List<String> elements = List.of("aaaa","bbbb","846","ccc","9456","a1a1a1","-4589");
        ArrayList<String> str = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            int index = new Random().nextInt(elements.size());
            str.add(elements.get(index));
        }
        System.out.println(str.toString());

        for (int i = str.size()-1; i > 0 ; i--) {
            try {
                Integer.parseInt(str.get(i));
                str.remove(i);
            } catch (NumberFormatException e) {
                continue;
            }
        }
        System.out.println(str.toString());
    }
}
