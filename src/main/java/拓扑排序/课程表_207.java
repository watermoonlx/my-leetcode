package 拓扑排序;

import java.util.*;

public class 课程表_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(prerequisites);
        while (numCourses > 0 && !graph.isEmpty()) {
            Vertex v = graph.pollLeastInDegreeVertex();
            if (v.inDegree > 0) {
                return false;
            }
            numCourses--;
        }

        return true;
    }

    private static class Graph {
        private List<Vertex> vertexes;

        public Graph(int[][] prerequisites) {
            HashMap<Integer, Vertex> vertexes = new HashMap<>();
            for (int[] prerequisite : prerequisites) {
                Vertex v = vertexes.getOrDefault(prerequisite[1], new Vertex(prerequisite[1]));
                Vertex adjV = vertexes.getOrDefault(prerequisite[0], new Vertex(prerequisite[0]));
                adjV.inDegree++;
                v.adjacentVertexes.add(adjV);
                vertexes.put(v.val, v);
                vertexes.put(adjV.val, adjV);
            }
            this.vertexes = new LinkedList<>(vertexes.values());
        }

        public Vertex pollLeastInDegreeVertex() {
            Vertex leastInDegree = null;
            for (Vertex v : vertexes) {
                if (leastInDegree == null) {
                    leastInDegree = v;
                } else if (v.inDegree < leastInDegree.inDegree) {
                    leastInDegree = v;
                }
            }
            if (leastInDegree != null) {
                for (Vertex v : leastInDegree.adjacentVertexes) {
                    v.inDegree--;
                }
                this.vertexes.remove(leastInDegree);
            }
            return leastInDegree;
        }

        public boolean isEmpty() {
            return this.vertexes.isEmpty();
        }
    }


    private static class Vertex {
        public int inDegree = 0;
        public int val;
        public List<Vertex> adjacentVertexes = new ArrayList<>();

        public Vertex(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println(new 课程表_207().canFinish(3, new int[][]{{1, 0}, {2, 1}}));
    }

}
