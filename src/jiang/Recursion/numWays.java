package jiang.Recursion;

/***
 * 递归问题
 *
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 *
 *示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 *
 */
public class numWays {
    /**
     * 递归  ---------------- 超时
     *
     * @param n
     * @return
     */
    public static int numWays(int n){
        if(n == 0)
            return 1;
        if(n == 1 || n == 2){
            return n;
        }

        return numWays(n - 1) + numWays(n - 2);

    }


    /***
     *
     * 空间复杂度 O(n)
     * @param n
     * @return
     */
    public static int numWays1(int n){
        if(n == 0)
            return 1;
        if(n == 1 || n == 2){
            return n;
        }
        int num = 0;
        int a = 2;   //n - 1
        int b = 1;   //n - 2


        for (int i = 2; i < n; i++) {
            num = (a + b) % 1000000007;
            b = a;
            a = num;
        }

        return num;
    }



    public static void main(String[] args) {
        System.out.println(numWays1(0));
    }
}
