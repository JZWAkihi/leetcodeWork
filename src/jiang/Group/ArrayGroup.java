package jiang.Group;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;



public class ArrayGroup{
    //存储顶点集合
    private ArrayList<String> verexList;

    //存储图对应的邻接矩阵
    private int[][] edges;

    //表示边的数目
    private int numofEdges;

    //定义给数组boolean[] 记录某个节点是否被访问
    private boolean[] isVisited;




    //构造器
    public ArrayGroup(int n){
        //初始化矩阵和vertexList
                edges = new int[n][n];
        verexList = new ArrayList<String>(n);
        numofEdges = 0;
    }

    //插入节点
    public void insertVertex(String vertex){
        verexList.add(vertex);
    }


    //添加边
    public void insertEdges(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numofEdges++;
    }


    //返回节点的个数
    public int getNumofVertex(){
        return verexList.size();

    }

    //返回边个数
    public int getNumofEdges(){
        return numofEdges;
    }

    //返回结点i对应的数据
    public String getValueByIndex(int i){
        return verexList.get(i);
    }

    //返回v1,v2的权值
    public int getWight(int v1,int v2){
        return edges[v1][v2];
    }


    //显示图对应的矩阵
    public void showGraph(){
        for(int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }


    //得到第一个邻接点的小标w
    public int getFirstNeighbor(int index){
        for (int j = 0;j<verexList.size();j++){
            if(edges[index][j] > 0){
                return j;
            }
        }


        return -1;
    }



    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1,int v2){
        for (int j = v2 + 1; j < verexList.size(); j++) {
            if (edges[v1][v2] > 0){
                return j;
            }
        }


        return -1;
    }

    //深度优先遍历算法
    public void dfs(boolean[] isVisited,int i){
        //首先我们访问该节点
        System.out.print(getValueByIndex(i) + "->");

        //将节点设置为已经访问
        isVisited[i] = true;

        //查找节点i的第一个邻接节点w
        int w = getFirstNeighbor(i);

        while (w == -1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }

            w = getNextNeighbor(i,w);

        }

    }


    //对dfs进行重载，遍历我们所有的节点，并进行dfs
    public void dfs(){
        isVisited = new boolean[verexList.size()];

        //遍历所有节点，进行dfs[回溯]
        for (int i = 0; i < getNumofVertex(); i++) {
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }


    //对一个节点广度优先遍历
    private void bfs(boolean[] isVisited,int i){
        int u;//表示队列的头节点对应的下标
        int w;//邻接节点w

        //队列，记录节点访问的顺序
        LinkedList queue = new LinkedList();

        //访问节点，输出节点信息
        System.out.print(getValueByIndex(i) + "->");


        //标记为已经访问
        isVisited[i] = true;

        //将节点加入队列中
        queue.addLast(i);


        while(!queue.isEmpty()){
            //取出队列的头节点下标
            u = (Integer) queue.removeFirst() ;

            //得到第一个邻接节点的下标w
            w = getFirstNeighbor(u);

            while(w == -1){
                if(!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "->");
                }
                isVisited[w] = true;
                queue.addLast(w);
            }

            w = getNextNeighbor(u,w);
        }
    }

    public void bfs(){
        isVisited = new boolean[verexList.size()];

        for (int i = 0; i < getNumofVertex(); i++) {
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }

    }


    public static void main(String[] args){
        int n = 5;
        String VertexValue[] = {"A","B","C","D","E"};
        ArrayGroup group = new ArrayGroup(n);

        for(String value : VertexValue){
            group.insertVertex(value);
        }

        group.insertEdges(0,1,1);
        group.insertEdges(0,2,1);
        group.insertEdges(1,2,1);
        group.insertEdges(1,3,1);
        group.insertEdges(1,4,1);

        group.showGraph();

        group.dfs();

        System.out.println();

        group.bfs();

    }
}