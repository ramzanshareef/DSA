package Sorting;

public class Problems {
    public static void moveZerosToEnd(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] == 0 && arr[j + 1] != 0) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }

    public static void sortFruitsLexicographically(String fruits[]) {
        for (int i = 0; i < fruits.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < fruits.length; j++) {
                if (fruits[j].compareTo(fruits[min_index]) < 0) {
                    min_index = j;
                }
            }
            String temp = fruits[i];
            fruits[i] = fruits[min_index];
            fruits[min_index] = temp;
        }
    }
}