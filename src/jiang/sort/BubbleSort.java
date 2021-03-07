package jiang.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] nums){
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        bubbleSort(new int[]{9,8,7,6,5,4,3,2,1,0});

    }


}
