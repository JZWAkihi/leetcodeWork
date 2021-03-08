package jiang.Recursion;

import org.w3c.dom.ls.LSOutput;
import sun.java2d.pipe.OutlineTextRenderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 08.06. 汉诺塔问题
 *
 *在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 *
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 *
 * 你需要原地修改栈。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hanota-lcci
 *
 * 示例1:
 *
 *  输入：A = [2, 1, 0], B = [], C = []
 *  输出：C = [2, 1, 0]
 * 示例2:
 *
 *  输入：A = [1, 0], B = [], C = []
 *  输出：C = [1, 0]
 * 提示:
 *
 * A中盘子的数目不大于14个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hanota-lcci
 *
 * n = 1 时，直接把盘子从 A 移到 C；
 * n > 1 时，
 * 先把上面 n - 1 个盘子从 A 移到 B（子问题，递归）；
 * 再将最大的盘子从 A 移到 C；
 * 再将 B 上 n - 1 个盘子从 B 移到 C（子问题，递归）。
 *
 * 作者：z1m
 * 链接：https://leetcode-cn.com/problems/hanota-lcci/solution/tu-jie-yi-nuo-ta-de-gu-shi-ju-shuo-dang-64ge-pan-z/
 *
 *
 *
 *
 */
public class hanota {

    public static void hanotaTest(List<Integer> A, List<Integer> B, List<Integer> C){
        move(A.size(),A,B,C);
        System.out.println(C);
    }

    public static void move(int num,List<Integer> A, List<Integer> B, List<Integer> C){
        if (num == 1){
            C.add(A.remove(A.size() - 1));
            return;
        }

        move(num - 1,A,C,B);
        C.add(A.remove(A.size() - 1));
        move(num - 1,B,A,C);
    }



    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();

        hanotaTest(A,B,C);

    }
}
