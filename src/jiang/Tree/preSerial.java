package jiang.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 先序方式序列化
 *
 */
public class preSerial {

    //序列化
    public static Queue<Integer> preSerialTest(Node node){
        Queue<Integer> queue = new LinkedList<>();
        pres(node,queue);
        return queue;
    }
    public static void pres(Node head,Queue<Integer> queue){
        if (head == null){
            queue.add(null);
        }else{
            queue.add(head.value);
            pres(head.left,queue);
            pres(head.right,queue);
        }
    }

    //反序列化
    public static Node BuildPreQueue(Queue<Integer> prelist){
        if (prelist == null || prelist.size() == 0){
            return null;
        }

        return buildPreQueue(prelist);
    }

    public static Node buildPreQueue(Queue<Integer> queue){
        Integer integer = queue.poll();

        if (integer == null) {
            return null;
        }
        Node head = new Node(integer);
        head.left = buildPreQueue(queue);
        head.right = buildPreQueue(queue);

        return head;
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

        Queue<Integer> queue = preSerialTest(node1);

        //System.out.println(Arrays.toString(queue.toArray()));

        System.out.println(buildPreQueue(queue));


    }



}
