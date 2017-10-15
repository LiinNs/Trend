package xyz.liinns.util;

import java.util.Arrays;

public class Sort {
    static int[] arr = {49, 38, 65, 97, 13, 76};

    static void insertSort() {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            if (arr[i] < arr[i - 1]) {
                int tem = arr[i];
                int j = i - 1;
                arr[i] = arr[i - 1];
                while (tem < arr[j]) {
                    arr[j + 1] = arr[j];
                    j--;
                    if (j < 0) {
                        break;
                    }
                }
                arr[j + 1] = tem;
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    static void bubbleSort() {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - (i + 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
//        insertSort();
        bubbleSort();
    }

}
