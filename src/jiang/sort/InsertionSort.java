package jiang.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] nums){
        System.out.println(Arrays.toString(nums));
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 1;j--){
                if(nums[j] < nums[j - 1]){
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }



    public static void main(String[] args) {
        insertionSort(new int[]{9,8,7,6,5,4,3,2,1,0});
    }
}
