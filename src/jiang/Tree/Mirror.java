package jiang.Tree;

public class Mirror {

    /**
     *我们发现MirrorTest1()其实就是先序遍历
     *
     * @param head
     */
    public static void MirrorTest1(Node head){
        if (head == null){
            return;
        }

        Node temp = head.left;
        head.left = head.right;
        head.right = temp;

        MirrorTest1(head.left);
        MirrorTest1(head.right);
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

        MirrorTest1(node1);
        System.out.println(node1);

    }


}
