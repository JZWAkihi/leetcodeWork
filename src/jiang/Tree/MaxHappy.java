package jiang.Tree;

import java.util.ArrayList;
import java.util.List;

class Employee{
    public int happy;
    List<Employee> subordinates;

    public Employee(int happy) {
        this.happy = happy;
    }
}


/***
 * 公司的人员结构可以看作是一颗标准的没有环的多叉树，树的肉头点是唯一的老板，
 * 除老板外每个员工的都有唯一的直接上级。
 * 叶节点是没有任何我下属的基层员工，
 * 除基层员工外，每个员工都有一个或多个直接下级
 */


/***
 * 派对的最大快乐值，你可以决定哪些员工来，哪些员工不来，规则
 *
 * 1.如果某个员工来了，那么这个员工的所有直接下级都不能来，
 * 2.派对的整体快乐值是所有到场员工快乐值的累加
 * 3.你的目标的是让派对的整体的快乐值尽量大
 *
 * 给定一颗多叉树的头节点boss 请返回派对的最大快乐值
 *
 */
public class MaxHappy{

    //每一次递归返回的信息
    static class Info{
        //头节点来时最大快乐值
        public int withHead;
        //头节点不来是最大快乐值
        public int withOutHead;

        public Info(int withHead, int withOutHead) {
            this.withHead = withHead;
            this.withOutHead = withOutHead;
        }
    }

    public static Info process(Employee e){
        //如果是基层员工
        //返回一个Info  第一个参数，如果这个员工参加的快乐值，如果这个员工不参加的快乐值为0
        if(e.subordinates == null){
            return new Info(e.happy,0);
        }

        //如果不是基层员工
        //定义两个变量  。如果这个员工参加  或者这个员工不参加

        //如果参加需要先加上这位员工的快乐值
        int withHeadHappy = e.happy;
        int withOutHeadHappy = 0;

        //对这位员工的直接下层进行循环访问
        for(Employee next : e.subordinates){
            //得到下属的信息
            Info nextInfo = process(next);
            //如果这位员工参加，那么它的直接下属不能参加，所以于下属的withOutHead相加
            withHeadHappy += nextInfo.withOutHead;
            ///如果这位员工不参加，那么它的直接下属可以参加，所以于下属的withHead相加
            withOutHeadHappy += Math.max(nextInfo.withHead,nextInfo.withOutHead);
        }
        //返回这个员工参加或不参加有的快乐值
        return new Info(withHeadHappy,withOutHeadHappy);
    }

    public static int  MaxHappyTest(Employee employee){
        Info process = process(employee);
        return process.withOutHead > process.withHead ? process.withOutHead : process.withHead;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);
        Employee employee4 = new Employee(4);
        Employee employee5 = new Employee(5);
        Employee employee6 = new Employee(6);
        Employee employee7 = new Employee(7);

        ArrayList<Employee> list = new ArrayList<>();
        list.add(employee2);
        list.add(employee3);
        employee1.subordinates = list;
        list = new ArrayList<>();
        list.add(employee4);
        list.add(employee5);
        employee2.subordinates = list;
        list = new ArrayList<>();
        list.add(employee6);
        list.add(employee7);
        employee3.subordinates = list;

        System.out.println(MaxHappyTest(employee1));

    }




}
