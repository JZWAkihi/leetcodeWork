package jiang.twopoint;

/***
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */


public class isPalindrome {

    //我的方法:两个指针，指向前后，
    //在判断前后字符相等之前，需要循环将两个指针指向字母或者数字的位置
    public static boolean isnum(char a){
        if(a>=65 && a<=90 || a>=97 && a<=122 || a>=48 && a<=57){
            return true;
        }

        return false;

    }
    public static boolean isPalindromeTest(String s){
        boolean flag = true;
        int Ppre = 0;
        int Plast = s.length() - 1;


        while (Plast > Ppre){
            while(!isnum(s.charAt(Ppre))){
                if(Ppre >= s.length() - 1){
                    return flag;
                }
                Ppre++;
            }

            while (!isnum(s.charAt(Plast))){
                if(Plast <= 0){
                    return flag;
                }
                Plast--;
            }

            if (new String().valueOf(s.charAt(Ppre)).equalsIgnoreCase(new String().valueOf(s.charAt(Plast)))){
                Ppre++;
                Plast--;

                continue;
            }
            return false;

        }

        return flag;
    }



    public static void main(String[] args) {
        System.out.println(isPalindromeTest("a.b,."));
    }






}
