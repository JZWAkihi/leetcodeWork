package jiang.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] nums){
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            int t = i;
            for (int j = i; j < nums.length; j++) {
                if(nums[t] > nums[j]){
                    t = j;
                }
            }
            int temp = nums[t];
            nums[t] = nums[i];
            nums[i] = temp;
        }



        System.out.println(Arrays.toString(nums));
    }


    public static void main(String[] args) {
        selectionSort(new int[]{9,8,7,6,5,4,3,2,1,0});
    }
}
