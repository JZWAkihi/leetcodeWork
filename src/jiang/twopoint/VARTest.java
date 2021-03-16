package jiang.twopoint;

public class VARTest {
    static int s;     //成员变量，类变量
    int i;            //成员变量，实例变量
    int j;            //成员变量，实例变量

    {
        int i = 1;      //非静态代码块中的局部变量
        i++;            //根据就近原则，这个i是非静态代码块中的局部变量，而不是成员变量
        j++;            //成员变量j
        s++;            //成员变量，类变量s
    }
    public void test(int j){       //形参，局部变量，j
        j++;
        i++;
        s++;
    }
    public static void main(String[] args) {  //形参，局部变量，args
        VARTest obj1 = new VARTest();         //局部变量，obj1
        VARTest obj2 = new VARTest();         //局部变量，obj2
        obj1.test(10);
        obj1.test(20);
        obj2.test(30);
        System.out.println(obj1.i + "," + obj1.j + "," + obj1.s);
        System.out.println(obj2.i + "," + obj2.j + "," + obj2.s);
    }
}