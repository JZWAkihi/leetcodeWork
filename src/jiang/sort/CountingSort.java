package jiang.sort;

import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] nums){
        int max = nums[0];
        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= max){
                max = nums[i];
            }
            if(nums[i] <= min){
                min = nums[i];
            }
        }

        int m = max - min;

        int[] count = new int[m + 1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - min]++;
        }

        System.out.println(Arrays.toString(count));

        int j = 0;

        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0){
                nums[j] = i + min;
                j++;
                count[i]--;
            }
        }
        System.out.println(Arrays.toString(nums));

    }


    public static void main(String[] args) {
        countingSort(new int[]{9,8,7,6,5,4,3,2,1,0});
    }


}
