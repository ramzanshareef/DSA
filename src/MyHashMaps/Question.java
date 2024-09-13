package MyHashMaps;

import java.util.*;

public class Question {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3, 3, 3, 4, 4, 5, 4, 4, 5, 5 };
        System.out.println(getMaxFreqElement(arr));
    }

    public static int getMaxFreqElement(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 1) + 1);
        }
        int res = -1;
        int curr = -1;
        for (var e : map.entrySet()) {
            if (e.getValue() > curr) {
                curr = e.getValue();
                res = e.getKey();
            }
        }
        return res;
    }
}