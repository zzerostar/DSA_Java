package structure.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author zz
 * @date 2018/2/26
 */
public class DirectedGraph {

    private class Vertex {

        private String vertex;

        private int inDegree;

        private List<Edge> adjEdges;

        public Vertex(String label) {
            this.vertex = label;
            inDegree = 0;
            adjEdges = new ArrayList<>();
        }

    }

    private class Edge {
        private Vertex endVertex;

        public Edge(Vertex endVertex) {
            this.endVertex = endVertex;
        }
    }

    private Map<String, Vertex> directedGraph;

    /**
     * 创建图
     */
    public DirectedGraph(String fileName) {
        directedGraph = new LinkedHashMap<String, Vertex>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));

            Vertex startNode, endNode;
            String startNodeLabel, endNodeLabel;
            Edge e;

            String line;
            while ((line = br.readLine()) != null) {
                String[] nodesInfo = line.split(" ");
                startNodeLabel = nodesInfo[0];
                endNodeLabel = nodesInfo[1];

                startNode = directedGraph.get(startNodeLabel);
                if (startNode == null) {
                    startNode = new Vertex(startNodeLabel);
                    directedGraph.put(startNodeLabel, startNode);
                }
                endNode = directedGraph.get(endNodeLabel);
                if (endNode == null) {
                    endNode = new Vertex(endNodeLabel);
                    directedGraph.put(endNodeLabel, endNode);
                }
                e = new Edge(endNode); //每读入一行代表一条边
                startNode.adjEdges.add(e); //每读入一行数据,起始顶点添加一条边
                endNode.inDegree ++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void topoSort(){
        int count = 0;

        Queue<Vertex> queue = new LinkedList<>();
        Collection<Vertex> vertexes = directedGraph.values();
        for (Vertex vertex : vertexes) {
            if (vertex.inDegree == 0) {
                queue.offer(vertex);
            }
        }
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            System.out.print(v.vertex + " ");
            count++;
            for (Edge e : v.adjEdges) {
                if (--e.endVertex.inDegree == 0) {
                    queue.offer(e.endVertex);
                }
            }
        }
        if (count != directedGraph.size()) {
            //todo 环
        }
    }
}
