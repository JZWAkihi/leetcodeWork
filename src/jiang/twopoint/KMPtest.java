package jiang.twopoint;

public class KMPtest {

    public static void makeNext(char[] P,int next[]){

        //q:模板字符串的下标
        //k:最大前后缀长度
        int q,k;

        //m : 模板字符串长度
        int m = P.length;

        //模板字符串的第一个字符的最大前后缀长度为0
        next[0] = 0;

        //for循环，第二个字符开始，依次计算每一个字符对应的next值
        for (k = 0,q = 1; q < m; ++q) {
            //求出P[0].....P[q]的最大的相同的前后缀长度k
            while(k > 0 && P[q] != P[k])
                k = next[k-1];

            //如果相等，那么最后的相同的前后缀长度加1
            if (P[q] == P[k]){
                k++;
            }

            next[q] = k;
        }
    }



    public static void main(String[] args) {

        char[] P = new char[]{'A','B','C','D','A','B','D'};

        int[] next = new int[7];

        makeNext(P,next);
    }



}
