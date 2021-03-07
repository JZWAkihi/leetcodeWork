package jiang.sort;

import java.util.*;

public class BucketSort {

    public static void bucketSort(int[] nums){
        //1.计算出最大值和最小值，求出两者的差值
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]){
                max = nums[i];
            }
            if (nums[i] < min){
                min = nums[i];
            }
        }
        int d = max - min;

        //2.初始化桶
        int bucketNum = nums.length;
        List<LinkedList<Integer>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        //3.遍历数组中的元素，把所有元素都放入对应的桶当中
        for (int i = 0; i < nums.length; i++) {
            //计算当前元素应该放在哪个桶里面
            int num = ((nums[i] - min) / (d / (bucketNum - 1)));
            bucketList.get(num).add(nums[i]);
        }

        //4.对每个桶里面的元素进行排序
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucketList.get(i));
        }

        //5.输出全部元素
        int k = 0;
        for(LinkedList<Integer> doubles : bucketList){
            for (int aDouble : doubles) {
                nums[k] = aDouble;
                k++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }



    public static void main(String[] args) {
        bucketSort(new int[]{9,8,7,6,5,4,3,2,1,0});
    }
}
