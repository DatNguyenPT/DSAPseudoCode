package com.leetcode.Sorting;

public class SelectionSort {
    public static void sort(int arr[]){
        int current;
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            current = i;
            int temp = arr[current];
            int index = current;
            for(int j=i+1; j<n; j++){
                if (arr[j] < temp) {
                    temp = arr[j];
                    index = j;
                }
            }
            swap(current, index, arr);
        }
    }
    public static void swap(int i, int j, int[]arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int []arr = {5, 4, 3, 2, 1};
        sort(arr);
        for(int x: arr){
            System.out.println(x + "\n");
        }
    }
}
