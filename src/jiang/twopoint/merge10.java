package jiang.twopoint;

import java.util.Arrays;

public class merge10 {
    public static void mergeTest(int[] A, int m, int[] B, int n) {
        int[] copy = new int[A.length];

        int ap = 0;
        int bp = 0;
        int cp = 0;

        while(ap < m && bp < n){
            if (A[ap] >= B[bp]){
                copy[cp] = B[bp];
                cp++;
                bp++;
            }else{
                copy[cp] = A[ap];
                ap++;
                cp++;
            }
        }

        if (ap != m && bp == n){
            while(ap < m){
                copy[cp] = A[ap];
                ap++;
                cp++;
            }
        }

        if (bp != n && ap == m){
            while(bp != n){
                copy[cp] = B[bp];
                bp++;
                cp++;
            }
        }


        A = copy;

        System.out.println(Arrays.toString(A));

    }


    public static void main(String[] args) {
        mergeTest(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
}
