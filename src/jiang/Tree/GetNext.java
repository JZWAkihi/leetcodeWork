package jiang.Tree;


import java.util.LinkedList;
/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
class TreeLinkNode{
    public int value;
    public TreeLinkNode right;
    public TreeLinkNode left;
    public TreeLinkNode parent;

    public TreeLinkNode() {
    }

    public TreeLinkNode(int value, TreeLinkNode right, TreeLinkNode left, TreeLinkNode parent) {
        this.value = value;
        this.right = right;
        this.left = left;
        this.parent = parent;
    }
}


public class GetNext {

    //暴力法
    public static TreeLinkNode getNext(TreeLinkNode node,TreeLinkNode head){
        LinkedList<TreeLinkNode> lists = new LinkedList<>();
        get(head,lists);

        while(!lists.isEmpty()){
            if (lists.pop().value == node.value){
                if (lists.peek() == null)
                    return null;
                return lists.pop();
            }
        }

        return null;


    }

    public static void get(TreeLinkNode node,LinkedList list){

        if (node == null)
            return;

        if(node.left != null){
            get(node.left,list);
        }
        list.add(node);
        if (node.right != null){
            get(node.right,list);
        }
    }

    //
    public static TreeLinkNode getSuccessorNode(TreeLinkNode node){

        if (node == null){
            return node;
        }

        if(node.right == null){
            return getLeftMost(node.right);
        }else{
            TreeLinkNode parent = node.parent;

            //当前节点是其父亲节点右孩子
            while(parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }

            return parent;
        }
    }


    public static TreeLinkNode getLeftMost(TreeLinkNode node){
        if(node == null){
            return node;
        }

        while(node.left != null){
            node = node.left;
        }

        return node;
    }
    



    public static void main(String[] args) {



    }

}
