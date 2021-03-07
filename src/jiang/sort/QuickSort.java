package jiang.sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] nums){

        System.out.println(Arrays.toString(nums));
        sortRight(nums,0,nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    public static void sortLeft(int[] nums,int left,int right){
        int low = left;
        int high = right;

        if(nums.length <= 1){
            return;
        }
        if (low >= high){
            return;
        }

        int index = nums[low];

        while(low < high){
            while(low < high && nums[high] >= index){
                high--;
            }
            if(nums[high] < index){
                nums[low] = nums[high];
                low++;
            }
            while(low < high && nums[low] <= index){
                low++;
            }
            if(nums[low] > index){
                nums[high] = nums[low];
                high--;
            }
        }

        nums[low] = index;

        sortLeft(nums,left,low - 1);
        sortLeft(nums,low + 1,right);
    }

    public static void sortRight(int[] nums,int left,int right){
        int low = left;
        int high = right;

        if(low >= right || nums.length <= 1){
            return;
        }

        int index = nums[right];


        while(low < high){
            while (low < high && nums[low] <= index){
                low++;
            }
            if(nums[low] > index){
                nums[high] = nums[low];
                high--;
            }
            while(low < high && nums[high] >= index){
                high--;
            }
            if(nums[high] < index){
                nums[low] = nums[high];
                low++;
            }
        }
        nums[high] = index;

        sortRight(nums,left,high - 1);
        sortRight(nums,high + 1,right);
    }



    public static void main(String[] args) {
        quickSort(new int[]{9,8,7,6,5,4,3,2,1,0});
    }


}
