package com.leetcode.Sorting;

public class InsertionSort {
    public static void sort(int arr[]){
        int j, key;
        int n = arr.length;
        for(int i=1; i<n; i++){
            key = arr[i];
            j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int []arr = {5, 4, 3, 2, 1};
        sort(arr);
        for(int x: arr){
            System.out.println(x + "\n");
        }
    }
}
