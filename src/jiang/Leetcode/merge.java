package jiang.Leetcode;

import java.util.Arrays;

/***
 *
 *88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 */

public class merge {

    public static void mergeTest(int[] nums1,int m,int[] nums2,int n){
        int[] ints = new int[n + m];

        int Pnum1 = 0;
        int Pnum2 = 0;

        int Pints = 0;

        while(Pnum1 < m && Pnum2 < n){
            if(nums1[Pnum1] >= nums2[Pnum2]){
                ints[Pints] = nums2[Pnum2];
                Pints++;
                Pnum2++;
                continue;
            }

            if(nums1[Pnum1] < nums2[Pnum1]){
                ints[Pints] = nums1[Pnum1];
                Pints++;
                Pnum1++;
                continue;
            }
        }

        if(Pnum1 == m){
            for (; Pnum2 < n; Pnum2++,Pints++) {
                ints[Pints] = nums2[Pnum2];
            }
        }

        if(Pnum2 == n){
            for (; Pnum1 < m; Pnum1++,Pints++) {
                ints[Pints] = nums1[Pnum1];
            }
        }

        for (int i = 0; i < m + n; i++) {
            if(i == 0){
                System.out.print("[");
            }
            if(i == m + n - 1){
                System.out.print(ints[i] + "]");
            }else {
                System.out.print(ints[i] + ",");
            }
        }

        nums1 = ints;
    }

    public static void main(String[] args) {

        int[] int1 = new int[]{1};
        int[] int2 = new int[]{};


        mergeTest(int1,1,int2,0);

    }


}
