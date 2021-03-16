package jiang.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 层次序列化
 *
 */
public class levelSerial {

    //序列化
    public static Queue<Integer> levelSerialTest(Node node){

        Queue<Integer> list = new LinkedList<>();

        if(node == null){
            list.add(null);
        }else{
            list.add(node.value);
            Queue<Node> queue  = new LinkedList<>();
            queue.add(node);

            while(!queue.isEmpty()){
                node = queue.poll();

                if (node.left != null){
                    queue.add(node.left);
                    list.add(node.left.value);
                }else{
                    list.add(null);
                }

                if(node.right != null){
                    queue.add(node.right);
                    list.add(node.right.value);
                }else {
                    list.add(null);
                }
            }
        }
        return list;
    }

    //反序列化



    public static Node BuildLevel(Queue<Integer> list){
        if(list == null || list.size() == 0){
            return null;
        }

        Integer integer = list.poll();
        Node head = generateNode(integer);
        Queue<Node> queue = new LinkedList<>();

        if (head != null){
            queue.add(head);
        }

        Node node = null;
        while(!queue.isEmpty()){
            node = queue.poll();

            node.left = generateNode(list.poll());
            node.right = generateNode(list.poll());

            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }

        }

        return head;
    }
    public static Node generateNode(Integer val){
        if (val == null)
            return null;

        return new Node(val);
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


        System.out.println(Arrays.toString(levelSerialTest(node1).toArray()));

        System.out.println(BuildLevel(levelSerialTest(node1)));

    }


}
