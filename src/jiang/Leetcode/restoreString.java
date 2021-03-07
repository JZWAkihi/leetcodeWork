package jiang.Leetcode;


import java.util.Arrays;

/***
 *
 *
 *重新排列字符串
 *给你一个字符串 s 和一个 长度相同 的整数数组 indices。
 *
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 *
 * 返回重新排列后的字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class restoreString {
    public static String restoreStringFun(String s, int[] indices) {
//
//        StringBuffer sb = new StringBuffer();
//
//        for (int i = 0; i < indices.length; i++) {
//            sb.append(s.charAt(indices[i]));
//        }
//
//        System.out.println(sb);
//        return sb.toString();


        int length = s.length();
        char[] result = new char[length];

        for (int i = 0; i < length; i++) {
//            result[indices[i]] = s.charAt(i);
//            result[i] = s.charAt(indices[i]);
        }
        return new String(result);

    }

    public static void main(String[] args) {
        System.out.println(restoreStringFun("codeleet", new int[]{4,5,6,7,0,2,1,3}));
    }
}
