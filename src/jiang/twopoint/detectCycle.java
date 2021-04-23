package jiang.twopoint;


class CycleNode{
    int val;
    CycleNode next;

    CycleNode(int x) {
        val = x;
        next = null;
    }
}

/***
 * slow： 走过 x 个节点
 * fast：走过2x 个节点
 * 第一次相遇时，2x-x = b+c；    (1)
 * slow走过的距离为 x = a + b + n*(b + c);   (2)
 * 由(1)(2)可得 b+c = n*(b+c) + a + b；
 * n>0时，a+b = (1-n)*(b+c) <= 0,不成立。故n = 0,得出：a = c。
 */

public class detectCycle {

    public static CycleNode isCycle(CycleNode head){

        if(head.next == null || head.next.next == null)
            return null;

        CycleNode last = head.next;
        CycleNode quick = head.next.next;

        while(true){
            if(quick.next.next == null && quick.next == null){
                return null;
            }
            if(last == quick){
                return last;
            }
            last = last.next;

            quick = quick.next.next;
        }

    }

    public static CycleNode detectCycleTest(CycleNode head){
        if(head == null){
            return null;
        }

        //判断是否有环
        if(isCycle(head) == null){
            return null;
        }

        CycleNode node = isCycle(head);

        while(head != node){
            head = head.next;
            node = node.next;
        }

        return head;



    }


    public static void main(String[] args) {
        CycleNode node1 = new CycleNode(1);
        CycleNode node2 = new CycleNode(2);
        CycleNode node3 = new CycleNode(3);
        CycleNode node4 = new CycleNode(4);
        CycleNode node5 = new CycleNode(5);
        CycleNode node6 = new CycleNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        System.out.println(isCycle(node1).val);

        System.out.println(detectCycleTest(node1).val);

    }


}
