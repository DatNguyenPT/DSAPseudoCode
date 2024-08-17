package com.leetcode.Sorting;
public class MergeSort {
    public static void merge(int []arr, int l, int m, int r){
        int size1 = m-l+1;
        int size2 = r-m;
        int []L = new int[size1];
        int []R = new int[size2];
        // Copy elements to new Array
        for(int i = 0; i < size1; i++){
            L[i] = arr[l+i];            
        }

        for(int i = 0; i < size2; i++){
            R[i] = arr[m+1+i];            
        }

        int i = 0;
        int j = 0;
        int index = l; // Start from left
        while (i < size1 && j < size2){
            if(L[i] < R[j]){
                arr[index] = L[i];
                i++;
            }else{
                arr[index] = R[j];
                j++;
            }
            index++;
        }

        // Copy remaining elements in L and R
        while(i < size1){
            arr[index] = L[i];
            i++;
            index++;
        }

        while(j < size2){
            arr[index] = R[j];
            j++;
            index++;
        }
    }

    public static void mergeSort(int arr[], int l, int r){
        if(l < r){
            int m = l+(r-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    public static void sort(int []arr){
        int l = 0;
        int r = arr.length - 1;
        mergeSort(arr, l, r);
    }


    public static void main(String[] args) {
        int []arr = {5, 4, 3, 2, 1};
        sort(arr);
        for(int x: arr){
            System.out.println(x + "\n");
        }
    }
}
