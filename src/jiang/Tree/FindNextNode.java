package jiang.Tree;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NextNode{
    int value;
    NextNode left;
    NextNode right;
    NextNode parent;

    public NextNode(int value) {
        this.value = value;
    }
    public void setNode(NextNode left,NextNode right,NextNode parent){
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

}



public class FindNextNode {

    public static NextNode findLeftNode(NextNode node){
        if(node == null){
            return null;
        }

        if(node.left == null){
            return node;
        }

        return findLeftNode(node.left);
    }


    public static NextNode findNextNodeTest(NextNode node){
        if(node.right != null){
            return findLeftNode(node.right);
        }

        NextNode parentNode = node.parent;

        while(parentNode != null && parentNode.right ==node){
            node = parentNode;
            parentNode = node.parent;
        }
        return parentNode;
    }


    public static void findAllNextNode(NextNode node, List<NextNode> list){
        if(node == null){
            return;
        }
        if(node.left != null){
            findAllNextNode(node.left,list);
        }

        list.add(node);

        if(node.right != null){
            findAllNextNode(node.right,list);
        }
    }
    public static NextNode findNextNodeTest2(NextNode node){
        NextNode par = node;

        while(par.parent != null){
            par = par.parent;
        }


        List<NextNode> list = new ArrayList<>();

        findAllNextNode(par,list);
        System.out.println(list);

        for (int i = 0; i < list.size() - 1; i++) {
            if(list.get(i).equals(node)){
                return list.get(i + 1);
            }
        }


        return null;
    }

    public static void main(String[] args) {
        NextNode node1 = new NextNode(1);
        NextNode node2 = new NextNode(2);
        NextNode node3 = new NextNode(3);
        NextNode node4 = new NextNode(4);
        NextNode node5 = new NextNode(5);
        NextNode node6 = new NextNode(6);
        NextNode node7 = new NextNode(7);
        NextNode node8 = new NextNode(8);
        NextNode node9 = new NextNode(9);


        node1.setNode(node2,node3,null);
        node2.setNode(node4,node5,node1);
        node3.setNode(node6,node7,node1);
        node4.setNode(node8,null,node2);
        node5.setNode(null,null,node2);
        node6.setNode(null,null,node3);
        node7.setNode(null,null,node3);
        node8.setNode(node9,null,node4);
        node9.setNode(null,null,node8);

        ArrayList<NextNode> list = new ArrayList<>();

        NextNode node = findNextNodeTest2(node1);
        System.out.println(node.value);

    }

}
