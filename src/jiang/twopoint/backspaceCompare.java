package jiang.twopoint;

import java.util.Stack;

/***
 * 比较含退格的字符串
 *
 *给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 *
 */
public class backspaceCompare {

    public static boolean backspaceCompareTest(String S, String T) {
        Stack<Character> S1 = new Stack<>();
        Stack<Character> S2 = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '#'){
                if (!S1.empty()){
                    S1.pop();
                }
            }else{
                S1.push(S.charAt(i));
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if(T.charAt(i) == '#'){
                if (!S2.empty()){
                    S2.pop();
                }
            }else{
                S2.push(T.charAt(i));
            }
        }

        while(!S1.empty() && !S2.empty()) {
            if(S1.pop() != S2.pop()){
                flag = false;
            }
        }
        if (!S1.empty() || !S2.empty()){
            flag = false;
        }

        return flag;

    }


    public static void main(String[] args) {
        System.out.println(backspaceCompareTest("ab#c", "ad#c"));
    }

}
