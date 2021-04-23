package jiang.Tree;

public class MaxDistance {

    static class Info{
        //最大距离
        public int MaxDistance;
        //树的高度
        public int height;

        public Info(int maxDistance, int hight) {
            MaxDistance = maxDistance;
            this.height = hight;
        }
        
    }


    public static Info process(Node head){
        if(head == null){
            return new Info(0,0);
        }

        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        int height = Math.max(leftInfo.height,rightInfo.height) + 1;

        int maxDistance = Math.max(Math.max(leftInfo.MaxDistance,rightInfo.MaxDistance)
                                ,rightInfo.height + leftInfo.height + 1);

        return new Info(maxDistance,height);
    }

    public static int  MaxDistanceTest(Node head){
        return process(head).MaxDistance;
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
        Node node10 = new Node(10);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node8.left = node9;
        node9.left = node10;

        System.out.println(MaxDistanceTest(node1));
    }


}
