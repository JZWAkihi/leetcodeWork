package jiang.twopoint;

public class rotateRight {

    public static Node rotateRightTest(Node head,int k){

        if (k == 0)
            return head;

        Node node = head;
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        k = k%count;
        head = node;
        int i = k;
        while(i > 0){
            i--;
            head = head.next;
        }

        Node over = node;
        while(head.next != null){
            head = head.next;
            over = over.next;
        }

        head.next = node;
        node = over.next;
        over.next = null;

        return node;

    }


    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);


        node0.next = node1;
        node1.next = node2;


        Node node = rotateRightTest(node0, 0);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }



    }


}
