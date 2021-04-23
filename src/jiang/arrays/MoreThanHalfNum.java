package jiang.arrays;

import java.util.Arrays;

public class MoreThanHalfNum {

    public static int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);

        System.out.println(array.toString());

        return 0;

    }




    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum_Solution(new int[]{1, 2, 2, 2, 2, 2, 3}));
    }


}
