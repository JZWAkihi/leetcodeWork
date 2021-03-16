package jiang.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {

    public static int max(int a,int b){
        return a > b ? a: b;
    }

    /***
     *
     * 递归法
     * @param head
     * @return
     */
    public static int TreeDepthTest1(Node head){
        return head == null? 0 : max(TreeDepthTest1(head.right),TreeDepthTest1(head.left)) + 1;
    }

    /**
     * 迭代法
     * @param head
     * @return
     */
    public static int TreeDepthTest2(Node head){
        int depth = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while(!queue.isEmpty()){
            int i = 0;  //记录队列中有多少个Node
            i = queue.size();
            while(i != 0){
                Node node = queue.remove();
                if (node.right != null){
                    queue.add(node.right);
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                i--;
            }
            depth++;
        }


        return depth;
    }

    public static void main(String[] args) {


        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node8.left = node9;


        System.out.println(TreeDepthTest2(node1));

    }


}
