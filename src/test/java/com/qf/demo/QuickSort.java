package com.qf.demo;

import java.util.Arrays;

/**
 * Created by DELL on 2019/5/21.
 */
public class QuickSort {
    public static void quickSort(int[] arr,int left,int right){
        int t;
        if(left>right){
            return;
        }
        int i=left; //左边的指针
        int j=right; //右边的指针
        //设置基准数
        int temp = arr[left];
        while (i<j) {
            //从右边开始
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //然后从左边开始
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[left] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, left, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, right);
    }
    public static void main(String[] args){
        int[] arr = {15,7,2,4,7,62,5,33,2,1,8,9,23};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
