package jiang.Group;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphAdjMatrix<E> implements Graph<E> {

    //存储图的顶点的一位数组
    private E[] vexs;
    //存储图的边的二维数组
    private int[][] edges;
    //顶点的实际数量
    private int numOfVexs;
    //顶点的最大数量
    private int maxNumOfVexs;
    //判断顶点是否被访问
    private boolean[] visited;

    public GraphAdjMatrix(int maxNumOfVexs,Class<E> type){
        this.maxNumOfVexs = maxNumOfVexs;
        edges = new int[maxNumOfVexs][maxNumOfVexs];
//        vexs = (E[])Array.newInstance(type,maxNumOfVexs);
        vexs = (E[])new Object[maxNumOfVexs];
    }



    @Override
    public int getNumOfVertex() {
        return numOfVexs;
    }

    @Override
    public boolean insertVex(E v) {
        if(numOfVexs>=maxNumOfVexs){
            return false;
        }
        vexs[numOfVexs++] = v;
        return true;
    }

    @Override
    public boolean deleteVex(E v) {
        for (int i = 0; i < numOfVexs; i++) {
            if(vexs[i].equals(v)){
                for (int j = i; j < numOfVexs - 1; j++) {
                    vexs[j] = vexs[j + 1];
                }
                vexs[numOfVexs  -1] = null;

                for (int col = i; col < numOfVexs - 1; col++) {
                    for (int row = 0; row < numOfVexs; row++) {
                        edges[col][row] = edges[col + 1][row];
                    }
                }

                for (int row = i;row < numOfVexs - 1;row++){
                    for (int col = 0; col < numOfVexs; col++) {
                        edges[col][row] = edges[col][row + 1];
                    }
                }

                numOfVexs--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOfVex(E v) {
        for (int i = 0; i < numOfVexs; i++) {
            if (vexs[i].equals(v)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public E valueOfVex(int v) {
        if (v < 0 || v >= numOfVexs)
            return null;

        return vexs[v];
    }

    @Override
    public boolean insertEdge(int v1, int v2, int wight) {
        if(v1 < 0 || v2 < 0 || v1 > numOfVexs || v2 > numOfVexs)
            throw new ArrayIndexOutOfBoundsException();

        edges[v1][v2] = wight;
        edges[v2][v1] = wight;
        return true;
    }

    @Override
    public boolean deleteEdge(int v1, int v2) {
        if(v1 < 0 || v2 < 0 || v1 > numOfVexs || v2 > numOfVexs)
            throw new ArrayIndexOutOfBoundsException();

        edges[v1][v2] = 0;
        edges[v2][v1] = 0;

        return true;
    }

    @Override
    public int getEdge(int v1, int v2) {
        if(v1 < 0 || v2 < 0 || v1 > numOfVexs || v2 > numOfVexs)
            throw new ArrayIndexOutOfBoundsException();
        return edges[v1][v2];
    }

    @Override
    public String depthFirstSearch(int v) {
        if(v<0 || v>=numOfVexs)
            throw  new ArrayIndexOutOfBoundsException();

        visited = new boolean[numOfVexs];

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;
        while(!stack.isEmpty()){
            v = stack.pop();
            sb.append(vexs[v] + ",");
            for (int i = numOfVexs - 1; i >= 0; i--) {
                if((edges[v][i] != 0 && edges[v][i] != Integer.MAX_VALUE) && !visited[i]){
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }

        return sb.length() > 0 ? sb.substring(0,sb.length() - 1) : null;
    }

    @Override
    public String breadFirstSearch(int v) {
        if (v < 0 || v>= numOfVexs)
            throw new ArrayIndexOutOfBoundsException();

        visited = new boolean[numOfVexs];

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        while(!queue.isEmpty()){
            v = queue.poll();
            sb.append(vexs[v] + ",");
            for (int i = 0; i < numOfVexs; i++) {
                if ((edges[v][i] != 0 && edges[v][i] != Integer.MAX_VALUE) && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

        return sb.length() > 0 ? sb.substring(0,sb.length() - 1) : null;
    }

    @Override
    public int[] dijkstra(int v) {
        return new int[0];
    }

    public void showGraph(){
        for (int[] link:edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    public static void main(String[] args) {
        GraphAdjMatrix<Integer> graph = new GraphAdjMatrix<>(10, Integer.TYPE);

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

        graph.showGraph();
        System.out.println(graph.depthFirstSearch(0));
        System.out.println(graph.breadFirstSearch(0));
    }


}
