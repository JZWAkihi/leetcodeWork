package jiang.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class traverse {
    //递归先序
    public static void preOrder1(Node head){
        if(head == null){
            return;
        }

        System.out.print(head.value + "    ");
        preOrder1(head.left);
        preOrder1(head.right);
    }
    //递归中序
    public static void inOrder1(Node head){
        if (head == null)
            return;
        inOrder1(head.left);
        System.out.print(head.value + "    ");
        inOrder1(head.right);
    }
    //递归后序
    public static void posOrder(Node head){
        if (head == null){
            return;
        }

        posOrder(head.left);
        posOrder(head.right);
        System.out.print(head.value + "    ");
    }

    //非递归先序
    public static void preOrder2(Node head){
        if (head == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(head);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.value + "    ");
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        System.out.println();
    }

    //非递归中序
    public static void inOrder2(Node head){
        if (head == null)
            return;

        //申请一个栈，初始时，令变量cur = head
        Stack<Node> stack = new Stack<Node>();

        //对以cur节点为头的整颗子树来说，依次把左边界压入栈中，即不停的令cur = cur.left;
        while(!stack.isEmpty() || head != null){
            if (head != null){
                stack.push(head);
                head = head.left;
            }else{
                head = stack.pop();
                System.out.print(head.value + "    ");
                head = head.right;
            }
        }
        System.out.println();
    }

    //非递归后序 两个栈
    public static void posOrder2(Node head){
        if (head == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack1 = new Stack<>();

        stack.push(head);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            stack1.push(node);

            if(node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }

        while (!stack1.isEmpty()){
            System.out.print(stack1.pop().value + "    ");
        }
        System.out.println();
    }

    //非递归后序 一个栈
    public static void posOrder3(Node head){
        if (head == null)
            return;

        //申请一个栈，将头节点压入栈，同时设置两个变量h,c。。
        //在整个流程中  h代表最近一次弹出并打印的节点，c代表stack的栈顶节点，初始时h为头节点c为null
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node c = null;
        while(!stack.isEmpty()){
            //每次令c等于当前stack的栈顶节点，但是不从stack中弹出，此时分三种情况
            c = stack.peek();
            //如果c的左孩子不为null，并且head不等于c的左孩子。也不等于c的右孩子，则把c的左孩子压入stack中
            // head的意义是最近一次弹出并打印的节点，所以如果head == c的左孩子或者右孩子，
            // 说明c的左子树于右子树已经打印完毕，此时不应该将c 的左孩子放入stack中
            //第一个分支的意思是此时左子树还没有处理
            if (c.left != null && head != c.left && head != c.right){
                stack.push(c.left);
            }else if(c.right != null && head != c.right){
                //右子树还没处理
                stack.push(c.right);
            }else{
                //此时说明左右子树都打印完了
                System.out.print(stack.pop().value + "    ");
                head = c;
            }
        }

        System.out.println();
    }

    public static void levelOrder(Node head){
        if (head == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.value + "    ");

            if(node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        //递归先序遍历
        preOrder1(node1);
        System.out.println();
        //非递归先序遍历
        preOrder2(node1);
        System.out.println("=====================================");
        //递归中序遍历
        inOrder1(node1);
        System.out.println();
        //非递归中序遍历
        inOrder2(node1);
        System.out.println("=====================================");

        //递归后序遍历
        posOrder(node1);
        System.out.println();
        //非递归后序遍历
        posOrder2(node1);
        posOrder3(node1);
        System.out.println("=====================================");

        //层次遍历
        levelOrder(node1);
    }
}
