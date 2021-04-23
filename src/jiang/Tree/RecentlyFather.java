package jiang.Tree;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RecentlyFather {


        public static void findAll(Node head, Map<Node,Node> map){
            if(head == null){
                return;
            }
            if(head.left != null){
                map.put(head.left,head);
                findAll(head.left,map);
            }

            if(head.right != null){
                map.put(head.right,head);
                findAll(head.right,map);
            }

        }

        public static Node RecentlyFatherTest(Node head,Node node1,Node node2){
            HashMap<Node, Node> map = new HashMap<>();
            map.put(head,null);
            findAll(head,map);

            HashSet<Node> set = new HashSet<>();
            set.add(node1);
            while(true){
                if (map.get(node1) == null){
                    break;
                }
                set.add(map.get(node1));
                node1 = map.get(node1);
            }

            while(true){
                if( set.contains(node2) ){
                    break;
                }

                node2 = map.get(node2);
            }


            return node2;

        }


    //每一次递归返回的信息
    static class Info{
        public Node ans;
        public boolean findNode1;
        public boolean findNode2;

        public Info(Node ans, boolean findNode1, boolean findNode2) {
            this.ans = ans;
            this.findNode1 = findNode1;
            this.findNode2 = findNode2;
        }
    }


    public static Info RF(Node head,Node node1,Node node2){
        if(head == null){
            return new Info(null,false,false);
        }

        Info leftInfo = RF(head.left,node1,node2);
        Info rightInfo = RF(head.right,node1,node2);


        boolean findNode1 = head == node1 || leftInfo.findNode1 || rightInfo.findNode1;
        boolean findNode2 = head == node2 || leftInfo.findNode2 || rightInfo.findNode2;

        Node ans = null;
        if(leftInfo.ans != null){
            ans = leftInfo.ans;
        }
        if (rightInfo.ans != null){
            ans = rightInfo.ans;
        }
        if(ans == null){
            if(findNode1 && findNode2){
                ans = head;
            }
        }

        return new Info(ans,findNode1,findNode2);
    }


    public static Node RecentlyFatherTest2(Node head,Node node1,Node node2){
        Info info = RF(head, node1, node2);

        System.out.println(info.ans);
        return info.ans;
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

        System.out.println(RecentlyFatherTest2(node1, node6, node7));


    }



}
