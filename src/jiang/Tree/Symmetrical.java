package jiang.Tree;

public class Symmetrical {
    public static boolean IsSymmetrical(Node head){
        if (head == null)
            return true;

        if (head.left == null && head.right == null) {
            return true;
        }else if(head.left != null && head.right != null){
            if(IsSymmetrical(head.left) && IsSymmetrical(head.right) && head.left.value == head.right.value){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(4);
        Node node6 = new Node(6);
        Node node7 = new Node(6);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
//        node4.left = node8;
//        node8.left = node9;
//        node9.left = node10;

        System.out.println(IsSymmetrical(node1));

    }


}
