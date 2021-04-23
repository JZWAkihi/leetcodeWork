package jiang.Tree;

import sun.font.TrueTypeFont;

public class ACLTest {

    //每一次递归传递的信息
    static class MSG{
        int height;
        boolean isAVLTree;

        public MSG() {
        }

        public MSG(int height, boolean isAVLTree) {
            this.height = height;
            this.isAVLTree = isAVLTree;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public boolean isAVLTree() {
            return isAVLTree;
        }

        public void setAVLTree(boolean AVLTree) {
            isAVLTree = AVLTree;
        }
    }


    public static MSG isAVL(Node head){
        if(head == null){
            return new MSG(0, true);
        }

        MSG msgLeft = isAVL(head.left);
        MSG msgRight = isAVL(head.right);

        MSG msg = new MSG();

        msg.height = Math.max(msgLeft.height,msgRight.height) + 1;
        msg.isAVLTree = msgLeft.isAVLTree && msgRight.isAVLTree && (Math.abs(msgLeft.height - msgRight.height) <= 1);

        return msg;
    }


    public static boolean isAVLTest(Node head){
        MSG avl = isAVL(head);

        return avl.isAVLTree;


    }
}
