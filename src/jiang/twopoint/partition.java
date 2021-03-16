package jiang.twopoint;


class Node{
      int val;
      Node next;
      Node() {}
      Node(int val) { this.val = val; }
}



public class partition {

    public static Node partition(Node head,int x){

        if (head == null)
            return null;

        if (head.next == null)
            return head;


        Node Lnode = new Node();
        Node Lnode1 = Lnode;
        Node Bnode = new Node();
        Node Bnode1 = Bnode;

        while(head != null){
            if (head.val < x){
                Lnode.next = head;
                Lnode = Lnode.next;
            }else{
                Bnode.next = head;
                Bnode = Bnode.next;
            }

            head = head.next;
        }
        Lnode.next = null;
        Bnode.next = null;
        Lnode.next = Bnode1.next;

        return Lnode1.next;

    }


    public static void main(String[] args) {
        Node node1 = new Node(6);
        Node node2 = new Node(5);
        Node node3 = new Node(4);
        Node node4 = new Node(3);
        Node node5 = new Node(2);
        Node node6 = new Node(1);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;


        Node partition = partition(node1, 3);

        while(partition != null){

            System.out.println(partition.val);
            partition = partition.next;

        }




    }
}
