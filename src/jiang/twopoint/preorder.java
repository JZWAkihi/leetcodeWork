package jiang.twopoint;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 589. N 叉树的前序遍历
 *
 *给定一个 N 叉树，返回其节点值的 前序遍历 。
 *
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *
 输入：root = [1,null,3,2,4,null,5,6]
 输出：[1,3,5,6,2,4]
 *
 *
 */

class NodeNTree{
    public int val;
    public List<NodeNTree> children;

    public NodeNTree() {
    }

    public NodeNTree(int val) {
        this.val = val;
    }

    public List<NodeNTree> getChildren() {
        return children;
    }

    public void setChildren(List<NodeNTree> children) {
        this.children = children;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "NodeNTree{" +
                "val=" + val +
                ", children=" + children +
                '}';
    }
}



public class preorder {

    public static List<Integer> preorderTest(NodeNTree node){
        List<Integer> list = new ArrayList<>();

        if(node == null)
            return list;

        pro(node,list);

        return list;

    }

    public static void pro(NodeNTree node,List<Integer> list){
        if (node == null)
            return;
        list.add(node.getVal());

        for (int i = 0; i<node.children.size(); i++) {
            pro(node.children.get(i),list);
        }
        

    }





    public static void main(String[] args) {
        NodeNTree node1 = new NodeNTree(1);
        NodeNTree node2 = new NodeNTree(2);
        NodeNTree node3 = new NodeNTree(3);
        NodeNTree node4 = new NodeNTree(4);
        NodeNTree node5 = new NodeNTree(5);
        NodeNTree node6 = new NodeNTree(6);
        NodeNTree node7 = new NodeNTree(7);

        LinkedList<NodeNTree> trees = new LinkedList<>();
        trees.add(node2);
        trees.add(node3);
        trees.add(node4);
        node1.setChildren(trees);

        trees.clear();
        trees.add(node5);
        trees.add(node6);
        trees.add(node7);
        node2.setChildren(trees);

        List<Integer> list = preorderTest(node1);

        for (int l : list) {
            System.out.println(l + "    ");
        }


    }




}
