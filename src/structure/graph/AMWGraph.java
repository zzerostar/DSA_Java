package structure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import util.LogUtil;

/**
 * 图的邻接矩阵实现
 * @author zz
 * @date 2018/2/24
 */
public class AMWGraph {

    private static final String TAG = "AMWGraph";

    private static final int INFINITY = Integer.MAX_VALUE;

    private List<String> vertexList;

    private int[][] edges;

    private int numOfEdges;

    boolean visited[];

    boolean isDirected;


    public AMWGraph(int n, boolean isDirected) {
        vertexList = new ArrayList<>();
        edges = new int[n][n];
        numOfEdges = 0;
        visited = new boolean[n];

        this.isDirected = isDirected;

        initEdges(n);
    }

    private void initEdges(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    edges[i][j] = 0;
                } else {
                    edges[i][j] = INFINITY;
                }
            }
        }
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        if (!isDirected) {
            edges[v2][v1] = weight;
        }
        numOfEdges++;
    }

    public void insertEdge(int v1, int v2) {
        edges[v1][v2] = 1;
        if (!isDirected) {
            edges[v2][v1] = 1;
        }
        numOfEdges++;
    }

    public void deleteEdge(int v1, int v2) {
        edges[v1][v2] = 0;
        if (!isDirected) {
            edges[v2][v1] = 0;
        }
        numOfEdges--;
    }

    public String getVertexByIndex(int index) {
        return vertexList.get(index);
    }


    public void DFS(AMWGraph g, int i) {
        int j;
        visited[i] = true;
        //        LogUtil.d(TAG, "DFS -- > " + g.getVertexByIndex(i));
        for (j = 0; j < g.getNumOfVertex(); j++) {
            if (g.edges[i][j] == 1 && !visited[j]) {
                LogUtil.d(TAG, "DFS -- > " + "[" + i + "," + j + "]");
                DFS(g, j);
            }
        }

    }

    public void DFSTraverse() {
        int i;
        for (i = 0; i < getNumOfVertex(); i++) {
            visited[i] = false;
        }

        for (i = 0; i < getNumOfVertex(); i++) {
            if (!visited[i]) {
                DFS(this, i);
            }
        }
    }

    public void BFSTraverse() {
        int i, j;
        Queue<Integer> queue;
        for (i = 0; i < getNumOfVertex(); i++) {
            visited[i] = false;
        }
        queue = new LinkedBlockingQueue<>();
        for (i = 0; i < getNumOfVertex(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                LogUtil.d(TAG, "DFS -- > " + getVertexByIndex(i));
                queue.offer(i);
                while (!queue.isEmpty()) {
                    i = queue.poll();
                    for (j = 0; j < getNumOfVertex(); j++) {
                        if (edges[i][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            LogUtil.d(TAG, "DFS -- > " + "[" + i + "," + j + "]");
                            LogUtil.d(TAG, "DFS -- > " + getVertexByIndex(j));
                            queue.offer(j);
                        }
                    }
                }
            }
        }
    }

    /**
     * prim算法 最小生成树
     * 思路: 设图G顶点集合为U，首先任意选择图G中的一点作为起始点a，将该点加入集合V，
     * 再从集合U-V中找到另一点b使得点b到V中任意一点的权值最小，此时将b点也加入集合V；
     * 以此类推，现在的集合V={a，b}，再从集合U-V中找到另一点c使得点c到V中任意一点的权值最小，
     * 此时将c点加入集合V，直至所有顶点全部被加入V，此时就构建出了一颗MST。
     * 因为有N个顶点，所以该MST就有N-1条边，每一次向集合V中加入一个点，就意味着找到一条MST的边
     */
    public void miniSpanTreePrim() {
        int min, i, j, k;
        int adjvex[] = new int[getNumOfVertex()];  //保存相关顶点下标
        int lowcost[] = new int[getNumOfVertex()];  //保存相关顶点间边的权值

        lowcost[0] = 0;
        adjvex[0] = 0;

        for (i = 1; i < getNumOfVertex(); i++) {
            lowcost[i] = edges[0][i];
            adjvex[i] = 0;
        }

        for (i = 0; i < getNumOfVertex(); i++) {
            min = INFINITY;

            j = 1;
            k = 0;
            while (j < getNumOfVertex()) {
                if (lowcost[j] != 0 && lowcost[j] < min) {
                    min = lowcost[j];
                    k = j;
                }
                j++;
            }
            LogUtil.d(TAG, adjvex[k] + " ---- > " + k);
            lowcost[k] = 0;
            for (j = 1; j < getNumOfVertex(); j++) {
                if (lowcost[j] != 0 && edges[k][j] < lowcost[j]) {
                    lowcost[j] = edges[k][j];
                    adjvex[j] = k;
                }
            }
        }
    }

    /**
     * 最短路径dijkstra算法
     * 思路: 从vs开始,依次寻找与它最短的路径,并往外扩展,直到找到所有的最短路径
     *
     * @param vs
     */
    public void dijkstra(int vs) {
        boolean[] flag = new boolean[getNumOfVertex()];

        int[] prev = new int[getNumOfVertex()];
        int[] dist = new int[getNumOfVertex()];

        //初始化
        for (int i = 0; i < getNumOfVertex(); i++) {
            flag[i] = false;
            prev[i] = 0;
            dist[i] = edges[vs][i];
        }

        flag[vs] = true;
        dist[vs] = 0;

        int k = 0;

        for (int i = 1; i < getNumOfVertex(); i++) {
            // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k
            int min = INFINITY;
            for (int j = 0; j < getNumOfVertex(); j++) {
                if (!flag[j] && dist[j] < min) {
                    min = dist[j];
                    k = j;
                }
            }

            // 标记"顶点k"为已经获取到最短路径
            flag[k] = true;


            // 修正当前最短路径和前驱顶点
            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < getNumOfVertex(); j++) {
                int tmp = (edges[k][j] == INFINITY ? INFINITY : (min + edges[k][j]));
                if (!flag[j] && (tmp < dist[j])) {
                    dist[j] = tmp;
                    prev[j] = k;
                }

            }

        }

        // 打印dijkstra最短路径的结果
        System.out.printf("dijkstra(%s): \n", getVertexByIndex(vs));
        for (int i = 0; i < getNumOfVertex(); i++)
            System.out.printf("  shortest(%s, %s)=%d\n", getVertexByIndex(vs), getVertexByIndex(i), dist[i]);

    }

    /**
     * 最短路径floyd算法
     * 思路: 通过两个矩阵的值变换求解最短路径
     *
     */
    public void floyd() {
        int numOfVertex = getNumOfVertex();
        int[][] pathMatrix = new int[numOfVertex][numOfVertex];
        int[][] shortPathTable = new int[numOfVertex][numOfVertex];
        int v, w, k;
        for (v = 0; v < numOfVertex; v++) {
            for (w = 0; w < numOfVertex; w++) {
                shortPathTable[v][w] = edges[v][w];
                pathMatrix[v][w] = w;
            }
        }

        for (k = 0; k < numOfVertex; k++) {
            for (v = 0; v < numOfVertex; v++) {
                for (w = 0; w < numOfVertex; w++) {
                    //由于Int.Max相加会出现负值,所以认为其中一个为无穷大即和为无穷大
                    int temp = (shortPathTable[v][k] == INFINITY || shortPathTable[k][w] == INFINITY) ? INFINITY : shortPathTable[v][k] + shortPathTable[k][w];
                        if (shortPathTable[v][w] > temp) {
                            shortPathTable[v][w] = shortPathTable[v][k] + shortPathTable[k][w];
                            pathMatrix[v][w] = pathMatrix[v][k];
                        }
                }
            }
        }
    }

    private void showFloyd(int[][] pathMatrix, int[][] shortPathTable) {
        int k;
        for (int v = 0; v < getNumOfVertex(); v++) {
            for (int w = v + 1; w < getNumOfVertex(); w++) {
                LogUtil.d(TAG, String.format("v%d-v%d weight : %d", v, w, shortPathTable[v][w]));
                k = pathMatrix[v][w];
                LogUtil.d(TAG, String.format("path: %d", v));
                while (k != w) {
                    LogUtil.d(TAG, String.format("-->  %d", k));
                    k = pathMatrix[k][w];
                }

            }
        }
    }

}
