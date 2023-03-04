
import java.util.Arrays;
import java.util.Scanner;

public class DZ_01 {
    public static void main(String[] args) {
        task1();
        System.out.println(task2());
        task3();
    }

    private static void task1() {
        // Задать одномерный массив и найти в нем минимальный и максимальный элементы
        Scanner inp = new Scanner(System.in);
        System.out.print("Введите длину масива: ");
        int size = inp.nextInt();
        inp.close();
        int[] intArray = new int[size];
        for (int i = 0; i < size; i++) {
            double a = Math.random();
            intArray[i] = (int) (a * 100);
        }
        int maxValue = intArray[0];
        int minValue = intArray[0];
        for (int i : intArray) {
            if (maxValue < i) {
                maxValue = i;
            }
            if (minValue > i) {
                minValue = i;
            }
        }
        System.out.println(Arrays.toString(intArray));
        System.out.printf("максимальное значение масива равно %d, а минимальный равен %d\n", maxValue, minValue);

    }

    private static boolean task2() {
        // Написать метод, который определяет, является ли год високосным, и возвращает boolean
        // (високосный - true, не високосный - false). 
        // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите год для проверки: ");
        int year = inp.nextInt();
        inp.close();
        boolean result = false;
        if (year % 4 == 0) {
            if ((year % 100 == 0) && (year % 400 != 0)) {
                result = false;
            } else {
                result = true;
            }
        }
        return result;
    }

    private static void task3() {
        // Дан массив nums = [3,2,2,3] и число val = 3.
        // Если в массиве есть числа, равные заданному, нужно перенести эти элементы в
        // конец массива.
        // Таким образом, первые несколько (или все) элементов массива должны быть
        // отличны от заданного, а остальные - равны ему.
        int[] intArray = {3,2,2,3,3,2,3,2,2,3,2};
        Scanner inp = new Scanner(System.in);
        System.out.print("Введите число для сортировки: ");
        int num = inp.nextInt();
        inp.close();
        int i = 0;
        int j = intArray.length-1;
        while (i < j) {
            if (intArray[j] == num){
                j--;
            }
            else if (intArray[i] == num){
                intArray[i] = intArray[j];
                intArray[j] = num;
                i++;
            }
            else {
                i++;
            }
        }
        System.out.println(Arrays.toString(intArray));
    }
}
