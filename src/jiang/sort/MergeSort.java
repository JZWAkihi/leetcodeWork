package jiang.sort;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] nums){
        System.out.println(Arrays.toString(nums));

        int len = nums.length;
        int[] temp = new int[len];

        mergeSort(nums,0,len-1,temp);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums,int left,int right,int[] temp){
        if(left >= right){
            return;
        }

        int mid = (left + right)/2;
        //左边归并排序，使得左子序列有序
        mergeSort(nums,left,mid,temp);
        //右边归并排序，使得右子序列有序
        mergeSort(nums,mid + 1,right,temp);
        //将两个有序子数组合并操作
        merge(nums,left,mid,right,temp);
    }

    public static void merge(int[] nums,int left,int mid,int right,int[] temp){
        int i = left;   //左序列指针
        int j = mid + 1;  //右序列指针
        int t = 0;        //临时数组指针

        while(i<=mid && j<=right){
            if(nums[i] <= nums[j]){
                temp[t++] = nums[i++];
            }else{
                temp[t++] = nums[j++];
            }
        }

        while(i<=mid){
            temp[t++] = nums[i++];
        }
        while(j<=right){
            temp[t++] = nums[j++];
        }

        t=0;
        while(left <= right){
            nums[left++] = temp[t++];
        }

    }

    public static void main(String[] args) {
        mergeSort(new int[]{9,8,7,6,5,4,3,2,1,0});
    }

}
