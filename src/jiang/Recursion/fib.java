package jiang.Recursion;

public class fib {
    /**
     * 递归法 -----------------------  超时
     * @param n
     * @return
     */
    public static int fibTest(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return fibTest(n - 1) + fibTest(n - 2);
    }

    /**
     *添加一个数组作为一个记事本
     *    空间复杂度O(n)
     * @param n
     * @return
     */
    public static int fibTest1(int n){
        if (n == 0){
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        return dp[dp.length - 1];
    }

    /***
     *
     *在优化，，，，空间复杂度为O(n)
     *
     * @param n
     * @return
     */
    public static int fibTest2(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int num = 0;
        int b = 0;   //n-2
        int c = 1;   //n-1

        for (int i = 1; i < n; i++) {
            num = (b + c)%1000000007;
            b = c;
            c = num;
        }
        return num;
    }


    public static void main(String[] args) {
        System.out.println(fibTest2(1));
    }


}
