package Sorting.BubbleSort;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSortFunction(int[] arr) {

        for (int i = 0; i < arr.length-1; i++){
            for (int j = 0; j < arr.length-1 - i; j++) {

                if(arr[j] > arr[j+1]){

                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

                System.out.println("Step " + (i + 1) + ": " + Arrays.toString(arr));

            }
        }

        return arr;
    }

}

