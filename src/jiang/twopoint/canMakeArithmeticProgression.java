package jiang.twopoint;


import java.util.Arrays;

/**
 * 判断能否形成等差数列
 * 给你一个数字数组 arr 。
 *
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 *
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class canMakeArithmeticProgression {

    public static boolean canMakeArithmeticProgressionFun(int[] arr){

        boolean flag = false;

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if(arr[j] > arr[j + 1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }

        Arrays.sort(arr);


        for (int m = 0; m < arr.length; m++) {
            System.out.println(arr[m]);
        }

        int c = arr[0] - arr[1];

        int n = 0;

        for (n = 0; n < arr.length - 1; n++) {
            if(arr[n] - arr[n + 1] != c){
                return false;
            }
        }


        if(n == arr.length - 1){
            return true;
        }

        return flag;
    }


    public static void main(String[] args) {

        System.out.println(canMakeArithmeticProgressionFun(new int[]{-509,-19,-439,-264,-404,-369,-299,-89,-229,-54,-194,16,-544,-159,-124,-474,-334}));

    }


}
