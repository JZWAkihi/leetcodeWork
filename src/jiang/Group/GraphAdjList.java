package jiang.Group;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphAdjList<E> implements Graph<E>{
    //邻接表中表对应的链表的顶点
    private static class ENode{
        int adjvex;//邻接顶点序号
        int wight;//存储边相关的信息
        ENode nextadj;//下一个邻接表结点

        public ENode(int adjvex,int wight){
            this.adjvex = adjvex;
            this.wight = wight;
        }
    }

    private static class VNode<E>{
        E data;//顶点信息
        ENode firstadj;  //邻接表的第一个节点
    }
    //顶点数组
    private VNode<E>[] vexs;
    //顶点的实际数量
    private int numOfVexs;
    //顶点的最大数量
    private int maxNumOfVexs;
    //判断顶点是否被访问过
    private boolean[] visited;

    public GraphAdjList(int maxNumOfVexs){
        this.maxNumOfVexs = maxNumOfVexs;
//        vexs = (VNode<E>[]) new Object[maxNumOfVexs];
        vexs = new VNode[maxNumOfVexs];
    }


    @Override
    public int getNumOfVertex() {
        return numOfVexs;
    }

    @Override
    public boolean insertVex(E v) {
        if (numOfVexs>=maxNumOfVexs){
            return false;
        }
        VNode<E> vex = new VNode<>();
        vex.data = v;
        vexs[numOfVexs++] = vex;
        return true;
    }

    @Override
    public boolean deleteVex(E v) {
        for (int i = 0; i < numOfVexs; i++) {
            if (vexs[i].data.equals(v)) {
                for (int j = i; j < numOfVexs - 1; j++) {
                    vexs[j] = vexs[j + 1];
                }
                vexs[numOfVexs - 1] = null;
                numOfVexs--;
                ENode current;
                ENode previous;
                for (int j = 0; j < numOfVexs; j++) {
                    if (vexs[j].firstadj == null)
                        continue;
                    if (vexs[j].firstadj.adjvex == i) {
                        vexs[j].firstadj = null;
                        continue;
                    }
                    current = vexs[j].firstadj;
                    while (current != null) {
                        previous = current;
                        current = current.nextadj;
                        if (current != null && current.adjvex == i) {
                            previous.nextadj = current.nextadj;
                            break;
                        }
                    }
                }
                for (int j = 0; j < numOfVexs; j++) {
                    current = vexs[j].firstadj;
                    while (current != null) {
                        if (current.adjvex > i)
                            current.adjvex--;
                        current = current.nextadj;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOfVex(E v) {

        for (int i = 0; i < numOfVexs; i++) {
            if(vexs[i].data.equals(v))
                return i;
        }

        return -1;
    }

    @Override
    public E valueOfVex(int v) {
        if(v<0 || v>=numOfVexs)
            return null;
        return vexs[v].data;
    }

    @Override
    public boolean insertEdge(int v1, int v2, int wight) {
        if (v1<0 || v2<0 || v1 > numOfVexs || v2 > numOfVexs)
            throw new ArrayIndexOutOfBoundsException();

        ENode vex1 = new ENode(v2,wight);

        //索引为index1的顶点没有临界顶点
        if(vexs[v1].firstadj == null){
            vexs[v1].firstadj = vex1;
        }else{
            vex1.nextadj = vexs[v1].firstadj;
            vexs[v1].firstadj = vex1;
        }

        ENode vex2 = new ENode(v1, wight);
        // 索引为index2的顶点没有邻接顶点
        if (vexs[v2].firstadj == null) {
            vexs[v2].firstadj = vex2;
        }else{
            vex2.nextadj = vexs[v2].firstadj;
            vexs[v2].firstadj = vex2;
        }
        return true;
    }

    @Override
    public boolean deleteEdge(int v1, int v2) {
        if (v1<0 || v2<0 || v1 > numOfVexs || v2 > numOfVexs)
            throw new ArrayIndexOutOfBoundsException();


        ENode current = vexs[v1].firstadj;
        ENode previous = null;
        while(current != null && current.adjvex != v2){
            previous = current;
            current = current.nextadj;
        }
        if (current != null){
            previous.nextadj = current.nextadj;
        }
        current = vexs[v2].firstadj;
        while(current != null && current.adjvex != v1){
            previous = current;
            current = current.nextadj;
        }

        if (current != null){
            previous.nextadj = current.nextadj;
        }

        return true;
    }

    @Override
    public int getEdge(int v1, int v2) {

        if (v1<0 || v2<0 || v1 > numOfVexs || v2 > numOfVexs)
            throw new ArrayIndexOutOfBoundsException();

        ENode current = vexs[v1].firstadj;
        while(current!=null){
            if (current.adjvex == v2){
                return current.wight;
            }
            current = current.nextadj;
        }
        return 0;
    }

    @Override
    public String depthFirstSearch(int v) {
        if(v<0 || v >= numOfVexs)
            throw new ArrayIndexOutOfBoundsException();

        visited = new boolean[numOfVexs];
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;

        ENode current;
        while(!stack.isEmpty()){
            v = stack.pop();
            sb.append(vexs[v].data + ",");
            current = vexs[v].firstadj;
            while(current != null){
                if(!visited[current.adjvex]){
                    stack.push(current.adjvex);
                    visited[current.adjvex] = true;
                }
                current = current.nextadj;
            }
        }

        return sb.length() > 0 ? sb.substring(0,sb.length() - 1) : null;
    }

    @Override
    public String breadFirstSearch(int v) {
        if (v < 0 || v >= numOfVexs)
            throw new ArrayIndexOutOfBoundsException();
        visited = new boolean[numOfVexs];
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(v);
        visited[v] = true;
        ENode current;
        while (!queue.isEmpty()) {
            v = queue.poll();
            sb.append(vexs[v].data + ",");
            current = vexs[v].firstadj;
            while (current != null) {
                if (!visited[current.adjvex]) {
                    queue.offer(current.adjvex);
                    visited[current.adjvex] = true;
                }
                current = current.nextadj;
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : null;
    }

    @Override
    public int[] dijkstra(int v) {
        return new int[0];
    }


    public static void main(String[] args) {
        GraphAdjList<Integer> graph = new GraphAdjList<>(10);

        graph.insertVex(0);
        graph.insertVex(1);
        graph.insertVex(2);
        graph.insertVex(3);
        graph.insertVex(4);
        graph.insertVex(5);
        graph.insertEdge(0,1,4);
        graph.insertEdge(1,2,3);
        graph.insertEdge(2,4,2);
        graph.insertEdge(1,3,4);
        graph.insertEdge(3,5,5);


        System.out.println(graph.breadFirstSearch(0));
        System.out.println(graph.depthFirstSearch(0));


    }
}
