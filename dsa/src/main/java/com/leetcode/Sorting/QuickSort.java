package com.leetcode.Sorting;

public class QuickSort {
    private static void swap(int i, int j, int[]arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static int lomuntoPartition(int[] arr, int low, int high){
        int pivot = arr[high];
        int index = low - 1;
        for(int i = low; i <= high - 1; i++){
            if(arr[i] < pivot){
                index++;
                swap(index, i, arr);
            }
        }
        swap(index + 1, high, arr);
        return index + 1;
    }

    private static int hoarePartition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;
        while(true){
            do { 
                i++;
            } while (arr[i] < pivot);
            do { 
                j--;
            } while (arr[j] > pivot);
            if(i >= j)
                return j;
            swap(i, j, arr);
        }
    }

    private static void lomuntoQuickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = lomuntoPartition(arr, low, high);
            lomuntoQuickSort(arr, low, pivot - 1);
            lomuntoQuickSort(arr, pivot + 1, high);
        }
    }

    private static void hoareQuickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = hoarePartition(arr, low, high);
            hoareQuickSort(arr, low, pivot - 1);
            hoareQuickSort(arr, pivot + 1, high);
        }
    }


    public static void main(String[] args) {
        int []arr1 = {5, 4, 3, 2, 1};
        int []arr2 = {10, 9, 8, 7, 6};
        int low = 0;
        int high1 = arr1.length - 1;
        int high2 = arr2.length - 1;
        lomuntoQuickSort(arr1, low, high1);
        hoareQuickSort(arr2, low, high2);
        for(int x: arr1){
            System.out.println(x + " ");
        }
        
        System.out.println("----------------------------------------------");

        for(int x: arr2){
            System.out.println(x + " ");
        }
    }
}
