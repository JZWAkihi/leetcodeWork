package jiang.Recursion;

/***
 *
 *1137. 第 N 个泰波那契数
 *
 *泰波那契序列 Tn 定义如下： 
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 *
 *
 */
public class tribonacci {

    public static int tribonacciTest(int n){
        if(n == 0 || n == 1){
            return n;
        }
        if (n == 2){
            return 1;
        }


        int num = 0;
        int a = 1;     //n-1
        int b = 1;     //n-2
        int c = 0;     //n-3

        for (int i = 2; i < n; i++) {
            num = a + b + c;
            c = b;
            b = a;
            a = num;
        }

        return num;
    }



    public static void main(String[] args) {
        System.out.println(tribonacciTest(25));
    }
}
