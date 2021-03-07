package jiang.sort;

import java.util.Arrays;

public class RadixSort {

    public static void radixSort(int[] nums){
        //待排序列最大值
        int max = nums[0];
        int exp;//指数

        //计算最大值
        for (int anArr : nums) {
            if (anArr > max) {
                max = anArr;
            }
        }

        //从个位开始，对数组进行排序
        for (exp = 1; max / exp > 0; exp *= 10) {
            //存储待排元素的临时数组
            int[] temp = new int[nums.length];
            //分桶个数
            int[] buckets = new int[10];

            //将数据出现的次数存储在buckets中
            for (int value : nums) {
                //(value / exp) % 10 :value的最底位(个位)
                buckets[(value / exp) % 10]++;
            }

            //更改buckets[i]，
            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            //将数据存储到临时数组temp中
            for (int i = nums.length - 1; i >= 0; i--) {
                temp[buckets[(nums[i] / exp) % 10] - 1] = nums[i];
                buckets[(nums[i] / exp) % 10]--;
            }

            //将有序元素temp赋给arr
            System.arraycopy(temp, 0, nums, 0, nums.length);

            System.out.println(Arrays.toString(nums));
        }
    }




    public static void main(String[] args) {
        radixSort(new int[]{9,8,7,6,5,4,3,2,1,0});
    }


}
