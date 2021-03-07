package jiang.sort;

import java.util.Arrays;

public class ShellSort {

    public static void shellSort(int[] nums){
        System.out.println(Arrays.toString(nums));
//        for (int step = nums.length / 2;step > 0;step /= 2){
//            for (int i = step; i < nums.length; i++) {
//                int j = i;
//                int temp = nums[j];
//                if(nums[j]<nums[j-step]){
//                    while(j - step >= 0 && temp < nums[j - step]){
//                        nums[j] = nums[j - step];
//                        j -= step;
//                    }
//                }
//                nums[j] = temp;
//            }
//        }

        for (int step = nums.length / 2;step > 0;step /= 2){
            for (int i = 0; i + step < nums.length; i++) {
                if(nums[i] > nums[i + step]){
                    int temp = nums[i];
                    nums[i] = nums[i + step];
                    nums[i + step] = temp;
                }
            }
        }

        //此时，数组并没有完全排序成功。但逆序对大量减少，
        //最后只需哟简单的插入排序即可
        //直接调用方法
        InsertionSort.insertionSort(nums);

        System.out.println(Arrays.toString(nums));
    }



    public static void main(String[] args) {
        shellSort(new int[]{9,8,7,6,5,4,3,2,1,0});
    }
}
